package com.example.newretail.login;

import com.example.newretail.function.DeviceUse;

import com.example.newretail.imgcotout.GetCutOut;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class Login implements LoginInterface {

    //判断元素是否存在
    @Override
    public void LoginID(WebDriver webDriver) throws InterruptedException {
        if (IsElementPresent(webDriver,By.xpath("/html/body/div[2]/div/ul/li[1]/p"))) {

            //输入关键字搜索
            WebElement userBox = webDriver.findElement(By.cssSelector("input#name"));
            WebElement passBox = webDriver.findElement(By.cssSelector("input#password"));

            if (userBox.isEnabled() && passBox.isEnabled()) {


                userBox.sendKeys("17736085289");
                Thread.sleep(1000);
                passBox.sendKeys("085289");
                String currentUrl = webDriver.getCurrentUrl();

                Thread.sleep(1000);
            }

        } else {

            Assert.fail("-----------------输入框不存在----------------");
        }

        if (IsElementPresent(webDriver,By.className("btn_dl")))

        {
            new DeviceUse().click(webDriver,By.className("btn_dl"));

            //截图
            new GetCutOut().getInto(webDriver);
        } else

        {
            Assert.fail("---------------点击登录无效------------------");
        }

    }



    private boolean IsElementPresent(WebDriver webDriver, By by) {
        try {
            webDriver.findElement(by);

            return true;
        } catch (NoSuchElementException e) {

            return false;
        }
    }

}
