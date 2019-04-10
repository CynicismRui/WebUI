package com.example.newretail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class chengpin {
    private WebDriver driver;


    @Before
    public void beforeEach() {
        //如果火狐浏览器没有默认安装在C盘，需要制定其路径
        System.setProperty("webdriver.gecko.driver", "E:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python37\\geckodriver.exe");
        driver = new FirefoxDriver();
        //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        System.setProperty("webdriver.chrome.driver","D:\\software\\java-jar+utils\\seleniumForChrome\\chromedriver2.40_win32\\chromedriver.exe");
//        driver = new ChromeDriver();
    }

    @After
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        //进入去哪儿的官网
        driver.get("https://www.qunar.com/");

        //功能测试题目第一题

        //点击单程单选框
        driver.findElement(By.id("js_searchtype_oneway")).click();

        // 出发城市南京的输入
        WebElement from_city1 = driver.findElement(By.name("fromCity"));
        from_city1.clear();
        from_city1.sendKeys("南京");
        Thread.sleep(2000);
        from_city1.sendKeys(Keys.ENTER);

        // 到达城市北京的输入
        WebElement to_city1 = driver.findElement(By.name("toCity"));
        to_city1.sendKeys("北京");
        Thread.sleep(2000);
        to_city1.sendKeys(Keys.ENTER);

        // 日期2017-10-30的输入
        WebElement from_date1 = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromDate']"));
        from_date1.clear();
        Thread.sleep(2000);
        from_date1.sendKeys("2017-10-30");
        driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromDate']"));

        //点击立即搜索按钮
        WebElement search1 = driver.findElement(By.className("button-search"));
        search1.click();
        Thread.sleep(8000);
        //点击"直飞"标签，筛选出直飞航班
        driver.findElement(By.cssSelector("label.lab > input.inp_chk")).click();


        //功能测试题目第二题

        //回到去哪儿官网
        WebDriver.Navigation nav = driver.navigate();
        nav.back();

        //进入机票查询、特价机票、打折飞机票页面
        driver.get("https://flight.qunar.com/");

        //点击"往返"
        WebElement aa2 = driver.findElement(By.id("js_lab_rng"));
        aa2.click();

        // 出发城市
        WebElement from_city2 = driver.findElement(By.name("fromCity"));
        from_city2.click();
        from_city2.sendKeys("南京");
        Thread.sleep(2000);
        from_city2.sendKeys(Keys.ENTER);

        // 到达城市
        WebElement to_city2 = driver.findElement(By.name("toCity"));
        to_city2.click();
        to_city2.sendKeys("北京");
        Thread.sleep(2000);
        to_city2.sendKeys(Keys.ENTER);

        // 出发日期
        WebElement from_date2 = driver.findElement(By.id("fromDate"));
        from_date2.clear();
        Thread.sleep(2000);
        from_date2.sendKeys("2017-10-30");

        //到达日期
        WebElement to_date2 = driver.findElement(By.id("toDate"));
        to_date2.clear();
        Thread.sleep(2000);
        to_date2.sendKeys("2017-11-1");

        //点击查询
        WebElement search2 = driver.findElement(By.className("btn_search"));
        search2.click();
        Thread.sleep(2000);
    }

}
