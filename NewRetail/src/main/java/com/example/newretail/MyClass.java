package com.example.newretail;

import com.example.newretail.Upload.ImageUpload;
import com.example.newretail.function.DeviceUse;
import com.example.newretail.imgcotout.GetCutOut;
import com.example.newretail.login.Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class MyClass extends BaseURL {

    private static WebDriver webDriver = new FirefoxDriver();

    private static DeviceUse deviceUse = new DeviceUse();


    public static void main(String[] args) throws Exception {

        //如果火狐浏览器没有默认安装在C盘，需要制定其路径
        System.setProperty("webdriver.gecko.driver", "E:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python37\\geckodriver.exe");

        //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //请求地址
        webDriver.get(new BaseURL().URL());
        Thread.sleep(2000);

        // 最⼤化窗⼝
        webDriver.manage().window().maximize();
        Thread.sleep(2000);

        //平台账号登录
        new Login().LoginID(webDriver);

        //截取当前页面
        Thread.sleep(2000);

        deviceUse.click(webDriver, By.id("shangpinguanli"));
        deviceUse.click(webDriver, By.linkText("商品发布"));

        if (deviceUse.IsElementPresent(webDriver, By.className("redColor"))) {

            pullDownList(By.id("yi_type_id"), "阳光文具");
        }

        if (deviceUse.IsElementPresent(webDriver, By.className("redColor"))) {

            pullDownList(By.id("type_id"), "");
        }

        if (deviceUse.IsElementPresent(webDriver, By.id("name"))) {

            new DeviceUse().sendKeys(webDriver, By.id("name"), "测试商品");
        }

        if (deviceUse.IsElementPresent(webDriver, By.id("sales"))) {

            deviceUse.sendKeys(webDriver, By.id("sales"), "1");
        }
        deviceUse.radioOption(webDriver, By.name("is_lunbo"), "is_lunbo");
        deviceUse.radioOption(webDriver, By.name("is_tui"), "is_tui");
        deviceUse.radioOption(webDriver, By.name("is_daili"), "is_daili");
        deviceUse.radioOption(webDriver, By.name("is_wuxing"), "is_daili");
        deviceUse.radioOption(webDriver, By.name("is_jiuxing"), "is_daili");

        new ImageUpload().imageUpload(webDriver, By.name("img"));
        new ImageUpload().imagesUpload(webDriver, By.name("lun_img[]"));

        new DeviceUse().sendKeys(webDriver, By.id("brief"), "测试商品");
        new ImageUpload().imagesUpload(webDriver, By.name("content_image"));


        //商品发布提交
//        new DeviceUse().click(webDriver,By.name("Submit"));
        LoginToExit();

        //关闭浏览器
        deviceUse.CloseThePage(webDriver);
    }

    //平台账号退出
    private static void LoginToExit() {

        if (new DeviceUse().IsElementPresent(webDriver, By.className("tuichu"))) {
//            WebDriverWait wait = new WebDriverWait(webDriver, 10);
//            wait.until(ExpectedConditions.elementToBeClickable(By.className("tuichu")));
            new DeviceUse().click(webDriver, By.className("tuichu"));
        } else {
            Assert.fail("--------------------------点击退出无效-------------------");
        }

        System.out.println(webDriver.getPageSource());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        deviceUse.click(webDriver, By.className("layui-layer-btn0"));
    }

    private static void pullDownList(By by, String text) throws InterruptedException {

        webDriver.getCurrentUrl();
        System.out.println(webDriver.getPageSource());

        Select select = new Select(webDriver.findElement(by));
        List<WebElement> allOptions = select.getAllSelectedOptions();

        for (WebElement e : allOptions) {
            e.click();

            Thread.sleep(2000);
            switch (e.getAttribute("value")) {
                case "":
                    select.selectByVisibleText(text);
                case "1":
                    select.selectByVisibleText(text);
                    break;
            }
        }
    }


    private void clickElementContainingText(By by, String text) {

        List<WebElement> elementList = webDriver.findElements(by);

        for (WebElement e : elementList) {

            if (e.getText().contains(text)) {

                e.click();

                break;

            }

        }

    }

}
