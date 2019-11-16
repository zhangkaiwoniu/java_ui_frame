package com.zhangkai.page;

import org.openqa.selenium.By;

/**
 * Created by ZhangKai on 2019/11/8.
 */
public class VIPPage {
    public static By addVIP = By.xpath("//a[contains(text(),'新增会员')]");
    public static By addName = By.xpath("//input[@name='name']");
    public static By addPhone = By.xpath("//input[@name=\"phone\"]");
    public static By addPetName = By.xpath("//input[@name=\"petName\"]");
    public static By clickSave = By.xpath("//snail-members/div[2]/div/div/div[3]/div[2]");
    public static By verifyName = By.xpath("/html/body/app-root/div/snail-member-main/snail-members/div[1]/div/div[2]/table/tbody/tr/td[2]/a/span");
    public static By modify = By.cssSelector(".body td:nth-of-type(10) [href='javascript\\:void\\(0\\)\\;']:nth-of-type(2)");
    public static By deleteOne = By.xpath("//div[@id=\"content\"]//tr[1]//a[text()='删除']");
    public static By confirmDelete = By.cssSelector(".layui-layer-btn0");
}