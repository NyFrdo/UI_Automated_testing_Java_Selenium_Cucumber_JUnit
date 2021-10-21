package util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtil {

    public static final String configPath = PropertiesUtil.getKey("configPath");
    public static final String configPathSec = PropertiesUtil.getKey("configPathSec");
    public static final String defaultEnv = PropertiesUtil.getKey("Env");
    public static final String defaultSheet = PropertiesUtil.getKey("defaultSheet");
    public static Map<String,Integer> envMap = new HashMap<String,Integer>();
    public static Map<String,Integer> columnMap = new HashMap<String,Integer>();
    public static Sheet sheet ;

    static {
        readSheet (configPath);
    }

    public static void fileExist (String path){
        File f = new File(path);
        Assert.assertTrue("File "+path+" not exist , please check", f.exists());
    }

    public static void readSheet (String path) {
        try {
            if (path.endsWith("xlsx")){
                sheet = new XSSFWorkbook(new FileInputStream(path)).getSheet(defaultSheet);
            }else sheet = new HSSFWorkbook(new FileInputStream(path)).getSheet(defaultSheet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Cell> itColumnHeader = sheet.getRow(0).iterator();
        Iterator<Cell> it = sheet.getRow(0).iterator();
        int i = 1;
        while (it.hasNext()){
            envMap.put(it.next().toString(),i++);
        }

        for (int j=1;j<=sheet.getLastRowNum();j++){
            columnMap.put(sheet.getRow(j).getCell(0).toString(),j);
        }
//        System.out.println(envMap);
//        System.out.println(columnMap);
    }

    public static String getCell (String columnName){
        int columnIndex = envMap.get(defaultEnv);
        int rowIndex = columnMap.get(columnName);
        Cell cell = sheet.getRow(rowIndex).getCell(columnIndex);
        cell.setCellType(CellType.STRING);
        return cell.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(getCell("dbpwd"));
//    }
}
