package com.zhangkai;

import com.zhangkai.Drivers.SeleniumDriver;
import com.zhangkai.action.SeleniumAction;
import com.zhangkai.tools.RandomString;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by ZhangKai on 2019/11/2.
 */
public class TestDemo {

    @Test
    public void addGoods() throws InterruptedException {
        WebDriver driver = SeleniumDriver.openBrowers("chrome");
        driver.get("http://www.baidu.com");
        SeleniumAction.mySendKey(By.id("kw"),"qedqwe");
        Thread.sleep(3000);
        SeleniumAction.mySendKey(By.id("kw"),"12345");
    }
//    @Test
//    public void deleteOne(){
//        System.out.println("2");
//    }
//    @Test
//    public void deleteAll(){
//        System.out.println("3");
//    }
//    @Test
//    public void test01() {
////        int num = (int)(Math.random()*100);
////        int n = (int)Math.random()*100 + 100;
////        int a = new Random().nextInt(10);
////        System.out.println(num);
////        System.out.println(n);
////        System.out.println(a);
//        String str = "";
//        str += (char) 97;
////        System.out.println(str);
////        System.out.println("sd".charAt(0));
////        System.out.println("sd".indexOf("s"));
////        System.out.println(Character.charCount(67));
//        System.out.println(RandomString.getRandomStr(10));
//    }
}