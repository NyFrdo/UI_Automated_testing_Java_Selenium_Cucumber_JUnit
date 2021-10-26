package util;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBoperation {
    public static final String URL = "jdbc:sqlserver://192.168.101.220:62658;databasename=cmdctr_db";
    public static final String USER = "sa";
    public static final String PASSWORD = "P@ssw0rd";
    public static Connection conn;
    public static void connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
        String sql = " delete from clin_cc_element_data where patient_key = ? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,patientKey);
        return  pst.executeUpdate();
    }

    public static String getAdmissionTime(String patientKey) throws Exception{
        List<String> list = new ArrayList<>();
        String sql = "select adm_dtm from cc_ward_detail_view where patient_key = ? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,patientKey);
        ResultSet rs = pst.executeQuery() ;
        while(rs.next()){
            list.add(rs.getString("adm_dtm"));
        }
        return  list.get(0);
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
        String sql = " insert into clin_cc_element_data (element_id,element_type,hosp,patient_key,case_no,adm_dtm,day_id,ref_data_dtm,data_status,record_key_1,record_key_2," +
                "update_dtm,element_value_dec,display_dtm) values(?,'indicator','VH',?,?,'2021-02-25 07:57:00.000','20210629','"
                +LocalDateTime.parse(getAdmissionTime(patientKey), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS")).plusDays(1)+"','1','',''," +
                "convert(datetime,'2021-09-02 17:22:00', 20),?,'') ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,elementId);
        pst.setString(2,patientKey);
        pst.setString(3,caseNo);
        pst.setString(4,elementValue);
        return  pst.executeUpdate();
    }



    public static Integer insertElementData(String elementId, String patientKey, String caseNo , Integer elementValueDtm) throws Exception{
        String sql = " insert into clin_cc_element_data (element_id,element_type,hosp,patient_key,case_no,adm_dtm,day_id,ref_data_dtm,data_status,record_key_1,record_key_2," +
                "update_dtm,element_value_dec,display_dtm,element_value_dt) values(?,'indicator','VH',?,?,'2021-02-25 07:57:00.000','20210629','"+ LocalDateTime.parse(getAdmissionTime(patientKey), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS")).plusDays(1) +"','1','',''," +
                "convert(datetime,'2021-09-02 17:22:00', 20),'1','',dateadd(DAY, ?, CONVERT(date,GETDATE()))) ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,elementId);
        pst.setString(2,patientKey);
        pst.setString(3,caseNo);
        pst.setInt(4,elementValueDtm);
        return  pst.executeUpdate();
    }

     public static void resetJob() throws Exception{
        String sql = "update clin_cc_process_control set job_max_fail_count = 3," +
                "data_commit_dtm = convert(datetime,'2021-09-02 17:20:00', 20)," +
                "data_from_dtm = convert(datetime,'2021-09-02 17:20:00', 20)," +
                "data_to_dtm = convert(datetime,'2021-09-02 17:30:00', 20)," +
                "job_interval_min = 10where job_name = 'job1';";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
    }

    public static void executeJob() throws Exception{
        String sql = "exec dbo.clin_cc_calculation_element_data 'job1',1";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
    }
}
