import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class runner {

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

    public static void executeJobAndAssertResult(String patientKey,String inputElementId,String outputElementId) throws Exception{
        Thread.sleep(100);
        DBoperation.resetJob();
        DBoperation.executeJob();
        List<String> outputList =  DBoperation.returnQueryList(patientKey,"VH");
        if (outputList.contains(outputElementId)){
            System.out.println("When input "+inputElementId+" with value "+elementValue+" should generate output "+outputElementId + " , rule validate succeed");
        }else{
            System.out.println("Rule failed with input :"+inputElementId + " value : "+ elementValue +" and actual output is " +outputList + " and expected output is "+outputElementId);
        }
    }

    public static void main(String[] args) throws Exception{
        DBoperation.connect();
        System.out.println("1-5");
        littlerunner("100100","700100","89","000000793");
        littlerunner("100100","700100","80","000000793");
        littlerunner("100100","700100","181","000000793");
        littlerunner("100100","700100","191","000000793");
        System.out.println("1-6");
        littlerunner("100100","700101","80","000000793");
        littlerunner("100100","700101","70","000000793");
        littlerunner("100100","700101","200","000000793");
        littlerunner("100100","700101","210","000000793");
        System.out.println("1-7");
        littlerunner("100600","700601","80","000000793");
        littlerunner("100600","700601","70","000000793");
        littlerunner("100600","700601","200","000000793");
        littlerunner("100600","700601","210","000000793");
        System.out.println("1-8");
        littlerunner("100100","700111","95","000000793");
        littlerunner("100100","700111","100","000000793");
        littlerunner("100100","700111","200","000000793");
        littlerunner("100100","700111","210","000000793");
        System.out.println("1-9");
        littlerunner("100600","700611","95","000000793");
        littlerunner("100600","700611","100","000000793");
        littlerunner("100600","700611","200","000000793");
        littlerunner("100600","700611","210","000000793");
        System.out.println("1-10");
        littlerunner("100200","700200","49","000000793");
        littlerunner("100200","700200","40","000000793");
        System.out.println("1-11");
        littlerunner("100201","700201","49","000000793");
        littlerunner("100201","700201","40","000000793");
        System.out.println("1-12");
        littlerunner("100200","700202","40","000000793");
        littlerunner("100200","700202","35","000000793");

        littlerunner("100200","700222","45","000000793");
        littlerunner("100200","700222","50","000000793");
        littlerunner("100200","700222","101","000000793");
        littlerunner("100200","700222","110","000000793");
        System.out.println("1-13");
        littlerunner("100201","700203","40","000000793");
        littlerunner("100201","700203","35","000000793");

        littlerunner("100201","700223","45","000000793");
        littlerunner("100201","700223","50","000000793");
        littlerunner("100201","700223","101","000000793");
        littlerunner("100201","700223","110","000000793");
        System.out.println("1-15");
        littlerunner("100300","700300","89","000000793");
        littlerunner("100300","700300","80","000000793");
        System.out.println("1-16");
        littlerunner("100301","700301","89","000000793");
        littlerunner("100301","700301","80","000000793");
        System.out.println("1-17");
        littlerunner("100300","700310","90","000000793");
        littlerunner("100300","700310","80","000000793");
        System.out.println("1-18");
        littlerunner("100301","700311","90","000000793");
        littlerunner("100301","700311","80","000000793");
        System.out.println("1-20");
        littlerunner("100400","700400","8","000000793");
        System.out.println("1-21");
        littlerunner("100400","700401","8","000000793");
        littlerunner("100400","700401","5","000000793");
        System.out.println("1-25");
        littlerunner("100500","700500","34.9","000000793");
        littlerunner("100500","700500","34.0","000000793");
        littlerunner("100500","700500","37.9","000000793");
        littlerunner("100500","700500","38.5","000000793");
        System.out.println("1-26");
        littlerunner("100500","700501","35","000000793");
        littlerunner("100500","700501","34.0","000000793");
        littlerunner("100500","700501","38.6","000000793");
        littlerunner("100500","700501","39","000000793");
        System.out.println("1-27");
        littlerunner("100501","700511","35","000000793");
        littlerunner("100501","700511","34.0","000000793");
        littlerunner("100501","700511","38.6","000000793");
        littlerunner("100501","700511","39","000000793");
        System.out.println("1-28");
        littlerunner("100500","700510","34.9","000000793");
        littlerunner("100500","700510","34.0","000000793");
        littlerunner("100500","700510","37.9","000000793");
        littlerunner("100500","700510","38.5","000000793");
        System.out.println("1-30");
        littlerunner("100600","700600","101","000000793");
        littlerunner("100600","700600","101","000000793");
        System.out.println("1-31");
        littlerunner("100500","700521","36","000000793");
        littlerunner("100500","700521","35.5","000000793");
        littlerunner("100500","700521","39.1","000000793");
        littlerunner("100500","700521","40.0","000000793");
        System.out.println("1-32");
        littlerunner("100501","700522","36","000000793");
        littlerunner("100501","700522","35.5","000000793");
        littlerunner("100501","700522","39.1","000000793");
        littlerunner("100501","700522","40.0","000000793");
        System.out.println("1-35");
        littlerunner("100700","700700","4","000000793");
        littlerunner("100700","700700","2","000000793");
        littlerunner("100700","700700","12","000000793");
        littlerunner("100700","700700","15","000000793");
        System.out.println("1-40");
        littlerunner("100200","700210","101","000000793");
        littlerunner("100200","700210","110","000000793");
        System.out.println("1-41");
        littlerunner("100201","700211","101","000000793");
        littlerunner("100201","700211","110","000000793");
        System.out.println("1-42");
        littlerunner("100200","700212","111","000000793");
        littlerunner("100200","700212","115","000000793");
        System.out.println("1-43");
        littlerunner("100201","700213","111","000000793");
        littlerunner("100201","700213","115","000000793");
        System.out.println("1-45 46");
        littlerunner("100400","700410","22","000000793");
        littlerunner("100400","700411","21","000000793");
        System.out.println("1-47");
        littlerunner("100400","700421","15","000000793");
        littlerunner("100400","700421","18","000000793");
        System.out.println("1-60");
        littlerunner("100500","700510","40","000000793");
        littlerunner("100500","700510","90","000000793");
        System.out.println("1-65");
        littlerunner("100300","702900","40","000000793");
        System.out.println("1-70");
        littlerunner("102700","702700","4","000000793");
        System.out.println("1-75");
        littlerunner("102000","702000", 2,"000000793");
        littlerunner("102000","702000",1,"000000793");
        System.out.println("1-80");
        littlerunner("102100","702100", 1,"000000793");
        littlerunner("102100","702100",1,"000000793");
        System.out.println("1-90");
        littlerunner("101010","701010", "6","000000793");
        littlerunner("101010","701010","10","000000793");
        System.out.println("1-100");
        littlerunner("100005","700005", "13","000000793");
        littlerunner("100005","700005","10","000000793");
    }
}
