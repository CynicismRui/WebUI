package com.example.newretail.Upload;


import com.example.newretail.function.DeviceUse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 图片上传
 * imageUpload 单张上传
 * imagesUpload 多张上传
 */
public class ImageUpload implements Upload {
    private final static String fileURL = "E:\\photo\\O1CN01IZl8OQ1jew5rRbfnv_!!282314574.jpg";

    private final static String[] filesURL = {
            "E:\\photo\\O1CN01J4aEaf1jew5ux4a4B_!!282314574.jpg",
            "E:\\photo\\O1CN01Sl8HUP1jew5tr6vTn_!!282314574.jpg",
            "E:\\photo\\O1CN01XYbtyk1jew5uMNOSw_!!282314574.jpg"
            };

    @Override
    public void imageUpload(WebDriver webDriver, By by) {

        new DeviceUse().sendKeys(webDriver, by, fileURL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void imagesUpload(WebDriver webDriver, By by) {

        for (int i = 0; i <filesURL.length ; i++) {

            webDriver.findElement(by).sendKeys(filesURL[i]);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
