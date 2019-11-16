package com.zhangkai.page;

import org.openqa.selenium.By;

/**
 * Created by ZhangKai on 2019/11/3.
 */
public class LoginPage {
    public static By uname = By.name("phone"); //手机号
    public static By pwd = By.name("password"); //密码
    public static By login = By.className("ori-btn"); //登录
    public static By wrongTip = By.className("layui-layer-content"); //错误登录提示
    public static By correctTip = By.linkText("安全退出"); // 成功登录提示
    public static By updataTip = By.xpath("//div[@id=\"layui-layer2\"]//div[@class=\"red_btn\"]"); //升级提示确定button
}