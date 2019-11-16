package com.zhangkai.action;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.logger.LoggerControler;
import com.zhangkai.waitElement.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ZhangKai on 2019/11/2.
 */
public class SeleniumAction extends SeleniumDriver {
    final static LoggerControler log = LoggerControler.getLoggerControler(SeleniumAction.class);

    public static void myClick(By by) {
        SeleniumUtils.findElement(by).click();
        log.info("点击" + by);
    }

    public static void mySendKey(By by, String str) {
        WebElement element = SeleniumUtils.findElement(by);
        element.clear();
        element.sendKeys(str);
        log.info("输入" + str);
    }

    public static void executeJS(By by,String script){
        WebElement element = SeleniumUtils.findElement(by);
        ((JavascriptExecutor) driver).executeScript(script,element);
        log.info("点击"+by);
    }

    public static void executeJS(String script){
        ((JavascriptExecutor) driver).executeScript(script);
        log.info("执行js脚本"+ script);
    }

    public static void manualClearAndSend(By by,String str){
        WebElement element = SeleniumUtils.findElement(by);
        executeJS(by,"arguments[0].click();");
        element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        element.sendKeys(Keys.chord(Keys.CONTROL,"x"));
        element.sendKeys(str);
        log.info("输入" + str);
    }

    public static void rightClick(By by) {
        WebElement webElement = SeleniumUtils.findElement(by);
        Actions action = new Actions(driver);
        action.contextClick(webElement).perform();
        log.info("在" + by + "处右击");
    }

    public static void doubleClick(By by) {
        WebElement webElement = SeleniumUtils.findElement(by);
        Actions action = new Actions(driver);
        action.doubleClick(webElement).perform();
        log.info("在" + by + "处双击");
    }

    public static void moveToElement(By by) {
        WebElement webElement = SeleniumUtils.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
        log.info("将鼠标移至" + by + "处");
    }

    public static void dragAndDrop(By by, int x, int y) {
        WebElement webElement = SeleniumUtils.findElement(by);
        Actions action = new Actions(driver);
        action.dragAndDropBy(webElement, x, y).perform();
        log.info("将元素" + by + "拖拽到(" + x + "," + y + ")处");
    }

    public static void clickAndHold(By oneby, By twoby) {
        WebElement oneElement = SeleniumUtils.findElement(oneby);
        WebElement twoElement = SeleniumUtils.findElement(twoby);
        Actions action = new Actions(driver);
        action.clickAndHold(oneElement).moveToElement(twoElement).release(oneElement).perform();
        log.info("将元素" + oneby + "拖到" + twoby + "处");
    }

    public static void selectByIndex(By by, int i) {
        WebElement cashSelect = SeleniumUtils.findElement(by);
        Select select = new Select(cashSelect);
        select.selectByIndex(i);
        log.info("用户选择了第" + i + "个选项");
    }

    public static void selectByValue(By by, String value) {
        WebElement cashSelect = SeleniumUtils.findElement(by);
        Select select = new Select(cashSelect);
        select.selectByValue(value);
        log.info("选择了Value为:" + value + " 选项");
    }

    public static void selectBy(By by, String text) {
        WebElement cashSelect = SeleniumUtils.findElement(by);
        Select select = new Select(cashSelect);
        select.selectByVisibleText(text);
        log.info("用户选择了:" + text + " 选项");
    }

    public static void switchWindow() {
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
        log.info("窗口切换");
    }

    public static void switchFrame(By by) {
        WebElement frame = SeleniumUtils.findElement(by);
        driver.switchTo().frame(frame);
        log.info("frame切换");
    }

}
