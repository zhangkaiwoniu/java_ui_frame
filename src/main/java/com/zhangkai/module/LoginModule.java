package com.zhangkai.module;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.action.SeleniumAction;
import com.zhangkai.page.LoginPage;
import com.zhangkai.waitElement.SeleniumUtils;
import org.openqa.selenium.WebDriver;

/**
 * Created by ZhangKai on 2019/11/3.
 */
public class LoginModule extends SeleniumDriver{
    /*登录模块*/

    public static void login(String uname,String pwd){
        SeleniumAction.mySendKey(LoginPage.uname,uname);
        SeleniumAction.mySendKey(LoginPage.pwd,pwd);
//        SeleniumAction.myClick(LoginPage.login);
        SeleniumAction.executeJS(LoginPage.login,"arguments[0].click();");
    }
}