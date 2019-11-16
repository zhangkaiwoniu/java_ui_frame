package com.zhangkai.testCase;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.action.SeleniumAction;
import com.zhangkai.module.HomeModule;
import com.zhangkai.module.LoginModule;
import com.zhangkai.page.LoginPage;
import com.zhangkai.tools.MyAssert;
import com.zhangkai.waitElement.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ZhangKai on 2019/11/3.
 */
public class TestLogin {
    private static String url = "https://snailpet.com/index";

    @BeforeMethod
    public void openBrowers() {
        HomeModule.openHome(url);
    }

    @AfterMethod
    public void closeBrowers() {
        SeleniumDriver.closeBrowers();
    }

    @DataProvider(name = "loginCorrect")
    public Object[][] getCorrectPara(){
        return new Object[][]{
                {"18909276261","zk18909276261","安全退出"},

        };
    }
    @DataProvider(name = "loginWrong")
    public Object[][] getWrongPara(){
        return new Object[][]{
                {"18909276261","","请输入密码！"},
                {"18909276261","1234567879","密码错误"},
                {"18909276266","zk18909276261","您还没有注册"}
        };
    }

    @Test(dataProvider = "loginCorrect",priority = 1)
    public void testCorrectLogin(String uname,String pwd,String exp){
        LoginModule.login(uname,pwd);
        String act = SeleniumUtils.findElement(LoginPage.correctTip).getText();
        MyAssert.assertEquals(act,exp,"成功登录");
    }

    @Test(dataProvider = "loginWrong",priority = 2,enabled = true)
    public void testWrongLogin(String uname,String pwd,String exp){
        LoginModule.login(uname,pwd);
        String act = SeleniumUtils.findElement(LoginPage.wrongTip).getText();
        MyAssert.assertEquals(act,exp,"异常登录");
    }

}