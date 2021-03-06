package com.example.newretail;

import com.example.newretail.Exit.UserToExit;
import com.example.newretail.Upload.ImageUpload;
import com.example.newretail.function.DeviceUse;
import com.example.newretail.login.Login;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyClass extends BaseURL {

    private static WebDriver webDriver;

    private static DeviceUse deviceUse = new DeviceUse();

    @Before
    public void beforeEach() {
        //如果火狐浏览器没有默认安装在C盘，需要制定其路径

        System.setProperty("webdriver.gecko.driver", "E:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python37\\geckodriver.exe");

        webDriver = new FirefoxDriver();

        //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void main() {

        try {
            //请求地址
            webDriver.get(new BaseURL().URL());
            Thread.sleep(2000);
            // 最⼤化窗⼝
            webDriver.manage().window().maximize();
            Thread.sleep(2000);

            //平台账号登录
            new Login().LoginID(webDriver);

            deviceUse.click(webDriver, By.id("shangpinguanli"));
            Thread.sleep(3000);
            deviceUse.click(webDriver, By.linkText("商品发布"));

            //判断一级商品类型是否存在
            if (deviceUse.IsElementPresent(webDriver, By.id("yi_type_id"))) {

                deviceUse.pullDownList(webDriver, By.id("yi_type_id"), "阳光文具");
            }

            if (deviceUse.IsElementPresent(webDriver, By.id("type_id"))) {

                deviceUse.pullDownList(webDriver, By.id("type_id"), "");
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

            //退出平台
            new UserToExit().LoginToExit(webDriver);

            //关闭浏览器
            deviceUse.CloseThePage(webDriver);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
