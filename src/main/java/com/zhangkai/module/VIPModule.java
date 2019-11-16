package com.zhangkai.module;

import com.zhangkai.action.SeleniumAction;
import com.zhangkai.page.NavigationPage;
import com.zhangkai.page.VIPPage;

/**
 * Created by ZhangKai on 2019/11/8.
 */
public class VIPModule {
    public static void addVIP(String name,String phone,String petName){
        SeleniumAction.executeJS(NavigationPage.member,"arguments[0].click();");
        SeleniumAction.executeJS(VIPPage.addVIP,"arguments[0].click();");
        SeleniumAction.mySendKey(VIPPage.addName,name);
        SeleniumAction.mySendKey(VIPPage.addPhone,phone);
        SeleniumAction.mySendKey(VIPPage.addPetName,petName);
        SeleniumAction.myClick(VIPPage.clickSave);
    }
    public static void deleteOne(){
        SeleniumAction.executeJS(VIPPage.deleteOne,"arguments[0].click();");
        SeleniumAction.executeJS(VIPPage.confirmDelete,"arguments[0].click();");
    }
    public static void modifyVIP(String name,String phone,String petName){
        SeleniumAction.executeJS(VIPPage.modify,"arguments[0].click();");
        SeleniumAction.manualClearAndSend(VIPPage.addName,name);
        SeleniumAction.manualClearAndSend(VIPPage.addPhone,phone);
        SeleniumAction.manualClearAndSend(VIPPage.addPetName,petName);
        SeleniumAction.myClick(VIPPage.clickSave);
    }
}