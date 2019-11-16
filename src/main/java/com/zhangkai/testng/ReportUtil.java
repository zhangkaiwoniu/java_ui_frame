package com.zhangkai.testng;

/**
 * Created by ZhangKai on 2019/11/10.
 */
import org.testng.Reporter;
import java.util.Calendar;
public class ReportUtil {
    private static String reportName = "WebUI自动化测试报告";
    private static String splitTimeAndMsg = "===";
    public static void log(String msg) {
        long timeMillis = Calendar.getInstance().getTimeInMillis();
        Reporter.log(timeMillis + splitTimeAndMsg + msg, true);
    }

    public static String getReportName() {
        return reportName;
    }

    public static String getSpiltTimeAndMsg() {
        return splitTimeAndMsg;
    }
}