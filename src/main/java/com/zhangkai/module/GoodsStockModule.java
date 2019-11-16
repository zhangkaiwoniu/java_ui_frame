package com.zhangkai.module;

import com.zhangkai.action.SeleniumAction;
import com.zhangkai.page.GoodsStockPage;
import com.zhangkai.page.NavigationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

/**
 * Created by ZhangKai on 2019/11/5.
 */
public class GoodsStockModule {

    public static void addGoods(String goodsName) {
        /*增加商品*/
//        SeleniumAction.myClick(NavigationPage.product); //点击导航栏
        SeleniumAction.executeJS(NavigationPage.product, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.stockTitle); //点击商品库存标题
        SeleniumAction.executeJS(GoodsStockPage.stockTitle, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.addGoods); //点击新增
        SeleniumAction.executeJS(GoodsStockPage.addGoods, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.goodsType); //商品类别
        SeleniumAction.executeJS(GoodsStockPage.goodsType, "arguments[0].click();");
        SeleniumAction.mySendKey(GoodsStockPage.goodsName, goodsName); //名称
        //点击大，小类
//        SeleniumAction.myClick(GoodsStockPage.largeTypeTotal);
        SeleniumAction.executeJS(GoodsStockPage.largeTypeTotal, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.largeType);
        SeleniumAction.executeJS(GoodsStockPage.largeType, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.smallTypeTotal);
        SeleniumAction.executeJS(GoodsStockPage.smallTypeTotal, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.smallType);
        SeleniumAction.executeJS(GoodsStockPage.smallType, "arguments[0].click();");
        SeleniumAction.mySendKey(GoodsStockPage.price,"100");
//        SeleniumAction.myClick(GoodsStockPage.saveButton); //保存
        SeleniumAction.executeJS(GoodsStockPage.saveButton, "arguments[0].click();");
    }

    public static void delete() {
        SeleniumAction.executeJS(NavigationPage.product, "arguments[0].click();");
        //删除单个
//        SeleniumAction.myClick(GoodsStockPage.deleteGoods);
        SeleniumAction.executeJS(GoodsStockPage.deleteGoods, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.confirmDelete);
        SeleniumAction.executeJS(GoodsStockPage.confirmDelete, "arguments[0].click();");
    }

    public static void deleteAll() {
        SeleniumAction.executeJS(NavigationPage.product, "arguments[0].click();");
        //删除所有
//        SeleniumAction.myClick(GoodsStockPage.selectAll); //全选
        SeleniumAction.executeJS(GoodsStockPage.selectAll, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.batchOpration); //点击批量操作框
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SeleniumAction.executeJS(GoodsStockPage.batchOpration, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.deleteAll); //删除
        SeleniumAction.executeJS(GoodsStockPage.deleteAll, "arguments[0].click();");
//        SeleniumAction.myClick(GoodsStockPage.confirmDeleteAll); //确定
        SeleniumAction.executeJS(GoodsStockPage.confirmDeleteAll, "arguments[0].click();");
    }

    public static void putIn(String count){
        SeleniumAction.executeJS(GoodsStockPage.putIn,"arguments[0].click();"); //点击入库
        SeleniumAction.mySendKey(GoodsStockPage.quantity,count); //输入数量
        SeleniumAction.executeJS(GoodsStockPage.putInconfirm,"arguments[0].click();"); //确定
    }
}