package com.zhangkai.page;

import org.openqa.selenium.By;

/**
 * Created by ZhangKai on 2019/11/4.
 */
public class NavigationPage {
    public static By cashier = By.xpath("//a[@data-id=\"cashier\"]//div[@class=\"word\"]");
    public static By member = By.xpath("//a[@data-id=\"member\"]//div[@class=\"word\"]");
    public static By product = By.xpath("//a[@data-id=\"product\"]//div[@class=\"word\"]");
    public static By sale = By.xpath("//a[@data-id=\"sale\"]//div[@class=\"word\"]");
    public static By expend = By.xpath("//a[@data-id=\"expend\"]//div[@class=\"word\"]");
    public static By chart = By.xpath("//a[@data-id=\"chart\"]//div[@class=\"word\"]");
    public static By tool = By.xpath("//a[@data-id=\"tool\"]//div[@class=\"word\"]");
}