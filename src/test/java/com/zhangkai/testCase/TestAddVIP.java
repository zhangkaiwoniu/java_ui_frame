package com.zhangkai.testCase;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.action.SeleniumAction;
import com.zhangkai.module.HomeModule;
import com.zhangkai.module.LoginModule;
import com.zhangkai.module.VIPModule;
import com.zhangkai.page.GoodsStockPage;
import com.zhangkai.page.VIPPage;
import com.zhangkai.waitElement.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by ZhangKai on 2019/11/8.
 */
public class TestAddVIP {
    private static String url = "https://snailpet.com/index";
    WebDriver driver;


    @BeforeClass
    public void openBrowers() {
        driver = SeleniumDriver.openBrowers("chrome");
        driver.get(url);
        LoginModule.login("18909276261","zk18909276261");
    }

    @AfterClass
    public void closeBrowers() {
        SeleniumDriver.closeBrowers();
    }

    @Test
    public void test_01_addVIP(){
        VIPModule.addVIP("小强","18909287273","jake");
        String act = SeleniumUtils.findElement(VIPPage.verifyName).getText();
        Assert.assertEquals(act,"小强","新增异常");
    }

    @Test
    public void test_02_modifyVIP() throws InterruptedException {
        VIPModule.modifyVIP("阿黄","18908287273","mali");
        Thread.sleep(1000);
        String act = SeleniumUtils.findElement(VIPPage.verifyName).getText();
        Assert.assertEquals(act,"阿黄","新增异常");
    }

    @Test
    public void test_03_deleteOne() throws InterruptedException {
        VIPModule.deleteOne();
        Thread.sleep(1000);
        int count = Integer.parseInt((SeleniumUtils.findElement(GoodsStockPage.count).getAttribute("value")));
        Assert.assertEquals(count,0,"删除异常");
    }
}



