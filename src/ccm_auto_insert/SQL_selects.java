/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import generatorRC.RcGenerator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Petr
 */
public class SQL_selects {

    /*Vrací prostředí pro DB*/
    public static String fun_prostredi(int back_prostredi) {
        String str_prostredi = null;

        if (back_prostredi == 1) {
            str_prostredi = "";

        } else if (back_prostredi == 2) {
            str_prostredi = "2";
        }
        return str_prostredi;
    }

    /*Vraci volne ICO z DB*/
    public static String ICOdatabase(Connection con, int prostredi) throws SQLException {
        String ICO = null;
        Statement stmt = null;

        String query = "SELECT   qcusalb_compreg_no\n"
                + "    FROM qcus_cm_albertina a\n"
                + "   WHERE NOT EXISTS (SELECT *\n"
                + "                     FROM sy_qcus.qcus_cus_personal_info p\n"
                + "                     WHERE p.qcus_compreg_no = a.qcusalb_compreg_no)\n"
                + "     AND a.qcusalb_nefi_list_flg IS NULL                   --neexistuje v NEFI\n"
                + "     AND QCUSALB_VALID_TO_DAT IS NULL -- spolecnost neni zrusena\n"
                + "     AND a.qcusalb_compreg_no > 2220000\n"
                + "     AND a.qcusalb_compreg_no NOT IN (\n"
                + "                      SELECT ccm.compregno\n"
                + "                      FROM sy_ccm.ccm_contacts@Q"
                + fun_prostredi(prostredi)
                + "AP01.WORLD ccm\n"
                + "                      INNER JOIN qcus_cm_albertina a\n"
                + "                      ON ccm.compregno=a.qcusalb_compreg_no                    \n"
                + "                      )\n"
                + "     AND ROWNUM < 2\n"
                + "     AND a.qcusalb_qcuscct_code in ('7120','7121','7123', '7124','2100')\n"
                + "ORDER BY a.qcusalb_compreg_no";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            ICO = rs.getString("QCUSALB_COMPREG_NO");
            System.out.println("ICO: " + ICO);
        }
        con.close();
        return ICO;

    }

    /*Vrací volné ICCID*/
    public static String ICCIDdatabase(Connection con, int prostredi) throws SQLException {

        String ICCID = null;
        Statement stmt = null;

        String query
                = "SELECT ICCID\n"
                + "FROM SY_RST.RST_SIM_STORAGE_MEDIA \n"
                + "WHERE STATUS = 'r'\n"
                + "AND REQ_ID is null\n"
                + "AND LOCK_TO_DAT is null\n"
                + "AND DCDSEH_DCDSEH_ID = '15444'\n"
                + "AND F_LOGASL_ID is null\n"
                + "AND ASSIGN_DAT is null\n"
                + "and RSTEP_RSTEP_ID = 89\n"
                + "and RSTGP_RSTGP_ID = 87\n"
                + "and RSTVE_RSTVE_COD = 30014\n"
                + "AND ROWNUM <2\n";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            ICCID = rs.getString("ICCID");
            System.out.println("ICCID: " + ICCID);
        }
        con.close();
        return ICCID;

    }

    public static String MSISDNforLE(Connection con, int prostredi) throws SQLException {

        String MSISDN = null;
        Statement stmt = null;

        String query
                = "select DN_NUM from sy_rst.rst_MSISDN_pool\n"
                + "where DNSEGMENT = 4\n"
                + "and DNSTATUS = 'R'\n"
                + "and ORIGIN = 1\n"
                + "and SAC_DN = 73\n"
                + "and OP_ID = 205\n"
                + "and CUST_RES is null\n"
                + "AND F_LOGASL_ID is null\n"
                + "AND LOCK_REQ_ID is null\n"
                + "and ROWNUM=1";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            MSISDN = rs.getString("DN_NUM");
            System.out.println("MSISDN " + MSISDN);
        }
        con.close();
        return MSISDN;

    }

    /*Vyber cisla karty pro voip*/
    public static String ICCIDVoip(Connection con, int prostredi) throws SQLException {

        String ICCID = null;
        Statement stmt = null;

        String query
                = "SELECT VOIPCARD_ID\n"
                + "FROM SY_RST.RST_VOIPCARD_POOL \n"
                + "WHERE STATUS='r'\n"
                + "AND OUTLET=15444\n"
                + "AND GRAPHIC_PROFILE=40000\n"
                + "AND F_LOGASL_ID is null\n"
                + "AND LOCK_REQ_ID is null\n"
                + "AND ASSIGN_DAT is null\n"
                + "AND ROWNUM=1";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            ICCID = rs.getString("VOIPCARD_ID");
            System.out.println("VOIPCARD_ID: " + ICCID);
        }
        con.close();
        return ICCID;

    }

    /*Vrací IMSI*/
    public static String IMSIDdatabase(Connection con, int prostredi, String ICCID) throws SQLException {

        String IMSI = null;
        Statement stmt = null;

        String query
                = "SELECT IMSI\n"
                + "FROM SY_RST.RST_SIM_STORAGE_MEDIA \n"
                + "WHERE ICCID='"
                + ICCID
                + "'";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            IMSI = rs.getString("IMSI");
            System.out.println("IMSI: " + IMSI);
        }
        con.close();
        return IMSI;

    }

    /*Vrací ExtCUID pro VOIPNG*/
    public static String ExtCUID(Connection con, int prostredi, String IDZadostiCCM) throws SQLException {

        String ExtCUID = null;
        Statement stmt = null;

        String query
                = "SELECT a.EXTERNAL_ID \n"
                + "FROM sy_ccm.ccm_units a  \n"
                + "where a.ccmreq_ccmreq_id ="
                + IDZadostiCCM
                + "AND a.ccmunt_ccmunt_id=2";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            ExtCUID = rs.getString("EXTERNAL_ID");
            System.out.println("EXTID_CU: " + ExtCUID);
        }
        con.close();
        return ExtCUID;

    }


    /*Vraci RC ktere neexsituje v DB*/
    public static String VerifiedRCDdatabase(Connection con, int prostredi) throws SQLException {

        String RC = null;
        int RC_COUNT = 0;
        Statement stmt = null;
        stmt = con.createStatement();

        RC = RcGenerator.generateRcForAge(19, 55);

        String query
                = "SELECT COUNT(QCUS_BIRTH_NO) as RC_COUNT, QCUS_BIRTH_NO as RC\n"
                + "FROM SY_QCUS.QCUS_CUS_PERSONAL_INFO info\n"
                + "WHERE INFO.QCUS_BIRTH_NO='"
                + RC + "'"
                + "GROUP BY INFO.QCUS_BIRTH_NO";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            RC_COUNT = rs.getInt("RC_COUNT");
        }
        /*Resi existenci RC v DB tim ze vygeneruje nove*/
        while (RC_COUNT > 0) {
            RC = RcGenerator.generateRcForAge(19, 55);
            query
                    = "SELECT COUNT(QCUS_BIRTH_NO) as RC_COUNT, QCUS_BIRTH_NO as RC\n"
                    + "FROM SY_QCUS.QCUS_CUS_PERSONAL_INFO info\n"
                    + "WHERE INFO.QCUS_BIRTH_NO='"
                    + RC + "'"
                    + "GROUP BY INFO.QCUS_BIRTH_NO";
            rs = stmt.executeQuery(query);
            if (rs.next() == true) {
                RC_COUNT = rs.getInt("RC_COUNT");
            } else {
                RC_COUNT = 0;
            }
        }
        con.close();
        return RC;

    }

    public static String getStatusCCMRequest(Connection con, int prostredi, String MSISDN) throws SQLException {
        String Status = null;
        Statement stmt = null;

        String query
                = "SELECT r.CCMREQ_ID as ID, r.CCMRST_CCMRST_ID as ID_STATUSU, s.NAME, r.MSISDN\n"
                + "FROM sy_ccm.ccm_requests r, CCM_REQUEST_STATES s\n"
                + "WHERE r.MSISDN='"
                + MSISDN
                + "'"
                + "AND s.CCMRST_ID = r.CCMRST_CCMRST_ID";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Status = rs.getString("ID_STATUSU");
            System.out.println("Id žádosti: " + rs.getString("ID"));
            System.out.println("Status žádosti: " + rs.getString("NAME"));
        }
        con.close();
        return Status;
    }

    public static String getIDRequest(Connection con, int prostredi, String MSISDN) throws SQLException {
        String IDRequest = null;
        Statement stmt = null;

        String query
                = "SELECT r.CCMREQ_ID as ID, r.CCMRST_CCMRST_ID as ID_STATUSU, s.NAME, r.MSISDN\n"
                + "FROM sy_ccm.ccm_requests r, CCM_REQUEST_STATES s\n"
                + "WHERE r.MSISDN='"
                + MSISDN
                + "'"
                + "AND s.CCMRST_ID = r.CCMRST_CCMRST_ID";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            IDRequest = rs.getString("ID");
            System.out.println("Id žádosti: " + rs.getString("ID"));
        }
        con.close();
        return IDRequest;
    }

}
