import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static final String configPath = "src/test/resources/config.xlsx";
    public static final String configPathSec = "src/test/resources/config2.xls";
    public static final String defaultEnv = "Local";
    public static final String defaultSheet = "info";
//    public static String dbtype =
//    public static String dburl =
//    public static String dbport =
//    public static String dbpwd =
//    public static String dbInstance =

    public static void fileExist (String path){
        File f = new File(path);
        Assert.assertTrue("File "+path+" not exist , please check", f.exists());
    }

    public static void readSheet (String path) throws  IOException{
        Sheet sheet ;
        path = "aaa";
        if (path.endsWith("xlsx")){
            sheet = new XSSFWorkbook(new FileInputStream(path)).getSheet(defaultSheet);
        }else sheet = new HSSFWorkbook(new FileInputStream(path)).getSheet(defaultSheet);
        for (int i= 0;i<sheet.getRow(0).getRowNum();i++){

        }
    }

    public static void readCell (String path){
        File f = new File(path);
        Assert.assertTrue("File "+path+" not exist , please check", f.exists());
    }

    public static void main(String[] args) {
        try {
            readSheet(configPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
