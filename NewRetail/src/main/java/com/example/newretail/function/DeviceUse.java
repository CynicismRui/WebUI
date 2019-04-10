package com.example.newretail.function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @sendKeys 输入框输入
 *
 * @radioOption 下拉列表操作
 *
 * @click 控件点击
 *
 * @CloseThePage 关闭页面
 *
 * @IsElementPresent 判断元素是否存在
 *
 * @CheckBox 复选框
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
                click(webDriver, By.id(name + "_yes"));
                break;
            case "1":
                click(webDriver, By.id(name + "_no"));
                break;
        }

    }

    @Override
    public void click(WebDriver webDriver, By by) {

        webDriver.findElement(by).click();
    }


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
    public boolean IsElementPresent(WebDriver webDriver, By by) {
        try {
            webDriver.findElement(by);

            System.out.println("元素名称"+webDriver.findElement(by).getText());

            return true;
        } catch (NoSuchElementException e) {

            return false;
        }
    }

    @Override
    public void CheckBox(WebDriver webDriver, By by) {

        WebElement orangeCheckBox = webDriver.findElement(by);
        // 判断复选框未选中时，点击选中
        if (!orangeCheckBox.isSelected()) {
            orangeCheckBox.click();
        }
        //判断复选框已选中时，再次点击取消
        if (orangeCheckBox.isSelected()) {
            orangeCheckBox.click();
        }

        List<WebElement> checkBoxs = webDriver.findElements(By.name("fruit"));
        for (WebElement checkBox : checkBoxs) {
            checkBox.click();
        }
    }

    @Override
    public void pullDownList(WebDriver webDriver, By by, String text) {
        webDriver.getCurrentUrl();
        System.out.println(webDriver.getPageSource());

        Select select = new Select(webDriver.findElement(by));
        List<WebElement> allOptions = select.getAllSelectedOptions();

        for (WebElement e : allOptions) {

            try {
                Thread.sleep(2000);
                e.click();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            switch (e.getAttribute("value")) {
                case "":
                    select.selectByVisibleText(text);
                case "1":
                    select.selectByVisibleText(text);
                    break;
            }
        }
    }

    @Override
    public void clickElementContainingText(WebDriver webDriver, By by, String text) {
        List<WebElement> elementList = webDriver.findElements(by);

        for (WebElement e : elementList) {

            if (e.getText().contains(text)) {

                e.click();

                break;

            }
        }
    }

    @Override
    public void JavascriptExecutor(WebDriver webDriver) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        js.executeScript("$('#btn').click(function()");
    }


}
