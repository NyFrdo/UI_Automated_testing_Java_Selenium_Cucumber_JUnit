import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataConvert {

    public static String elementValue = "";

    public static void littleRunner(String inputElementId,String outputElementId,String elementValueString,String patientKey) throws Exception{
//        DBoperation.deleteElementData(patientKey);
//        elementValue = elementValueString;
//        DBoperation.insertElementData(inputElementId,patientKey,"HNXXXXXX"+patientKey.substring(patientKey.length()-3,patientKey.length()),elementValue);
        executeJobAndLogResult(patientKey,inputElementId,outputElementId);
    }

    public static void littleRunner(String inputElementId,String outputElementId,Integer elementValueDtm,String patientKey) throws Exception{
        DBoperation.deleteElementData(patientKey);
        elementValue = elementValueDtm.toString();
        DBoperation.insertElementData(inputElementId,patientKey,"HNXXXXXX"+patientKey.substring(patientKey.length()-3,patientKey.length()),elementValueDtm);
        executeJobAndLogResult(patientKey,inputElementId,outputElementId);
    }

    public static void littleRunnerWhenMultipleInput(Map<String,String> inputElementMap, String outputElementId, String patientKey) throws Exception{
        DBoperation.deleteElementData(patientKey);
        elementValue = inputElementMap.toString();
        DBoperation.insertElementData(inputElementMap, patientKey, "HNXXXXXX" + patientKey.substring(patientKey.length() - 3, patientKey.length()));
        executeJobAndLogResult(patientKey,inputElementMap.toString(),outputElementId);
    }

    public static void executeJobAndLogResult(String patientKey,String inputElementId,String outputElementId) throws Exception{
        Thread.sleep(175);
        DBoperation.resetJob();
        DBoperation.executeJob();
        List<String> outputList =  DBoperation.returnQueryList(patientKey,"VH");
        if (outputList.contains(outputElementId)){
            System.out.println("When input "+inputElementId+" with value "+elementValue+" should generate output "+outputElementId + " , rule validate succeed");
        }else{
            System.out.println("Input :"+inputElementId + " value : "+ elementValue +" and actual output is " +outputList + " and expected output is "+outputElementId+" rule validate fail");
        }
    }
    public static void executeJobAndLogResult() throws Exception{
        Thread.sleep(100);
        DBoperation.resetJob();
        DBoperation.executeJob();
    }

    public static void main(String[] args) throws Exception{

    }
}
