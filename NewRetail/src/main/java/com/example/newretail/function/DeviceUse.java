package com.example.newretail.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 *  Devices Function
 */
public class DeviceUse implements DevicesFunction {

    @Override
    public void sendKeys(WebDriver webDriver, By by, String value) {
        webDriver.findElement(by).sendKeys(value);
    }

    @Override
    public void radioOption(WebDriver webDriver, By by, String name) {
        WebElement is_element = webDriver.findElement(by);
        if (is_element.isSelected()) switch (is_element.getAttribute("value")) {
            case "0":
                click(webDriver, By.id(name + "_no"));
                break;
            case "1":
                click(webDriver, By.id(name + "_yes"));
                break;
        }

    }

    @Override
    public void click(WebDriver webDriver, By by) {

        webDriver.findElement(by).click();
    }

    //关闭当前浏览器
    @Override
    public void CloseThePage(WebDriver webDriver) {

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            webDriver.quit();
        }



        System.out.println("----------------测试结束------------------");
    }

    @Override
    public boolean IsElementPresent(WebDriver webDriver,By by) {
        try {
            webDriver.findElement(by);

            return true;
        } catch (NoSuchElementException e) {

            return false;
        }
    }


}
