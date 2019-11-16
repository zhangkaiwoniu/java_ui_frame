package com.zhangkai.tools;

import org.testng.annotations.Test;

import java.util.Random;
import java.util.logging.StreamHandler;

/**
 * Created by ZhangKai on 2019/11/3.
 */
public class RandomString {

    /*输出min--max之间的数*/
    public static String getRandomNum(int min, int max) {
        return String.valueOf((new Random().nextInt(max - min + 1) + min));
    }

    /*输出任意数字字母的字符串*/
    public static String getRandomStr(int len) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            String charORnum = random.nextInt(10) % 2 == 0 ? "char" : "num";
            if (charORnum.equals("char")) {
                int lowORupper = random.nextInt(10) % 2 == 0 ? 65 : 97;
                str += (char) (lowORupper + random.nextInt(26));
            } else {
                str += String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }
}


