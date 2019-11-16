package com.zhangkai.page;

import org.openqa.selenium.By;

/**
 * Created by ZhangKai on 2019/11/4.
 */
public class GoodsStockPage {
    public static By stockTitle = By.xpath("//a[@data-id=\"stock\"]"); //商品库存
    public static By addGoods = By.xpath("//a[@data-type=\"add\"]"); //增加商品
    //增加商品弹框各元素
    public static By goodsType = By.xpath("//div[@class=\"layui-layer-content\"]//ul[@class=\"product-type\"]/li[1]");
    public static By goodsName = By.xpath("//*[@class=\"layui-layer layui-layer-page\"]/div/div/div[2]/div/div[4]/div[1]/div/div/input");
    public static By largeTypeTotal = By.xpath("//*[@class=\"layui-layer layui-layer-page\"]/div/div/div[2]/div/div[7]/div[1]");
    public static By largeType = By.xpath("//*[@class=\"layui-layer layui-layer-page\"]/div/div/div[2]/div/div[7]/div[1]/div/div/ul/li[1]");
    public static By smallTypeTotal = By.xpath("//*[@class=\"layui-layer layui-layer-page\"]/div/div/div[2]/div/div[7]/div[2]");
    public static By price = By.cssSelector(".layui-layer-content div:nth-of-type(8) [type]");
    public static By smallType = By.xpath("//*[@class=\"layui-layer layui-layer-page\"]/div/div/div[2]/div/div[7]/div[2]/div/div/ul/li[5]");
    public static By saveButton = By.xpath("//*[@class=\"layui-layer layui-layer-page\"]//div[@class=\"red_btn\"]");
    public static By assertGoodsNmae = By.xpath("//tbody[@class=\"js-check-box\"]//td[2]");
    //删除商品各元素
    public static By deleteGoods = By.cssSelector(".js-check-box tr:nth-of-type(2) span:nth-of-type(1) span:nth-of-type(2)"); //删除单个商品
    public static By confirmDelete = By.xpath("//div[@class=\"layui-layer layui-layer-dialog\"]/div[3]/a[text()=\"确定\"]"); //删除弹窗确认
    public static By selectAll =By.xpath("/html//input[@id='all_1']"); //全部勾选框
    public static By deleteAll = By.xpath("//div[@class=\"wn-btn order-by wn-select model-classify-select text-l open\"]/div[1]/ul/li[6]");
    public static By confirmDeleteAll = By.xpath("//div[text()=\"修改\"]");
    //批量操作框
    public static By batchOpration = By.xpath("/html/body/app-root/div/ng-component/div/div/snail-product-stock/div[1]/div[4]");
    //总计条数
    public static By count = By.xpath("//div[@class=\"pull-l wn-page-size\"]//input");
    //入库
    public static By putIn = By.cssSelector(".js-check-box td:nth-of-type(8) .ori-text:nth-of-type(1)");
    public static By quantity = By.cssSelector("#idIconInput > div:nth-of-type(1) .ng-untouched");
    public static By putInconfirm = By.cssSelector(".layui-layer-content .red_btn");
}