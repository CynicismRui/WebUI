package com.example.newretail.imgcotout;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;

import javax.xml.crypto.Data;

/**
 * 截取当前窗口
 */

public class GetCutOut implements IMGCutOut {
    @Override
    public void getInto(WebDriver webDriver) {
        try {
            File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            long time = new Date().getTime();
            FileUtils.copyFile(srcFile, new File("e:\\phone\\screenshot"+time+".png"));      //指定图片的保存路径及文件名
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
