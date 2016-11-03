/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Petr
 */
public class HTML_identifier_library {

    static String id_aktivace;
    private static Component frame;

    static String id_aktivace_cui(String identifikator) {
        /*Webové prvky a jejich identifikace*/

        /*CUI*/
        String i_ic = "i_ic";
        String i_val = "i_val";
        String i_msisdn = "i_msisdn";
        String SUB_QPROAT_QPROAT_ID_FV = "SUB_QPROAT_QPROAT_ID_FV";
        String REQ_PIN_FV = "REQ_PIN_FV";
        String SER_INSTALL_FV = "SER_INSTALL_FV";
        String SUB_MIN_COMMITMENT_CODE_FV = "SUB_MIN_COMMITMENT_CODE_FV";
        String SER_OSIP_FV = "SER_OSIP_FV";
        String SUB_PHONE_SAPCODE_FV = "SUB_PHONE_SAPCODE_FV";
        String SUB_IMEI_FV = "SUB_IMEI_FV";
        String SCP_INSTALL_DATE_FV = "SCP_INSTALL_DATE_FV";
        String CON_I_MSISDN1_FV = "CON_I_MSISDN1_FV";
        String i_solus = "i_solus";
        String i_pr_query = "i_pr_query";
        String i_citizenship = "i_citizenship";
        String i_customer_type = "i_customer_type";
        String i_sim_voice = "i_sim_voice";
        String i_sim_fix_voice = "i_sim_fix_voice";
        String i_sim_data = "i_sim_data";
        String i_sim_fix_data = "i_sim_fix_data";
        String i_sim_roam = "i_sim_roam";
        String i_payment_type = "i_payment_type";
        String i_contr_duration = "i_contr_duration";
        String i_mmp = "i_mmp";
        String i_zip = "i_zip";
        /*Lessana*/
        String i_tmprogram_id = "i_tmprogram_id";
        String CHECK = "CHECK";

        /*Lessana end*/
        String vyhledej = "/html/body/table[2]/tbody/tr/td/form/table/tbody/tr/td[2]/table/tbody/tr[39]/td/input[1]";
        String aktivace = "/html/body/table[3]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]";
        String aktivace_telefonni_linky_novy_zakaznik = "/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[18]/td/a";
        String aktivace_telefonni_linky_pro_obchodniky_novy_zakaznik = "/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[19]/td/a"; // Dodelat
        String aktivace_novy_zakaznik_gsm = "/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[3]/td/a";
        String aktivace_nova_faktura_gsm = "/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[3]/td/a";
        String fix = "/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[14]/td/a";
        String aktivace_gsm_pridruzeni = "/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[5]/td/a";
        String aktivace_autopark_asc = "/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[8]/td/a";

        /*CUI end*/
        String ADR_CNR_STREET_FV = "ADR_CNR_STREET_FV";
        String ADR_CNR_NUMBER_RED_FV = "ADR_CNR_NUMBER_RED_FV";
        String ADR_CNR_TOWN_FV = "ADR_CNR_TOWN_FV";
        String ADR_CNR_ZIP_FV = "ADR_CNR_ZIP_FV";
        String but2 = "but2";

        String CON_I_FIRST_NAME_FV = "CON_I_FIRST_NAME_FV";
        String CON_I_COMP_LAST_NAME_FV = "CON_I_COMP_LAST_NAME_FV";
        String CON_I_BIRTH_NUMBER_FV = "CON_I_BIRTH_NUMBER_FV";
        String CON_I_EMAIL_FV = "CON_I_EMAIL_FV";
        String CON_I_DOC1_NUMBER_FV = "CON_I_DOC1_NUMBER_FV";
        String CON_I_VALID_DOC1_FV = "CON_I_VALID_DOC1_FV";
        String CON_I_PASSWORD_FV = "CON_I_PASSWORD_FV";

        String ADR_CNT_STREET_FV = "ADR_CNT_STREET_FV";
        String ADR_CNT_NUMBER_RED_FV = "ADR_CNT_NUMBER_RED_FV";
        String ADR_CNT_TOWN_FV = "ADR_CNT_TOWN_FV";
        String ADR_CNT_ZIP_FV = "ADR_CNT_ZIP_FV";

        String ITEM_VALUE = "ITEM_VALUE";

        String but3 = "but3";
        String ADR_BIL_FIRST_NAME_FV = "ADR_BIL_FIRST_NAME_FV";
        String ADR_BIL_COMP_LAST_NAME_FV = "ADR_BIL_COMP_LAST_NAME_FV";
        String ADR_BIL_STREET_FV = "ADR_BIL_STREET_FV";
        String ADR_BIL_NUMBER_RED_FV = "ADR_BIL_NUMBER_RED_FV";
        String ADR_BIL_TOWN_FV = "ADR_BIL_TOWN_FV";
        String ADR_BIL_ZIP_FV = "ADR_BIL_ZIP_FV";
        String ADR_BIL_QCUSSAL_ID_FV = "ADR_BIL_QCUSSAL_ID_FV";
        String SER_INVOICE_FORM_FV = "SER_INVOICE_FORM_FV";

        String but4 = "but4";

        String SER_VPN_FV = "SER_VPN_FV";
        String ADR_FIX_FIRST_NAME_FV = "ADR_FIX_FIRST_NAME_FV";
        String ADR_FIX_COMP_LAST_NAME_FV = "ADR_FIX_COMP_LAST_NAME_FV";
        String ADR_FIX_STREET_FV = "ADR_FIX_STREET_FV";
        String ADR_FIX_NUMBER_RED_FV = "ADR_FIX_NUMBER_RED_FV";
        String ADR_FIX_TOWN_FV = "ADR_FIX_TOWN_FV";
        String ADR_FIX_ZIP_FV = "ADR_FIX_ZIP_FV";
        String REQ_SELLER_CODE_FV = "REQ_SELLER_CODE_FV";
        String ADR_FIX_REGION_FV = "ADR_FIX_REGION_FV";
        String SER_SIGNATURE_DATE_FV = "SER_SIGNATURE_DATE_FV";
        String ADR_DEL_FIRST_NAME_FV = "ADR_DEL_FIRST_NAME_FV";
        String ADR_DEL_COMP_LAST_NAME_FV = "ADR_DEL_COMP_LAST_NAME_FV";
        String ADR_DEL_STREET_FV = "ADR_DEL_STREET_FV";
        String ADR_DEL_NUMBER_RED_FV = "ADR_DEL_NUMBER_RED_FV";
        String ADR_DEL_TOWN_FV = "ADR_DEL_TOWN_FV";
        String ADR_DEL_ZIP_FV = "ADR_DEL_ZIP_FV";
        String SCP_CF_INST_FIRST_NAME_FV = "SCP_CF_INST_FIRST_NAME_FV";
        String SCP_CF_INST_COMP_LAST_NAME_FV = "SCP_CF_INST_COMP_LAST_NAME_FV";
        String SCP_CF_NOTIFY_PHONE_FV = "SCP_CF_NOTIFY_PHONE_FV";
        String SCP_CF_NOTIFY_EMAIL_FV = "SCP_CF_NOTIFY_EMAIL_FV";

        String but7 = "but7";

        String AccessCardHref = "/html/body/form/table[8]/tbody/tr[14]/td[4]/span[2]/a";
        String id_kart = "/html/body/table/tbody/tr[2]/td/a[1]";

        /*Postpaid*/
        String i_rc = "i_rc";
        String CON_P_FIRST_NAME_FV = "CON_P_FIRST_NAME_FV";
        String CON_P_COMP_LAST_NAME_FV = "CON_P_COMP_LAST_NAME_FV";
        String CON_P_EMAIL_FV = "CON_P_EMAIL_FV";
        String CON_P_MSISDN1_FV = "CON_P_MSISDN1_FV";
        String CON_P_DOC1_NUMBER_FV = "CON_P_DOC1_NUMBER_FV";
        String CON_P_VALID_DOC1_FV = "CON_P_VALID_DOC1_FV";
        String CON_P_PASSWORD_FV = "CON_P_PASSWORD_FV";
        String SUB_SIMTYPE_FV = "SUB_SIMTYPE_FV";
        String SUB_QPROTAR_QPROTAR_ID_FV = "SUB_QPROTAR_QPROTAR_ID_FV";
        /*Postpaid konec*/

        /* Solus */
        String SER_SOLUS_FV = "SER_SOLUS_FV";
        String SER_SOUHLAS_CEE_FV = "SER_SOUHLAS_CEE_FV";

        /*
         Solus end
         */
        /*Password*/
        String Password = "OVER";
        String Input_passoword = "//input[@type='password']";
        /*Password end*/
        /*Konec webových prvků*/

        /*Stary VOIP*/
        String SUB_ICCID_FV = "SUB_ICCID_FV";

        /*Konec VOIP*/
        /*Hodnoty webových prvků pro vyplnění.*/
        String type_simka = "Universal SIM";
        /*Konec hodnot*/

        switch (identifikator) {
            /*Starý Voip*/
            case "SUB_ICCID_FV": {
                return SUB_ICCID_FV;
            }
            /*Konec VOIP*/
            /*Password*/
            case "Password": {
                return Password;
            }
            case "Input_passoword": {
                return Input_passoword;
            }
            /*Password end*/
            /* Solus */
            case "SER_SOLUS_FV": {
                return SER_SOLUS_FV;
            }
            case "SER_SOUHLAS_CEE_FV": {
                return SER_SOUHLAS_CEE_FV;
            }
            /* Solus end */

            /*Webove prvky volba*/
            /*Postpaid*/
            case "SUB_QPROTAR_QPROTAR_ID_FV": {
                return SUB_QPROTAR_QPROTAR_ID_FV;
            }
            case "SUB_SIMTYPE_FV": {
                return SUB_SIMTYPE_FV;
            }
            case "CON_P_DOC1_NUMBER_FV": {
                return CON_P_DOC1_NUMBER_FV;
            }
            case "CON_P_VALID_DOC1_FV": {
                return CON_P_VALID_DOC1_FV;
            }
            case "CON_P_PASSWORD_FV": {
                return CON_P_PASSWORD_FV;
            }
            case "CON_P_MSISDN1_FV": {
                return CON_P_MSISDN1_FV;
            }
            case "CON_P_EMAIL_FV": {
                return CON_P_EMAIL_FV;
            }
            case "CON_P_FIRST_NAME_FV": {
                return CON_P_FIRST_NAME_FV;
            }
            case "aktivace_novy_zakaznik_gsm": {
                return aktivace_novy_zakaznik_gsm;
            }
            case "i_rc": {
                return i_rc;
            }
            /*Konec postpaid*/

            /*Lessana*/
            case "i_tmprogram_id": {
                return i_tmprogram_id;
            }
            case "CHECK": {
                return CHECK;
            }

            /*Lessana end*/
            case "ITEM_VALUE": {
                return ITEM_VALUE;
            }

            case "i_msisdn": {
                return i_msisdn;
            }
            case "fix": {
                return fix;
            }
            case "SUB_QPROAT_QPROAT_ID_FV": {
                return SUB_QPROAT_QPROAT_ID_FV;
            }
            case "REQ_PIN_FV": {
                return REQ_PIN_FV;
            }
            case "aktivace_telefonni_linky_pro_obchodniky_novy_zakaznik": {
                return aktivace_telefonni_linky_pro_obchodniky_novy_zakaznik;
            }
            case "aktivace_gsm_pridruzeni": {
                return aktivace_gsm_pridruzeni;
            }
            case "CON_I_MSISDN1_FV": {
                return CON_I_MSISDN1_FV;
            }
            case "SUB_MIN_COMMITMENT_CODE_FV": {
                return SUB_MIN_COMMITMENT_CODE_FV;
            }
            case "SER_INSTALL_FV": {
                return SER_INSTALL_FV;
            }
            case "SER_OSIP_FV": {
                return SER_OSIP_FV;
            }
            case "SUB_PHONE_SAPCODE_FV": {
                return SUB_PHONE_SAPCODE_FV;
            }
            case "SUB_IMEI_FV": {
                return SUB_IMEI_FV;
            }
            case "SCP_INSTALL_DATE_FV": {
                return SCP_INSTALL_DATE_FV;
            }
            case "AccessCardHref": {
                return AccessCardHref;
            }
            case "id_kart": {
                return id_kart;
            }
            case "ico": {
                return i_ic;
            }
            case "CON_I_PASSWORD_FV": {
                return CON_I_PASSWORD_FV;
            }
            case "i_solus": {
                return i_solus;
            }
            case "i_pr_query": {
                return i_pr_query;
            }
            case "i_citizenship": {
                return i_citizenship;
            }
            case "i_customer_type": {
                return i_customer_type;
            }
            case "i_sim_voice": {
                return i_sim_voice;
            }
            case "i_sim_fix_voice": {
                return i_sim_fix_voice;
            }
            case "i_sim_data": {
                return i_sim_data;
            }
            case "i_sim_fix_data": {
                return i_sim_fix_data;
            }
            case "i_sim_roam": {
                return i_sim_roam;
            }
            case "i_payment_type": {
                return i_payment_type;
            }
            case "i_contr_duration": {
                return i_contr_duration;
            }
            case "i_mmp": {
                return i_mmp;
            }
            case "i_zip": {
                return i_zip;
            }
            case "vyhledej": {
                return vyhledej;
            }
            case "aktivace": {
                return aktivace;
            }
            case "aktivace_telefonni_linky_novy_zakaznik": {
                return aktivace_telefonni_linky_novy_zakaznik;
            }
            case "aktivace_autopark_asc": {
                return aktivace_autopark_asc;
            }
            case "aktivace_gsm_nova_faktura": {
                return aktivace_nova_faktura_gsm;
            }
            case "CON_P_COMP_LAST_NAME_FV": {
                return CON_P_COMP_LAST_NAME_FV;
            }
            case "ADR_CNR_STREET_FV": {
                return ADR_CNR_STREET_FV;
            }
            case "ADR_CNR_NUMBER_RED_FV": {
                return ADR_CNR_NUMBER_RED_FV;
            }
            case "ADR_CNR_TOWN_FV": {
                return ADR_CNR_TOWN_FV;
            }
            case "ADR_CNR_ZIP_FV": {
                return ADR_CNR_ZIP_FV;
            }
            case "but2": {
                return but2;
            }
            case "CON_I_FIRST_NAME_FV": {
                return CON_I_FIRST_NAME_FV;
            }
            case "CON_I_COMP_LAST_NAME_FV": {
                return CON_I_COMP_LAST_NAME_FV;
            }
            case "CON_I_BIRTH_NUMBER_FV": {
                return CON_I_BIRTH_NUMBER_FV;
            }
            case "ADR_CNT_STREET_FV": {
                return ADR_CNT_STREET_FV;
            }
            case "ADR_CNT_NUMBER_RED_FV": {
                return ADR_CNT_NUMBER_RED_FV;
            }
            case "ADR_CNT_TOWN_FV": {
                return ADR_CNT_TOWN_FV;
            }
            case "ADR_CNT_ZIP_FV": {
                return ADR_CNT_ZIP_FV;
            }
            case "CON_I_EMAIL_FV": {
                return CON_I_EMAIL_FV;
            }
            case "CON_I_DOC1_NUMBER_FV": {
                return CON_I_DOC1_NUMBER_FV;
            }
            case "CON_I_VALID_DOC1_FV": {
                return CON_I_VALID_DOC1_FV;
            }
            case "but3": {
                return but3;
            }
            case "ADR_BIL_FIRST_NAME_FV": {
                return ADR_BIL_FIRST_NAME_FV;
            }
            case "ADR_BIL_COMP_LAST_NAME_FV": {
                return ADR_BIL_COMP_LAST_NAME_FV;
            }
            case "ADR_BIL_STREET_FV": {
                return ADR_BIL_STREET_FV;
            }
            case "ADR_BIL_NUMBER_RED_FV": {
                return ADR_BIL_NUMBER_RED_FV;
            }
            case "ADR_BIL_TOWN_FV": {
                return ADR_BIL_TOWN_FV;
            }
            case "ADR_BIL_ZIP_FV": {
                return ADR_BIL_ZIP_FV;
            }
            case "ADR_BIL_QCUSSAL_ID_FV": {
                return ADR_BIL_QCUSSAL_ID_FV;
            }
            case "but4": {
                return but4;
            }
            case "SER_VPN_FV": {
                return SER_VPN_FV;
            }
            case "ADR_FIX_FIRST_NAME_FV": {
                return ADR_FIX_FIRST_NAME_FV;
            }
            case "ADR_FIX_COMP_LAST_NAME_FV": {
                return ADR_FIX_COMP_LAST_NAME_FV;
            }
            case "ADR_FIX_STREET_FV": {
                return ADR_FIX_STREET_FV;
            }
            case "ADR_FIX_NUMBER_RED_FV": {
                return ADR_FIX_NUMBER_RED_FV;
            }
            case "ADR_FIX_TOWN_FV": {
                return ADR_FIX_TOWN_FV;
            }
            case "ADR_FIX_ZIP_FV": {
                return ADR_FIX_ZIP_FV;
            }
            case "REQ_SELLER_CODE_FV": {
                return REQ_SELLER_CODE_FV;
            }
            case "ADR_FIX_REGION_FV": {
                return ADR_FIX_REGION_FV;
            }
            case "ADR_DEL_FIRST_NAME_FV": {
                return ADR_DEL_FIRST_NAME_FV;
            }

            case "ADR_DEL_COMP_LAST_NAME_FV": {
                return ADR_DEL_COMP_LAST_NAME_FV;
            }

            case "SER_SIGNATURE_DATE_FV": {
                return SER_SIGNATURE_DATE_FV;
            }

            case "ADR_DEL_STREET_FV": {
                return ADR_DEL_STREET_FV;
            }

            case "ADR_DEL_NUMBER_RED_FV": {
                return ADR_DEL_NUMBER_RED_FV;
            }

            case "ADR_DEL_TOWN_FV": {
                return ADR_DEL_TOWN_FV;
            }

            case "ADR_DEL_ZIP_FV": {
                return ADR_DEL_ZIP_FV;
            }

            case "SCP_CF_INST_FIRST_NAME_FV": {
                return SCP_CF_INST_FIRST_NAME_FV;
            }

            case "SCP_CF_INST_COMP_LAST_NAME_FV": {
                return SCP_CF_INST_COMP_LAST_NAME_FV;
            }

            case "SCP_CF_NOTIFY_PHONE_FV": {
                return SCP_CF_NOTIFY_PHONE_FV;
            }

            case "SCP_CF_NOTIFY_EMAIL_FV": {
                return SCP_CF_NOTIFY_EMAIL_FV;
            }

            case "but7": {
                return but7;
            }
            case "i_val": {
                return i_val;
            }
               case "SER_INVOICE_FORM_FV": {
                return SER_INVOICE_FORM_FV;
            }
            

            /*Konec webových prvků*/
            /*Hodnoty webových prvků*/
            case "type_simka": {
                return type_simka;
            }
            /*Konec hodnot*/
            default: {
                JOptionPane.showMessageDialog(frame, "Nenašel jsem prvek." + identifikator);
                return "";
            }

        }
    }
}
