package com.example.newretail.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import sun.reflect.generics.tree.VoidDescriptor;

public interface DevicesFunction {

    void sendKeys(WebDriver webDriver, By by, String value);

    void radioOption(WebDriver webDriver, By by, String str);

    void click(WebDriver webDriver, By by);

    void CloseThePage(WebDriver webDriver);

    boolean IsElementPresent(WebDriver webDriver,By by);

    void CheckBox(WebDriver webDriver,By by);

    void pullDownList(WebDriver webDriver,By by, String text);

    void clickElementContainingText(WebDriver webDriver,By by, String text);

    void JavascriptExecutor(WebDriver webDriver);


}
