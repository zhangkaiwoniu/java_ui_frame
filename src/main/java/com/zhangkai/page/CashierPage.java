package com.zhangkai.page;

import org.openqa.selenium.By;

/**
 * Created by ZhangKai on 2019/11/9.
 */
public class CashierPage {
    public static By catFood = By.cssSelector("#shopClassify [data-type='0']:nth-of-type(2) .js-name");
    public static By addQuantity = By.cssSelector(".info_area div:nth-of-type(3) [href='javascript\\:void\\(0\\)\\;']:nth-child(3)");
    public static By addPutIn = By.cssSelector(".layui-layer-content .red_btn");//添加库存
    public static By placeOrder = By.cssSelector(".js-go-pay .word");
    public static By vip = By.cssSelector("#id-left-rem");
    public static By selectVIP = By.cssSelector(".layui-layer-wrap .select");
    public static By nextStep = By.cssSelector(".pay_area .no-border:nth-child(13) [href]");
    public static By balance = By.cssSelector("[src='\\/assets\\/img\\/blancePayIcon\\.png']");
    public static By debt = By.cssSelector("[src='\\/assets\\/img\\/creditPayGray\\.png']");
    public static By finish = By.cssSelector(".cla-okwell");
    public static By record = By.cssSelector(".pay_area .cla-succeed-img:nth-child(18) b");

    public static By accompllish = By.cssSelector(".pay_area .cla-succeed-img:nth-child(18) div:nth-child(6) .cla-btn-us");
}