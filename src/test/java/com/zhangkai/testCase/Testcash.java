package com.zhangkai.testCase;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.module.CashierModule;
import com.zhangkai.module.GoodsStockModule;
import com.zhangkai.module.LoginModule;
import com.zhangkai.module.VIPModule;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by ZhangKai on 2019/11/9.
 */
public class Testcash {
    private static String url = "https://snailpet.com/index";
    WebDriver driver;


    @BeforeClass
    public void openBrowers() {
        driver = SeleniumDriver.openBrowers("chrome");
        driver.get(url);
        LoginModule.login("1890927","z");
    }

    @AfterClass
    public void closeBrowers() {
        GoodsStockModule.deleteAll();
        SeleniumDriver.closeBrowers();
    }

    @Test
    public void test_01_pay() throws InterruptedException {
        GoodsStockModule.addGoods("猫粮");
//        VIPModule.addVIP("肖强","18909876543","kk");
        String record = CashierModule.pay();
        Assert.assertEquals(record,"100.00","收银失败");
    }
}
