package runner;

import org.junit.Assert;
import util.DBoperation;
import util.DataConvert;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class apiRunner {
    public static Map<String,String> multipleInputList = new LinkedHashMap<>();

    public static void main(String[] args) throws Exception{
        fireRunner(true);
//        fireRunner(false);
    }

    public static void fireRunner(Boolean flag) throws  Exception{
        DBoperation.connect();
        if (flag){
            fireRunner("follow","fail");
        }else {
            fireRunner("not-Follow","succeed");
        }
    }

    public static void fireRunner(String filePrefix,String notExpectedKeyword) throws  Exception{
            File logFile = new File("log/log-"+filePrefix+"-Rules-"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) +".txt");
            emptyFile(logFile);
            //set output object to file
            System.setOut(new PrintStream(new FileOutputStream(logFile)));
            selectRunner(filePrefix);
            //reset output object to system output panel
            System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
            Assert.assertFalse("Validate "+filePrefix+", fail, please check log file",
                    Files.readAllLines(logFile.toPath()).toString().contains(notExpectedKeyword));
    }

    public static void selectRunner(String flag) throws  Exception{
        if (!flag.contains("not")) positiveRunner();else negativeRunner();
    }

    public static void emptyFile(File file) throws  Exception{
        if (file.exists()){
            file.delete();
        }
    }

    public static void negativeRunner() throws  Exception{
        System.out.println("1-5");
        DataConvert.littleRunner("100100","700100","101","000000793");
        System.out.println("1-6");
        DataConvert.littleRunner("100100","700101","90","000000793");
        System.out.println("1-7");
        DataConvert.littleRunner("100600","700601","90","000000793");
        System.out.println("1-8");
        DataConvert.littleRunner("100100","700111","110","000000793");
        System.out.println("1-9");
        DataConvert.littleRunner("100600","700611","110","000000793");
        System.out.println("1-10");
        DataConvert.littleRunner("100200","700200","50","000000793");
        System.out.println("1-11");
        DataConvert.littleRunner("100201","700201","50","000000793");
        System.out.println("1-12");
        DataConvert.littleRunner("100200","700202","50","000000793");
        System.out.println("1-13");
        DataConvert.littleRunner("100201","700203","50","000000793");
        System.out.println("1-15");
        DataConvert.littleRunner("100300","700300","90","000000793");
        System.out.println("1-16");
        DataConvert.littleRunner("100301","700301","90","000000793");
        System.out.println("1-17");
        DataConvert.littleRunner("100300","700310","91","000000793");
        System.out.println("1-18");
        DataConvert.littleRunner("100301","700311","91","000000793");
        System.out.println("1-20");
        DataConvert.littleRunner("100400","700400","10","000000793");
        System.out.println("1-25");
        DataConvert.littleRunner("100500","700500","36","000000793");
        System.out.println("1-26");
        DataConvert.littleRunner("100500","700501","36","000000793");
        System.out.println("1-30");
        DataConvert.littleRunner("100600","700600","101","000000793");
        System.out.println("1-31");
        DataConvert.littleRunner("100500","700521","37","000000793");
        System.out.println("1-32");
        DataConvert.littleRunner("100501","700522","37","000000793");
        System.out.println("1-36 37");
        DataConvert.littleRunner("100700","700701","4","000000793");
        DataConvert.littleRunner("100700","700702","12","000000793");
        System.out.println("1-38");
        DataConvert.littleRunner("101737","701737","0.1","000000793");
        System.out.println("1-39");
        DataConvert.littleRunner("101702","701702","20","000000793");
        System.out.println("1-40");
        DataConvert.littleRunner("100200","700210","100","000000793");
        System.out.println("1-41");
        DataConvert.littleRunner("100201","700211","100","000000793");
        System.out.println("1-42");
        DataConvert.littleRunner("100200","700212","110","000000793");
        System.out.println("1-43");
        DataConvert.littleRunner("100201","700213","110","000000793");
        System.out.println("1-45 46");
        DataConvert.littleRunner("100400","700410","20","000000793");
        DataConvert.littleRunner("100400","700411","20","000000793");
        System.out.println("1-47");
        DataConvert.littleRunner("100400","700421","14","000000793");
        System.out.println("1-60");
        DataConvert.littleRunner("100500","700510","37","000000793");
        System.out.println("1-65");
        DataConvert.littleRunner("100300","702900","100","000000793");
        System.out.println("1-70");
        DataConvert.littleRunner("102700","702700","10","000000793");
        System.out.println("1-75");
        DataConvert.littleRunner("102000","702000", 3,"000000793");
        System.out.println("1-77 78");
        DataConvert.littleRunner("100300","702001", "10","000000793");
        DataConvert.littleRunner("100300","702101", "10","000000793");
        System.out.println("1-80");
        DataConvert.littleRunner("102100","702100", 3,"000000793");
        System.out.println("1-90");
        DataConvert.littleRunner("101010","701010", "5","000000793");
        System.out.println("1-100");
        DataConvert.littleRunner("100005","700005", "15","000000793");
        System.out.println("5-5");
        multipleInputList.put(("102800"+","+"Integar"),"2");
        DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500720","000000793");//MID 700521 SEC MID 500710
        multipleInputList.clear();
        System.out.println("5-20");
        multipleInputList.put(("100400"+","+"String"),"22");
        DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500720","000000793");//MID 700410 700005
        multipleInputList.clear();

        multipleInputList.put(("100500"+","+"String"),"13");
        DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500720","000000793");//MID 700410 700005
        multipleInputList.clear();

        multipleInputList.put(("100600"+","+"String"),"101");
        DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500720","000000793");//MID 700410 700005
        multipleInputList.clear();
        System.out.println("10-5");
        DataConvert.littleRunner("100000","500000","6","000000793");
        System.out.println("10-35");
        DataConvert.littleRunner("102800","500600",-2,"000000793");
        System.out.println("10-40");
        DataConvert.littleRunner("102800","500620",-3,"000000793");
    }

    public static void positiveRunner() throws  Exception{
        System.out.println("1-5");
        DataConvert.littleRunner("100100","700100","100","000000793");
//        util.DataConvert.littleRunner("100100","700100","99","000000793");
//        System.out.println("1-6");
//        util.DataConvert.littleRunner("100100","700101","80","000000793");
//        util.DataConvert.littleRunner("100100","700101","70","000000793");
//        util.DataConvert.littleRunner("100100","700101","200","000000793");
//        util.DataConvert.littleRunner("100100","700101","210","000000793");
//        System.out.println("1-7");
//        util.DataConvert.littleRunner("100600","700601","80","000000793");
//        util.DataConvert.littleRunner("100600","700601","70","000000793");
//        util.DataConvert.littleRunner("100600","700601","200","000000793");
//        util.DataConvert.littleRunner("100600","700601","210","000000793");
//        System.out.println("1-8");
//        util.DataConvert.littleRunner("100100","700111","95","000000793");
//        util.DataConvert.littleRunner("100100","700111","100","000000793");
//        util.DataConvert.littleRunner("100100","700111","200","000000793");
//        util.DataConvert.littleRunner("100100","700111","210","000000793");
//        System.out.println("1-9");
//        util.DataConvert.littleRunner("100600","700611","95","000000793");
//        util.DataConvert.littleRunner("100600","700611","100","000000793");
//        util.DataConvert.littleRunner("100600","700611","200","000000793");
//        util.DataConvert.littleRunner("100600","700611","210","000000793");
//        System.out.println("1-10");
//        util.DataConvert.littleRunner("100200","700200","49","000000793");
//        util.DataConvert.littleRunner("100200","700200","40","000000793");
//        System.out.println("1-11");
//        util.DataConvert.littleRunner("100201","700201","49","000000793");
//        util.DataConvert.littleRunner("100201","700201","40","000000793");
//        System.out.println("1-12");
//        util.DataConvert.littleRunner("100200","700202","40","000000793");
//        util.DataConvert.littleRunner("100200","700202","35","000000793");
//
//        util.DataConvert.littleRunner("100200","700222","40","000000793");
//        util.DataConvert.littleRunner("100200","700222","35","000000793");
//        util.DataConvert.littleRunner("100200","700222","111","000000793");
//        util.DataConvert.littleRunner("100200","700222","120","000000793");
//        System.out.println("1-13");
//        util.DataConvert.littleRunner("100201","700203","40","000000793");
//        util.DataConvert.littleRunner("100201","700203","35","000000793");
//
//        util.DataConvert.littleRunner("100201","700223","40","000000793");
//        util.DataConvert.littleRunner("100201","700223","35","000000793");
//        util.DataConvert.littleRunner("100201","700223","111","000000793");
//        util.DataConvert.littleRunner("100201","700223","120","000000793");
//        System.out.println("1-15");
//        util.DataConvert.littleRunner("100300","700300","89","000000793");
//        util.DataConvert.littleRunner("100300","700300","80","000000793");
//        System.out.println("1-16");
//        util.DataConvert.littleRunner("100301","700301","89","000000793");
//        util.DataConvert.littleRunner("100301","700301","80","000000793");
//        System.out.println("1-17");
//        util.DataConvert.littleRunner("100300","700310","90","000000793");
//        util.DataConvert.littleRunner("100300","700310","80","000000793");
        System.out.println("1-18");
        DataConvert.littleRunner("100301","700311","90","000000793");
        DataConvert.littleRunner("100301","700311","80","000000793");
//        System.out.println("1-20");
//        util.DataConvert.littleRunner("100400","700400","8","000000793");
//        System.out.println("1-21");
//        util.DataConvert.littleRunner("100400","700401","8","000000793");
//        util.DataConvert.littleRunner("100400","700401","5","000000793");
//        System.out.println("1-25");
//        util.DataConvert.littleRunner("100500","700500","35.0","000000793");
//        System.out.println("1-26");
//        util.DataConvert.littleRunner("100500","700501","35","000000793");
//        util.DataConvert.littleRunner("100500","700501","34.0","000000793");
//        util.DataConvert.littleRunner("100500","700501","38.6","000000793");
//        util.DataConvert.littleRunner("100500","700501","39","000000793");
//        System.out.println("1-30");
//        util.DataConvert.littleRunner("100600","700600","100","000000793");
//        util.DataConvert.littleRunner("100600","700600","99","000000793");
//        System.out.println("1-31");
//        util.DataConvert.littleRunner("100500","700521","36","000000793");
//        util.DataConvert.littleRunner("100500","700521","35.5","000000793");
//        util.DataConvert.littleRunner("100500","700521","39.1","000000793");
//        util.DataConvert.littleRunner("100500","700521","40.0","000000793");
//        System.out.println("1-32");
//        util.DataConvert.littleRunner("100501","700522","36","000000793");
//        util.DataConvert.littleRunner("100501","700522","35.5","000000793");
//        util.DataConvert.littleRunner("100501","700522","39.1","000000793");
//        util.DataConvert.littleRunner("100501","700522","40.0","000000793");
//        System.out.println("1-36 37");
//        util.DataConvert.littleRunner("100700","700701","3","000000793");
//        util.DataConvert.littleRunner("100700","700702","15","000000793");
//        System.out.println("1-38");
//        util.DataConvert.littleRunner("101737","701737","1","000000793");
//        System.out.println("1-39");
//        util.DataConvert.littleRunner("101702","701702","24","000000793");
//        System.out.println("1-40");
//        util.DataConvert.littleRunner("100200","700210","101","000000793");
//        util.DataConvert.littleRunner("100200","700210","110","000000793");
//        System.out.println("1-41");
//        util.DataConvert.littleRunner("100201","700211","101","000000793");
//        util.DataConvert.littleRunner("100201","700211","110","000000793");
//        System.out.println("1-42");
//        util.DataConvert.littleRunner("100200","700212","111","000000793");
//        util.DataConvert.littleRunner("100200","700212","115","000000793");
//        System.out.println("1-43");
//        util.DataConvert.littleRunner("100201","700213","111","000000793");
//        util.DataConvert.littleRunner("100201","700213","115","000000793");
//        System.out.println("1-45 46");
//        util.DataConvert.littleRunner("100400","700410","22","000000793");
//        util.DataConvert.littleRunner("100400","700411","21","000000793");
//        System.out.println("1-47");
//        util.DataConvert.littleRunner("100400","700421","15","000000793");
//        util.DataConvert.littleRunner("100400","700421","18","000000793");
//        System.out.println("1-60");
//        util.DataConvert.littleRunner("100500","700510","38.5","000000793");
//        System.out.println("1-65");
//        util.DataConvert.littleRunner("100300","702900","40","000000793");
//        System.out.println("1-70");
//        util.DataConvert.littleRunner("102700","702700","4","000000793");
//        System.out.println("1-75 77");
//        util.DataConvert.littleRunner("102000","702000", 2,"000000793");
//        util.DataConvert.littleRunner("102000","702000",1,"000000793");
//        util.DataConvert.littleRunner("102000","702001",1,"000000793");
//        System.out.println("1-78 80");
//        util.DataConvert.littleRunner("102100","702100", 2,"000000793");
//        util.DataConvert.littleRunner("102100","702100", 1,"000000793");
//        util.DataConvert.littleRunner("102100","702101",1,"000000793");
//        System.out.println("1-90");
//        util.DataConvert.littleRunner("101010","701010", "6","000000793");
//        util.DataConvert.littleRunner("101010","701010","10","000000793");
//        System.out.println("1-100");
//        util.DataConvert.littleRunner("100005","700005", "13","000000793");
//        util.DataConvert.littleRunner("100005","700005", "10","000000793");
//        System.out.println("3-5");
//        util.DataConvert.littleRunner("100500","500710","36","000000793");//MID 700521
//        util.DataConvert.littleRunner("100501","500710","36","000000793");//MID 700522
//        util.DataConvert.littleRunner("100100","500710","95","000000793");//MID 700111
//        util.DataConvert.littleRunner("100600","500710","95","000000793");//MID 700611
//        util.DataConvert.littleRunner("100200","500710","40","000000793");//MID 700222
//        util.DataConvert.littleRunner("100201","500710","40","000000793");//MID 700223
//        util.DataConvert.littleRunner("100400","500710","8","000000793");//MID 700401
//        util.DataConvert.littleRunner("100400","500710","15","000000793");//MID 700421
//        util.DataConvert.littleRunner("100300","500710","90","000000793");//MID 700310
//        util.DataConvert.littleRunner("101031","500710","1","000000793");
//        System.out.println("3-10");
//        util.DataConvert.littleRunner("100700","700311","3","000000793");//MID 700701
//        util.DataConvert.littleRunner("100700","700311","15","000000793");//MID 700702
//        util.DataConvert.littleRunner("101702","700311","24","000000793");//MID 701702
//        util.DataConvert.littleRunner("101737","700311","1","000000793");//MID 701737
//        System.out.println("3-20");
//        util.DataConvert.littleRunner("100600","700312","100","000000793");//MID 700600
//        util.DataConvert.littleRunner("100100","700312","80","000000793");//MID 700100
//        System.out.println("5-5");
//
//        multipleInputList.put(("102800"+","+"Integar"),"2");
//        multipleInputList.put(("100500"+","+"String"),"36");
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500720","000000793");//MID 700521 SEC MID 500710
//        multipleInputList.clear();
//        System.out.println("5-20");
//        multipleInputList.put(("100400"+","+"String"),"22");
//        multipleInputList.put(("100005"+","+"String"),"13");
//        multipleInputList.put(("100600"+","+"String"),"100");
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"700313","000000793");//MID 700410 700005 700312
//        multipleInputList.clear();
//
//        multipleInputList.put(("100400"+","+"String"),"22");
//        multipleInputList.put(("100005"+","+"String"),"13");
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"700313","000000793");//MID 700410 700005
//        multipleInputList.clear();
//
//        multipleInputList.put(("100400"+","+"String"),"22");
//        multipleInputList.put(("100600"+","+"String"),"100");
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"700313","000000793");//MID 700410 700005
//        multipleInputList.clear();
//
//        multipleInputList.put(("100005"+","+"String"),"13");
//        multipleInputList.put(("100600"+","+"String"),"100");
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"700313","000000793");//MID 700410 700005
//        multipleInputList.clear();
//
//        System.out.println("10-5");
//        util.DataConvert.littleRunner("100000","500000","8","000000793");
//        System.out.println("10-10");
//        util.DataConvert.littleRunner("100100","500100","80","000000793");//MID 700101
//        util.DataConvert.littleRunner("100200","500100","40","000000793");//MID 700202
//        util.DataConvert.littleRunner("100200","500100","111","000000793");//MID 700212
//        util.DataConvert.littleRunner("100300","500100","89","000000793");//MID 700300
//        util.DataConvert.littleRunner("100400","500100","8","000000793");//MID 700401
//        util.DataConvert.littleRunner("100400","500100","21","000000793");//MID 700411
//        util.DataConvert.littleRunner("100600","500100","80","000000793");//MID 700601
//        util.DataConvert.littleRunner("100201","500100","40","000000793");//MID 700203
//        util.DataConvert.littleRunner("100201","500100","111","000000793");//MID 700213
//        util.DataConvert.littleRunner("100301","500100","89","000000793");//MID 700301
//        util.DataConvert.littleRunner("100500","500100","35","000000793");//MID 700501
//        util.DataConvert.littleRunner("100005","500100","13","000000793");//MID 700005
//        util.DataConvert.littleRunner("101031","500100","1","000000793");//MID 700005
//        System.out.println("10-15");
//        util.DataConvert.littleRunner("100500","500200","34.9","000000793");//MID 700500
//        util.DataConvert.littleRunner("100100","500200","80","000000793");//MID 700100
//        util.DataConvert.littleRunner("100600","500200","100","000000793");//MID 700600
//        util.DataConvert.littleRunner("100200","500200","40","000000793");//MID 700200
//        util.DataConvert.littleRunner("100300","500200","89","000000793");//MID 700300
//        System.out.println("10-20");
//        multipleInputList.put(("100500"+","+"String"),"35");//700500
//        multipleInputList.put(("100700"+","+"String"),"15");//700311
//
//        multipleInputList.put(("100400"+","+"String"),"22");//700313
//        multipleInputList.put(("100600"+","+"String"),"100");
//
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500300","000000793");
//        multipleInputList.clear();
//
//        multipleInputList.put(("100500"+","+"String"),"35");
//        multipleInputList.put(("100301"+","+"String"),"90");
//
//        multipleInputList.put(("100400"+","+"String"),"22");
//        multipleInputList.put(("100600"+","+"String"),"100");
//
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500300","000000793");
//        multipleInputList.clear();
//
//        multipleInputList.put(("100500"+","+"String"),"35");
//        multipleInputList.put(("101702"+","+"String"),"24");
//
//        multipleInputList.put(("100400"+","+"String"),"22");
//        multipleInputList.put(("100600"+","+"String"),"100");
//
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500300","000000793");
//        multipleInputList.clear();
//
//        multipleInputList.put(("100500"+","+"String"),"35");
//        multipleInputList.put(("101737"+","+"String"),"1");
//
//        multipleInputList.put(("100400"+","+"String"),"22");
//        multipleInputList.put(("100005"+","+"String"),"13");
//
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500300","000000793");
//        multipleInputList.clear();
//
//        System.out.println("10-25");
//        util.DataConvert.littleRunner("100702","500400","1","000000793");
//        util.DataConvert.littleRunner("100708","500400","1","000000793");
//        util.DataConvert.littleRunner("100709","500400","1","000000793");
//        util.DataConvert.littleRunner("100710","500400","1","000000793");
//        util.DataConvert.littleRunner("100711","500400","1","000000793");
//        util.DataConvert.littleRunner("100712","500400","1","000000793");
//        util.DataConvert.littleRunner("100713","500400","1","000000793");
//        util.DataConvert.littleRunner("100714","500400","1","000000793");
//        util.DataConvert.littleRunner("100715","500400","1","000000793");
//        util.DataConvert.littleRunner("100716","500400","1","000000793");
//        util.DataConvert.littleRunner("100717","500400","1","000000793");
//        util.DataConvert.littleRunner("100718","500400","1","000000793");
//        util.DataConvert.littleRunner("100719","500400","1","000000793");
//        util.DataConvert.littleRunner("100720","500400","1","000000793");
//        util.DataConvert.littleRunner("100721","500400","1","000000793");
//        util.DataConvert.littleRunner("100722","500400","1","000000793");
//        util.DataConvert.littleRunner("100723","500400","1","000000793");
//        util.DataConvert.littleRunner("100724","500400","1","000000793");
//        util.DataConvert.littleRunner("100725","500400","1","000000793");
//        util.DataConvert.littleRunner("100726","500400","1","000000793");
//        util.DataConvert.littleRunner("100727","500400","1","000000793");
//        util.DataConvert.littleRunner("100728","500400","1","000000793");
//        util.DataConvert.littleRunner("100729","500400","1","000000793");
//        util.DataConvert.littleRunner("100730","500400","1","000000793");
//        util.DataConvert.littleRunner("100731","500400","1","000000793");
//        util.DataConvert.littleRunner("100732","500400","1","000000793");
//        util.DataConvert.littleRunner("100737","500400","1","000000793");
//        util.DataConvert.littleRunner("100738","500400","1","000000793");
//
//        System.out.println("10-30");
//        util.DataConvert.littleRunner("101100","500500","1","000000793");
//        util.DataConvert.littleRunner("101200","500500","1","000000793");
//        util.DataConvert.littleRunner("101300","500500","1","000000793");
//        util.DataConvert.littleRunner("101400","500500","1","000000793");
//        util.DataConvert.littleRunner("101500","500500","1","000000793");
//        util.DataConvert.littleRunner("101600","500500","1","000000793");
//        util.DataConvert.littleRunner("101700","500500","1","000000793");
//        util.DataConvert.littleRunner("101800","500500","1","000000793");
//        util.DataConvert.littleRunner("101900","500500","1","000000793");
//
//        System.out.println("10-35");
//        util.DataConvert.littleRunner("102800","500600",-1,"000000793");
//        util.DataConvert.littleRunner("102800","500600",0,"000000793");
//
//        System.out.println("10-40");
//        util.DataConvert.littleRunner("102800","500620",-2,"000000793");
//        util.DataConvert.littleRunner("102800","500620",0,"000000793");
//
//        System.out.println("10-50");
//        util.DataConvert.littleRunner("102200","500800","1","000000793");
//        util.DataConvert.littleRunner("102300","500800","1","000000793");
//        util.DataConvert.littleRunner("102400","500800","1","000000793");
//        util.DataConvert.littleRunner("102500","500800","1","000000793");
//
//        System.out.println("10-60");
//        util.DataConvert.littleRunner("102800","500700",-1,"000000793");
//
//        multipleInputList.put(("102800"+","+"Integar"),"2");
//        multipleInputList.put(("100500"+","+"String"),"36");
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"500700","000000793");//MID 700521 SEC MID 500710
//        multipleInputList.clear();
//
//
//        System.out.println("10-65");
////        util.DataConvert.littleRunner("100300","501000","10","000000793");//702001
//        util.DataConvert.littleRunner("102100","702101",1,"000000793");//702101
//
//        multipleInputList.put(("102100"+","+"Integar"),"1");
//        util.DataConvert.littleRunnerWhenMultipleInput(multipleInputList,"501000","000000793");
//        multipleInputList.clear();
    }



}
