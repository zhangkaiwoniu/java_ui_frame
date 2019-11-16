package com.zhangkai.module;

import com.zhangkai.action.SeleniumAction;
import com.zhangkai.page.CashierPage;
import com.zhangkai.page.NavigationPage;
import com.zhangkai.waitElement.SeleniumUtils;

/**
 * Created by ZhangKai on 2019/11/9.
 */
public class CashierModule {
    public static String pay() throws InterruptedException {
        SeleniumAction.executeJS(NavigationPage.cashier,"arguments[0].click();"); //导航栏
        Thread.sleep(1000);
        SeleniumAction.executeJS(CashierPage.catFood,"arguments[0].click();");//点击猫粮
        SeleniumAction.executeJS(CashierPage.addQuantity,"arguments[0].click();");//点击购买数量
        SeleniumAction.executeJS(CashierPage.addPutIn,"arguments[0].click();");//添加库存
        SeleniumAction.executeJS(CashierPage.placeOrder,"arguments[0].click();");//点击下单
        SeleniumAction.executeJS(CashierPage.vip,"arguments[0].click();");//点击会员
        SeleniumAction.executeJS(CashierPage.selectVIP,"arguments[0].click();");//选择会员
        SeleniumAction.executeJS(CashierPage.nextStep,"arguments[0].click();");//点击下一步
        SeleniumAction.executeJS(CashierPage.balance,"arguments[0].click();");//点击余额，取消余额
        SeleniumAction.executeJS(CashierPage.debt,"arguments[0].click();");//选择欠款
        SeleniumAction.executeJS(CashierPage.finish,"arguments[0].click();");//点击完成付款
        Thread.sleep(1000);
        String record = SeleniumUtils.findElement(CashierPage.record).getText();
        SeleniumAction.executeJS(CashierPage.accompllish,"arguments[0].click();");
        return record;
    }
}