package com.zhangkai.waitElement;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.logger.LoggerControler;
import com.zhangkai.tools.MyAssert;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by ZhangKai on 2019/10/30.
 */
public class SeleniumUtils extends SeleniumDriver {
    static final LoggerControler logger = LoggerControler.getLoggerControler(SeleniumUtils.class);
    public static WebElement findElement(final By by){
        WebElement element = null;
        try{
            element = new WebDriverWait(driver,30).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });
        }catch (Exception e){
            logger.error("元素" + by + "查找超时");
            e.printStackTrace();
        }
        return element;
    }
    public static List<WebElement> findElements(final By by){
       List<WebElement> elements = null;
        try {
            elements = new WebDriverWait(driver,30).until(new ExpectedCondition<List<WebElement>>() {
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(by);
                }
            });
        }catch (Exception e){
            System.out.println("元素" + by + "查找失败");
            e.printStackTrace();
        }
        return elements;
    }

    public static boolean isexist(final By by){
        boolean flag = false;
        try {
            SeleniumUtils.findElement(by);
            flag = true;
        }catch (TimeoutException e){
            e.printStackTrace();
        }
        return flag;
    }
}