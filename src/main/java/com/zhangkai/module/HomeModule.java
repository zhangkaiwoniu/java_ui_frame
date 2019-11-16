package com.zhangkai.module;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.action.SeleniumAction;
import com.zhangkai.page.LoginPage;
import com.zhangkai.waitElement.SeleniumUtils;

/**
 * Created by ZhangKai on 2019/11/4.
 */
public class HomeModule {
    /*打开主页*/
    public static void openHome(String url){
        SeleniumDriver.openBrowers("chrome").get(url);
//        if (SeleniumUtils.isexist(LoginPage.updataTip)){
//            SeleniumAction.myClick(LoginPage.updataTip);
//        }
        SeleniumAction.myClick(LoginPage.updataTip);

    }
}