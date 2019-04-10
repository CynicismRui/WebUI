package com.example.newretail.Exit;

import com.example.newretail.function.DeviceUse;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserToExit implements ToExit {


    //exit
    @Override
    public void LoginToExit(WebDriver webDriver) {

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

        new DeviceUse().click(webDriver, By.className("layui-layer-btn0"));
    }
}
