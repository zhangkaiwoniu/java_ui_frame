package com.zhangkai.tools;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by ZhangKai on 2019/10/26.
 */
public class ReadData {
    StringBuffer log = new StringBuffer();
    /*
    * 读取excel获得map返回值
    * */
//    public static void main(String[] args) {
//        Object[][] ob  = new readData().readExcel("F:\\javawork\\Demo03\\src\\test\\data\\data.xls");
//        System.out.println(ob[1][0]);
//    }
    public Object[][] readExcel(String file){
        ArrayList<String> dataKey = new ArrayList<String>(); //存放表头，数据对应的key
        //getWorkbook为自定义的方法，为了处理不同的excel格式，返回Workbook对象
        Workbook wb = getWorkbook(file);
        Sheet sh = wb.getSheetAt(0); //得到第一页的sheet
        //得到总的行数和列数
        int rowTotalNum = sh.getLastRowNum() + 1;
        int colTotalNum = sh.getRow(0).getPhysicalNumberOfCells();

        //定义最后要返回的二维数组，类型为hashmap，第一行的表头不要，所以行数减一
        HashMap<String,String>[][] map = new HashMap[rowTotalNum - 1][1];
        //初始化map二维数组
        if (rowTotalNum > 1) {
            for (int i = 0; i < rowTotalNum - 1; i++) {
                map[i][0] = new HashMap<String, String>();
            }
        }else {
            log.append("表中无数据");
        }
        //给datakey添加表头
        for (int j = 0;j < colTotalNum;j++){
            dataKey.add(getCellValue(sh,0,j));
        }
        for (int k = 1;k < rowTotalNum ;k++){
            for (int z = 0;z < colTotalNum;z++){
                map[k - 1][0].put(dataKey.get(z),getCellValue(sh,k,z));
            }
        }
        return map;
    }

    public static String getCellValue(Sheet sh, int row, int col){
        Cell cell = sh.getRow(row).getCell(col);
        String cellValue = getCellValue(cell);
        return cellValue;
    }

    public static String getCellValue(Cell cell){
        String value = "getCellTypeEnum()";
        switch (cell.getCellTypeEnum()) {
            case STRING:
                value = String.valueOf(cell.getRichStringCellValue());
                return value;
            case NUMERIC:
                value = String.valueOf(cell.getNumericCellValue());
                return value;
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                return value;
            case FORMULA:
                value = String.valueOf(cell.getCellFormula());
                return value;
            case ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                return value;
            case BLANK:
                return value;
            default:
                return value;
        }
    }

    public static Workbook getWorkbook(String filePath){
        Workbook wb = null;
        try {
            if (filePath.endsWith(".xls")) {
                File file = new File(filePath);
                InputStream is = new FileInputStream(file);
                wb = new HSSFWorkbook(is);
            } else if (filePath.endsWith(".xlsx") || filePath.endsWith(".xlsm")) {
                wb = new XSSFWorkbook(filePath);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return wb;
    }
}










