/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author extslouppe
 */
@SuppressWarnings("InitializerMayBeStatic")
public class CHECK_MSISDN_IN_ODS {

    private static Statement st = null;
    private static ResultSet rs = null;
    private static Connection con = null;
    private static final String backend = "ODS";

//    public CHECK_MSISDN_IN_ODS() {
//        
//        performControll();
//        
//        JOptionPane.showMessageDialog(null, "Check in ODS performed", "Check in ODS performed", JOptionPane.INFORMATION_MESSAGE);
//        
//    }       
    static void spustCheckODS(int prostredi) {

        performControll(prostredi);

        JOptionPane.showMessageDialog(null, "Check in ODS performed", "Check in ODS performed", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void performControll(int prostredi) {
        String MSISDN = null;

        while ((MSISDN = OutputInputFile.getMSISDN(backend)) != null && (MSISDN = OutputInputFile.getMSISDN(backend)).length() == 9) {

            System.out.println(MSISDN);

            checkMSISDNInODS(MSISDN, prostredi);

        }
    }

    public static void checkMSISDNInODS(String MSISDN, int prostredi) {
        int MSISDN_COUNT = 0;

        try {

            con = dbConnection.dbConnection_dwh(prostredi);
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(life.qsub_msisdn) AS MSISDN_COUNT FROM sy_qsub.qsub_sub_life life WHERE life.qsub_msisdn like '" + MSISDN + "' GROUP BY life.qsub_msisdn");

            while (rs.next()) {
                MSISDN_COUNT = rs.getInt("MSISDN_COUNT");
            }

//            Pokud se ze selectu vrátí více jak 0 řádků, pak MSISDN existuje v ODS
            if (MSISDN_COUNT > 0) {
                OutputInputFile.writeResultOffCheck(MSISDN, backend, "OK");
            } else {
                OutputInputFile.writeResultOffCheck(MSISDN, backend, "NOK");
            }

        } catch (SQLException ex) {

            System.out.printf("Spojení do DB nebylo navázáno");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
