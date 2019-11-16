package com.zhangkai.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ZhangKai on 2019/10/30.
 */
public class SeleniumDriver {
    public static WebDriver driver = null;

    public static WebDriver openBrowers(String browers){
        String projectPath = System.getProperty("user.dir");
        if (browers.equals("chrome")||browers.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browers.equals("firefox")){
            driver = new FirefoxDriver();
        }else {
            System.err.println("你传入的浏览器有误："+ browers);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void refresh(){
        driver.navigate().refresh();
    }
    public static void closeBrowers(){
        driver.quit();
    }
}