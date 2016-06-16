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
public class CHECK_MSISDN_IN_CLF {

    private static Statement st = null;
    private static ResultSet rs = null;
    private static Connection con = null;
    private static final String backend = "CLF";

    static void spustCheckCLF(int prostredi) {

        performControll(prostredi);

        JOptionPane.showMessageDialog(null, "Check in CLF performed", "Check in ODS performed", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void performControll(int prostredi) {
        String MSISDN = null;

        while ((MSISDN = OutputInputFile.getMSISDN(backend)) != null && (MSISDN = OutputInputFile.getMSISDN(backend)).length() == 9) {

            System.out.println(MSISDN);

            checkMSISDNInCLF(MSISDN, prostredi);

        }
    }

    public static void checkMSISDNInCLF(String MSISDN, int prostredi) {
        String MSISDN_target_status = null;
        String MSISDN_curr_network_status = null;

        try {

            con = dbConnection.dbConnection_clf(prostredi);
            st = con.createStatement();
            rs = st.executeQuery("select \n"
                    + "g1.title target_status\n"
                    + ",g2.title curr_network_status\n"
                    + "from table_site_part a \n"
                    + ",table_hgbst_elm g1\n"
                    + ",table_hgbst_elm g2\n"
                    + "where a.x_site_part2status_su = g1.objid \n"
                    + "and nvl(a.x_site_part2network_status,a.x_site_part2status_su) = g2.objid \n"
                    + "and a.s_serial_no='" + MSISDN + "'");

            while (rs.next()) {
                MSISDN_target_status = rs.getString("target_status");
                MSISDN_curr_network_status = rs.getString("curr_network_status");
            }

//            Pokud se ze selectu vrátí více jak 0 řádků, pak MSISDN existuje v ODS
            if ("Active".equals(MSISDN_target_status) && "Active".equals(MSISDN_curr_network_status)) {
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
