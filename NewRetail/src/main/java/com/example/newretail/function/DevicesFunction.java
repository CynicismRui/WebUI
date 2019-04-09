package com.example.newretail.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * sendKeys 输入框输入
 *
 * radioOption 下拉列表操作
 *
 * click 控件点击
 *
 * CloseThePage 关闭页面
 *
 * IsElementPresent 判断元素是否存在
 */
public interface DevicesFunction {

    void sendKeys(WebDriver webDriver, By by, String value);

    void radioOption(WebDriver webDriver, By by, String str);

    void click(WebDriver webDriver, By by);

    void CloseThePage(WebDriver webDriver);

    boolean IsElementPresent(WebDriver webDriver,By by);


}
