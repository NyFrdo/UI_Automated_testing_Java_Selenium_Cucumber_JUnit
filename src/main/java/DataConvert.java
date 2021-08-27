import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataConvert {

    public static String elementValue = "";

    public static void littlerunner(String inputElementId,String outputElementId,String elementValueString,String patientKey) throws Exception{
        DBoperation.deleteElementData(patientKey);
        elementValue = elementValueString;
        DBoperation.insertElementData(inputElementId,patientKey,"HNXXXXXX"+patientKey.substring(patientKey.length()-3,patientKey.length()),elementValue);
        executeJobAndAssertResult(patientKey,inputElementId,outputElementId);
    }

    public static void littlerunner(String inputElementId,String outputElementId,Integer elementValueDtm,String patientKey) throws Exception{
        DBoperation.deleteElementData(patientKey);
        elementValue = elementValueDtm.toString();
        DBoperation.insertElementData(inputElementId,patientKey,"HNXXXXXX"+patientKey.substring(patientKey.length()-3,patientKey.length()),elementValueDtm);
        executeJobAndAssertResult(patientKey,inputElementId,outputElementId);
    }

    public static void littlerunnerWhenMultipleInput(Map<String,String> inputElementMap, String outputElementId, String patientKey) throws Exception{
        DBoperation.deleteElementData(patientKey);
        elementValue = inputElementMap.toString();
        DBoperation.insertElementData(inputElementMap, patientKey, "HNXXXXXX" + patientKey.substring(patientKey.length() - 3, patientKey.length()));
        executeJobAndAssertResult(patientKey,inputElementMap.toString(),outputElementId);
    }

    public static void executeJobAndAssertResult(String patientKey,String inputElementId,String outputElementId) throws Exception{
        Thread.sleep(100);
        DBoperation.resetJob();
        DBoperation.executeJob();
        List<String> outputList =  DBoperation.returnQueryList(patientKey,"VH");
        if (outputList.contains(outputElementId)){
            System.out.println("When input "+inputElementId+" with value "+elementValue+" should generate output "+outputElementId + " , rule validate succeed");
        }else{
            System.out.println("Input :"+inputElementId + " value : "+ elementValue +" and actual output is " +outputList + " and expected output is "+outputElementId+" rule validate fail");
        }
    }
    public static void executeJobAndAssertResult() throws Exception{
        Thread.sleep(100);
        DBoperation.resetJob();
        DBoperation.executeJob();
    }

    public static void main(String[] args) throws Exception{

    }
}
