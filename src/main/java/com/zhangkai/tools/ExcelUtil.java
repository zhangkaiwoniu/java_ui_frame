package com.zhangkai.tools;


import com.zhangkai.logger.LoggerControler;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by lenovo on 2016/11/10.
 */
public class ExcelUtil {
    final static LoggerControler log= LoggerControler.getLoggerControler(ExcelUtil.class);
    //定义一个excel
    private static HSSFWorkbook workbook=null;
    //判断excel的sheet是否存在
    public static boolean sheetExist(String filePath,String sheetName){
        boolean flag=false;
        File file=new File(filePath);
        if (file.exists()){
            try {
                workbook=new HSSFWorkbook(new FileInputStream(file));
                //添加workbook（不添加sheet时生成的xls文件打开时会报错）
                HSSFSheet sheet=workbook.getSheet(sheetName);
                if (sheet!=null){
                    flag=true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (!file.exists()){
            flag=false;
        }
        return flag;
    }
   /* 创建新的文件excel
    filePath是excel的路径
    sheetName是要创建的表格索引
    titleRow是excel的第一行*/

    public static void createExcel(String filePath,String sheetName,String titleRow[]){
        //判断文件格式
        if(filePath.endsWith(".xls")){
            workbook=new HSSFWorkbook();
            //如果文件是excel，那么新建sheet到excel
            Sheet sheet=workbook.createSheet(sheetName);
            FileOutputStream fileOutputStream=null;
            //row表示行
            Row row=workbook.getSheet(sheetName).createRow(0);
            for (int i=0;i<titleRow.length;i++){
                //一行一行写入到Cell
                Cell cell=row.createCell(i);
                cell.setCellValue(titleRow[i]);
            }
            try {
                fileOutputStream=new FileOutputStream(filePath);
                workbook.write(fileOutputStream);
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            log.error("文件格式必须为xls格式");
        }

    }
    //创建excel文件，只传一个参数
    public static void createExcel1(String filePath){
        if (filePath.endsWith("xls")){
            workbook=new HSSFWorkbook();
            Sheet sheet1=workbook.createSheet("sheet1");
            FileOutputStream fileOutputStream=null;
            try {
                fileOutputStream=new FileOutputStream(filePath);
                workbook.write(fileOutputStream);
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            log.error("文件格式必须是xls格式");
        }
    }
   /* 写入数据到excel中，filePath文件路径，写入内容
    Arraylist list=new ArrayList();
    list.add("11")
    list.add("222")
    <p/>*/
   public static void writeInfoToExcel(String filePath, ArrayList<ArrayList<String>> infos){
       if(!MyFile.fileExist(filePath)){
           ExcelUtil.createExcel1(filePath);
       }
       workbook=new HSSFWorkbook();
       Sheet sheet=null;
       try{
           sheet=workbook.getSheetAt(0);
       }catch (Exception e) {
           sheet = workbook.createSheet();
       }
       for (int i=0;i<infos.size();i++){
           //i控制行，j控制列
           Row row=sheet.createRow(i);
           for (int j=0;j<infos.get(i).size();j++){
               Cell cell=row.createCell(j,Cell.CELL_TYPE_STRING);
               cell.setCellValue(infos.get(i).get(j));
           }
           //保存文件到指定路径
           ExcelUtil.saveFile(filePath);
       }

   }
   /*//插入数据到指定行
    文件地址 filePath
    指定行row
    插入内容infos*/

   public static void writeInfoToExcelByRow(String filePath,int row,ArrayList<ArrayList<String>> infos){

       if (!MyFile.fileExist(filePath)){
            ExcelUtil.createExcel1(filePath);
       }
       workbook=new HSSFWorkbook();
       Sheet sheet=null;
       //如果没有workbook里面没有sheet，则新建sheet
       try{
           sheet=workbook.getSheetAt(0);
       }catch (Exception e){
           sheet=workbook.createSheet();
       }
       for (int i=0;i<infos.size();i++){
           Row row1=sheet.createRow(row-1);
           for(int j=0;j<infos.get(i).size();j++){
               Cell cell1=row1.createCell(j,Cell.CELL_TYPE_STRING);
               cell1.setCellValue(infos.get(i).get(j));
           }
       }
       //当数据都写入到excel后，将文件保存到指定位置
       ExcelUtil.saveFile(filePath);

   }
   //指定列插入数据
   public static void writeInfoToExcelByCell(String filePath, int cell, ArrayList<ArrayList<String>> infos) {
//        判断文件是否存在
       if (!MyFile.fileExist(filePath)) {
           ExcelUtil.createExcel1(filePath);
       }
       workbook = new HSSFWorkbook();
       Sheet sheet = null;
       try {
           sheet = workbook.getSheetAt(0);
       } catch (Exception e) {
           sheet = workbook.createSheet();
       }
       for (int j = 0; j < infos.get(0).size(); j++) {
           Row row1 = sheet.createRow(j);
           Cell cell1 = row1.createCell(cell - 1);
           cell1.setCellValue(infos.get(0).get(j));
       }
       ExcelUtil.saveFile(filePath);
   }
   //读文件
   public static ArrayList<ArrayList<Row>> readExcels(String filePath){
       //创建workbook
       File file=new File(filePath);
       try {
           workbook=new HSSFWorkbook(new FileInputStream(file));
       } catch (IOException e) {
           e.printStackTrace();
       }
       ArrayList<ArrayList<Row>> arrayList=new ArrayList<ArrayList<Row>>();
       //得到sheet的数量
       int sheetNum=workbook.getNumberOfSheets();
       Sheet sheet=workbook.getSheetAt(0);
       Row row=sheet.getRow(0);
       ArrayList<Row> listRow=new ArrayList<Row>();
       listRow.add(row);
       arrayList.add(listRow);
       return arrayList;
   }
    /**
     * 将更改后的workbook写入excelFilePath位置
     * <p/>
     * <li>如果该文件不存在，则进行创建新文件</li>
     * <li>如果该文件已经存在，则进行覆盖</li>
     */
    public static void saveFile(String excelFilePath) {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath));
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除文件.
     *
     * @param filePath 文件路径
     */
    public static boolean deleteExcel(String filePath) {
        boolean flag = false;
        File file = new File(filePath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                file.delete();
                flag = true;
            }
        }
        return flag;
    }
    /**
     * 往excel中写入(已存在的数据无法写入).
     *
     * @param filePath  文件路径
     * @param sheetName 表格索引
     * @param object
     */
    public static void writeToExcel(String filePath, String sheetName, Object object) {
        //创建workbook
        File file = new File(filePath);
        try {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //流
        FileOutputStream out = null;
        HSSFSheet sheet = workbook.getSheet(sheetName);
        // 获取表格的总行数
        int rowCount = sheet.getLastRowNum() + 1; // 需要加一
        // 获取表头的列数
        int columnCount = sheet.getRow(0).getLastCellNum();
        try {
            Row row = sheet.createRow(rowCount);     //最新要添加的一行
            //通过反射获得object的字段,对应表头插入
            // 获取该对象的class对象
            Class class_ = object.getClass();
            // 获得表头行对象
            HSSFRow titleRow = sheet.getRow(0);
            if (titleRow != null) {
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {  //遍历表头
                    String title = titleRow.getCell(columnIndex).toString().trim().toString().trim();
                    String UTitle = Character.toUpperCase(title.charAt(0)) + title.substring(1, title.length()); // 使其首字母大写;
                    String methodName = "get" + UTitle;
                    Method method = class_.getDeclaredMethod(methodName); // 设置要执行的方法
                    String data = method.invoke(object).toString(); // 执行该get方法,即要插入的数据
                    Cell cell = row.createCell(columnIndex);
                    cell.setCellValue(data);
                }
            }

            out = new FileOutputStream(filePath);
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取excel表中的数据.
     *
     * @param filePath  文件路径
     * @param sheetName 表格索引(EXCEL 是多表文档,所以需要输入表索引号，如sheet1)
     * @param object    object
     */
    public static List readFromExcel(String filePath, String sheetName, Object object) {
        //创建workbook
        File file = new File(filePath);
        try {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List result = new ArrayList();
        // 获取该对象的class对象
        Class class_ = object.getClass();
        // 获得该类的所有属性
        Field[] fields = class_.getDeclaredFields();
        // 读取excel数据
        // 获得指定的excel表
        HSSFSheet sheet = workbook.getSheet(sheetName);
        // 获取表格的总行数
        int rowCount = sheet.getLastRowNum() + 1; // 需要加一
        System.out.println("rowCount:" + rowCount);
        if (rowCount < 1) {
            return result;
        }
        // 获取表头的列数
        int columnCount = sheet.getRow(0).getLastCellNum();
        // 读取表头信息,确定需要用的方法名---set方法
        // 用于存储方法名
        String[] methodNames = new String[columnCount]; // 表头列数即为需要的set方法个数
        // 用于存储属性类型
        String[] fieldTypes = new String[columnCount];
        // 获得表头行对象
        HSSFRow titleRow = sheet.getRow(0);
        // 遍历
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) { // 遍历表头列
            String data = titleRow.getCell(columnIndex).toString(); // 某一列的内容
            String Udata = Character.toUpperCase(data.charAt(0))
                    + data.substring(1, data.length()); // 使其首字母大写
            methodNames[columnIndex] = "set" + Udata;
            for (int i = 0; i < fields.length; i++) { // 遍历属性数组
                if (data.equals(fields[i].getName())) { // 属性与表头相等
                    fieldTypes[columnIndex] = fields[i].getType().getName(); // 将属性类型放到数组中
                }
            }
        }
        // 逐行读取数据 从1开始 忽略表头
        for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
            // 获得行对象
            HSSFRow row = sheet.getRow(rowIndex);
            if (row != null) {
                Object obj = null;
                // 实例化该泛型类的对象一个对象
                try {
                    obj = class_.newInstance();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                // 获得本行中各单元格中的数据
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                    String data = row.getCell(columnIndex).toString();
                    // 获取要调用方法的方法名
                    String methodName = methodNames[columnIndex];
                    Method method = null;
                    try {
                        // 这部分可自己扩展
                        if (fieldTypes[columnIndex].equals("java.lang.String")) {
                            method = class_.getDeclaredMethod(methodName,
                                    String.class); // 设置要执行的方法--set方法参数为String
                            method.invoke(obj, data); // 执行该方法
                        } else if (fieldTypes[columnIndex].equals("int")) {
                            method = class_.getDeclaredMethod(methodName,
                                    int.class); // 设置要执行的方法--set方法参数为int
                            double data_double = Double.parseDouble(data);
                            int data_int = (int) data_double;
                            method.invoke(obj, data_int); // 执行该方法
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                result.add(obj);
            }
        }
        return result;
    }



}
