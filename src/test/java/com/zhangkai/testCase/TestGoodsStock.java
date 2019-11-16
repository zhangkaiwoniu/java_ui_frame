package com.zhangkai.testCase;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.action.SeleniumAction;
import com.zhangkai.module.GoodsStockModule;
import com.zhangkai.module.HomeModule;
import com.zhangkai.module.LoginModule;
import com.zhangkai.page.GoodsStockPage;
import com.zhangkai.waitElement.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by ZhangKai on 2019/11/5.
 */
public class TestGoodsStock {
    private static String url = "https://snailpet.com/index";

    @BeforeClass
    public void openBrowers() throws InterruptedException {
        HomeModule.openHome(url);
        LoginModule.login("18909276261","zk18909276261");
        GoodsStockModule.deleteAll();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowers() {
        SeleniumDriver.closeBrowers();
    }

//    @DataProvider(name = "GoodsData")
//    public Object[][] getGoodsData(){
//        return new Object[][]{
//                {"猫粮"},
//                {"狗粮"},
//                {"狗圈"}
//        };
//    }
    @Test
    public void test_01_addGoods(){
        GoodsStockModule.addGoods("狗粮");
        String addGoodsName = SeleniumUtils.findElement(GoodsStockPage.assertGoodsNmae).getText();
        Assert.assertEquals("狗粮",addGoodsName,"新增商品异常");
    }

    @Test
    public void test_02_deleteOne() throws InterruptedException {
        GoodsStockModule.addGoods("猫粮");
        GoodsStockModule.delete();
        Thread.sleep(1000);
        int count = Integer.parseInt((SeleniumUtils.findElement(GoodsStockPage.count).getAttribute("value")));
        Assert.assertEquals(count,1,"删除异常");
    }

    @Test
    public void test_03_deleteAll() throws InterruptedException {
        GoodsStockModule.addGoods("猫粮");
        GoodsStockModule.deleteAll();
        Thread.sleep(1000);
        int count = Integer.parseInt((SeleniumUtils.findElement(GoodsStockPage.count).getAttribute("value")));
        Assert.assertEquals(count,1,"删除异常");
    }
}




