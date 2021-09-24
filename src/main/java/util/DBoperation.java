package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBoperation {
    public static String URL = "jdbc:"+ExcelUtil.getCell("dbtype")+"://"
            +ExcelUtil.getCell("dburl")+
            ":"+ExcelUtil.getCell("dbport")+";databasename="+ExcelUtil.getCell("dbInstance")+"";
    public static String USER = ExcelUtil.getCell("dbuser");
    public static String PASSWORD = ExcelUtil.getCell("dbpwd");
    public static String DRIVER = ExcelUtil.getCell("dbdriver");
    public static Connection conn;

    public static void connect() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connect succeed");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Connect fail");
        }
    }

    public static List<String> returnQueryList(String patientKey,String hospCode) throws Exception{
        List<String> list = new ArrayList<>();
        String sql = "select element_id from clin_cc_element_data where patient_key = ? and hosp = ? and data_status = 1  order by update_dtm  ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, patientKey);
        pst.setString(2, hospCode);
        ResultSet rs = pst.executeQuery() ;
        while(rs.next()){
            list.add(rs.getString("element_id"));
        }
        return list;
    }

    public static Integer deleteElementData(String patientKey) throws Exception{
        List<String> list = new ArrayList<>();
        String sql = " delete from clin_cc_element_data where patient_key = ? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,patientKey);
        return  pst.executeUpdate();
    }

    public static void insertElementData(Map<String,String> inputElementMap, String patientKey, String caseNo ) throws Exception{
        for (Map.Entry<String, String> entry : inputElementMap.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            String[] elementInfo = k.split(",");
//            System.out.println(k + v);
            switch (elementInfo[1]){
                case "Integar":
                    insertElementData(elementInfo[0],patientKey,"HNXXXXXX"+patientKey.substring(patientKey.length()-3,patientKey.length()),Integer.valueOf(v));
                    DataConvert.executeJobAndLogResult();
                    break;
                case "String":
                    insertElementData(elementInfo[0],patientKey,"HNXXXXXX"+patientKey.substring(patientKey.length()-3,patientKey.length()),v);
                    break;

            }
        }


    }

    public static Integer insertElementData(String elementId,String patientKey,String caseNo ,String elementValue) throws Exception{
        List<String> list = new ArrayList<>();
        String sql = " insert into clin_cc_element_data (element_id,element_type,hosp,patient_key,case_no,adm_dtm,day_id,ref_data_dtm,data_status,record_key_1,record_key_2," +
                "update_dtm,element_value_dec,display_dtm) values(?,'indicator','VH',?,?,'2021-02-25 07:57:00.000','20210629','2021-06-29 00:00:00.000','1','',''," +
                "'2021-06-29 00:00:00.000',?,'') ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,elementId);
        pst.setString(2,patientKey);
        pst.setString(3,caseNo);
        pst.setString(4,elementValue);
        return  pst.executeUpdate();
    }



    public static Integer insertElementData(String elementId, String patientKey, String caseNo , Integer elementValueDtm) throws Exception{
        List<String> list = new ArrayList<>();
        String sql = " insert into clin_cc_element_data (element_id,element_type,hosp,patient_key,case_no,adm_dtm,day_id,ref_data_dtm,data_status,record_key_1,record_key_2," +
                "update_dtm,element_value_dec,display_dtm,element_value_dt) values(?,'indicator','VH',?,?,'2021-02-25 07:57:00.000','20210629','2021-06-29 00:00:00.000','1','',''," +
                "'2021-06-29 00:00:00.000','1','',dateadd(DAY, ?, CONVERT(date,GETDATE()))) ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,elementId);
        pst.setString(2,patientKey);
        pst.setString(3,caseNo);
        pst.setInt(4,elementValueDtm);
        return  pst.executeUpdate();
    }

    public static void resetJob() throws Exception{
        List<String> list = new ArrayList<>();
        String sql = "TRUNCATE TABLE clin_cc_process_control;" +
                " INSERT INTO [dbo].[clin_cc_process_control]([job_name], [job_sequence], [data_from_dtm], [data_to_dtm], [data_commit_dtm], [job_last_success_dtm], [job_processing_dtm], [job_status], " +
                " [job_fail_count],  [job_interval_min]) VALUES " +
                " ('job1', 1, '2021-05-01 17:56:44.000', '2021-07-28 18:06:44.000', '2021-07-28 17:56:44.000', '2021-08-02 17:42:10.983',  '2021-08-02 17:42:10.967', '1', " +
                " 0,10);";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
    }

    public static void executeJob() throws Exception{
        List<String> list = new ArrayList<>();
        String sql = "exec dbo.clin_cc_calculation_element_data 'VH','job1',1";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
    }
}
