package ccm_auto_insert;

import static ccm_auto_insert.SQL_selects.VerifiedRCDdatabase;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GSM_LE_Pridruzeni_s_BA extends JFrame {

    static void proved_GSM_LE_pridruzeni_skript(int testProstredi, int ICO) throws SQLException {

        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        FirefoxDriver driver = new FirefoxDriver(myprofile);
        String rc;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        PomocneFunkce odkazNaCCM = new PomocneFunkce();
        String odkaz = odkazNaCCM.nastavURLTestovacihoProstredi(testProstredi);
        driver.navigate().to(odkaz);
        driver.manage().window().maximize();

        Datumy datum = new Datumy();
        Random rand = new Random();
        int nahodneCislo_Dokument = rand.nextInt(1000000000);
        int nahodneCislo_Email = rand.nextInt(100000);
        int nahodneCislo_TelKontakt = 1000 + rand.nextInt(9000);

        String dnesniDatum = datum.vratAktualniDatum();

        driver.findElement(By.name("i_ic")).sendKeys("0" + ICO + "" + Keys.INSERT);
//            driver.findElement(By.name("i_ic")).sendKeys(ICO + "" + Keys.INSERT);
//            driver.findElement(By.name("i_solus")).click();
        driver.findElement(By.name("i_pr_query")).click();
        Select droplistSP = new Select(driver.findElement(By.name("i_citizenship")));
        droplistSP.selectByVisibleText("ČR");
        Select droplistTS = new Select(driver.findElement(By.name("i_customer_type")));
        droplistTS.selectByVisibleText("Právnická osoba");
        driver.findElement(By.name("i_sim_voice")).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name("i_sim_fix_voice")).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name("i_sim_data")).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name("i_sim_fix_data")).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name("i_sim_roam")).sendKeys("1" + Keys.INSERT);
        Select droplistPM = new Select(driver.findElement(By.name("i_payment_type")));
        droplistPM.selectByVisibleText("Cash");
        Select droplistDK = new Select(driver.findElement(By.name("i_contr_duration")));
        droplistDK.selectByVisibleText("24 měsíců");
        driver.findElement(By.name("i_mmp")).sendKeys("20000" + Keys.INSERT);
        driver.findElement(By.name("i_zip")).sendKeys("14000" + Keys.INSERT);
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/table/tbody/tr/td[2]/table/tbody/tr[39]/td/input[1]")).click(); //vyhledání

        WebElement button_activation = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/a[11]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")));
        driver.findElement(By.xpath("/html/body/a[11]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")).click(); // Aktivace
//        WebElement button_new_customer = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[5]/td/a")));
//        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[5]/td/a")).click();  // Aktivace běžná - Aktivace SIM klíčového zákazníka

        driver.findElement(By.partialLinkText("Aktivace běžná - Aktivace SIM klíčového zákazníka")).click();

        if (PomocneFunkce.existsElement(driver, "/html/body/center/form/input[6]")) {
            WebElement button_siebel = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/center/form/input[6]")));
            driver.findElement(By.xpath("/html/body/center/form/input[6]")).click(); // Vyber ze Sieblu a zruseni hlasky

        }

        WebElement button_town = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("ADR_CNR_TOWN_FV")));
        // záložka Zákazník
        //driver.findElement(By.id("CON_P_COMP_LAST_NAME_FV")).sendKeys("GSM_sro_" + ICO + Keys.INSERT);  // obchodní název
//            driver.findElement(By.id("ADR_CNR_STREET_FV")).sendKeys("Na Pankráci" + Keys.INSERT);            // Ulice              
//            driver.findElement(By.id("ADR_CNR_NUMBER_RED_FV")).sendKeys("86" + Keys.INSERT);            // číslo popisné
//            driver.findElement(By.id("ADR_CNR_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // město
//            driver.findElement(By.id("ADR_CNR_ZIP_FV")).sendKeys("14000" + Keys.INSERT);                // PSČ

//            driver.findElement(By.id("but7")).click(); // Kontrola
        // záložka ZO kontakt
        driver.findElement(By.id("but2")).click();

        driver.findElement(By.id("CON_I_FIRST_NAME_FV")).sendKeys("Mirek" + Keys.INSERT);             // Jméno                  
        driver.findElement(By.id("CON_I_COMP_LAST_NAME_FV")).sendKeys("LE_ZOočkový" + Keys.INSERT);        // Příjmení  

        driver.findElement(By.id("CON_I_BIRTH_NUMBER_FV")).sendKeys(rc = VerifiedRCDdatabase(dbConnection.dbConnection_dwh(testProstredi), testProstredi) + "" + Keys.INSERT);    // Rodné číslo
//            driver.findElement(By.id("ADR_CNT_STREET_FV")).sendKeys("Na Pankráci" + Keys.INSERT);           // Ulice         
//            driver.findElement(By.id("ADR_CNT_NUMBER_RED_FV")).sendKeys("86" + Keys.INSERT);           // Číslo popisné
//            driver.findElement(By.id("ADR_CNT_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // Město
//            driver.findElement(By.id("ADR_CNT_ZIP_FV")).sendKeys("14000" + Keys.INSERT);                // PSČ
        driver.findElement(By.id("CON_I_EMAIL_FV")).sendKeys("test" + nahodneCislo_Email + "@gmail.cz" + Keys.INSERT);         // Email
        driver.findElement(By.id("CON_I_MSISDN1_FV")).sendKeys("70260" + nahodneCislo_TelKontakt + Keys.INSERT);        // telefonní kontakt 
        driver.findElement(By.id("CON_I_DOC1_NUMBER_FV")).sendKeys(nahodneCislo_Dokument + "" + Keys.INSERT);            // Číslo dokumentu
        driver.findElement(By.id("CON_I_VALID_DOC1_FV")).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu
        driver.findElement(By.id("CON_I_PASSWORD_FV")).sendKeys("2017" + Keys.INSERT);              // Heslo

        // záložka Účtování
        driver.findElement(By.id("but3")).click();

//            driver.findElement(By.id("ADR_BIL_FIRST_NAME_FV")).sendKeys("Petr" + Keys.INSERT);             // Jméno    
//            driver.findElement(By.id("ADR_BIL_COMP_LAST_NAME_FV")).sendKeys("BAčkový" + Keys.INSERT);       // Příjmení    
//            driver.findElement(By.id("ADR_BIL_STREET_FV")).sendKeys("Na Pankráci" + Keys.INSERT);              // Ulice    
//            driver.findElement(By.id("ADR_BIL_NUMBER_RED_FV")).sendKeys("86" + Keys.INSERT);              // Číslo popisné    
//            driver.findElement(By.id("ADR_BIL_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
//            driver.findElement(By.id("ADR_BIL_ZIP_FV")).sendKeys("14000" + Keys.INSERT);                  // PSČ    
//            Select droplistOS = new Select(driver.findElement(By.id("ADR_BIL_QCUSSAL_ID_FV")));
//            droplistOS.selectByVisibleText("Vážený zákazníku");
        // záložka Služby
        driver.findElement(By.id("but4")).click();

//            driver.findElement(By.id("SUB_ICCID_FV")).clear();
//            driver.findElement(By.id("SUB_ICCID_FV")).sendKeys(SQL_selects.ICCIDdatabase(dbConnection.dbConnection_qap(testProstredi), testProstredi) + Keys.INSERT);
        driver.findElement(By.id("SER_VPN_FV")).click();
//
//        driver.findElement(By.id("ADR_FIX_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
//        driver.findElement(By.id("ADR_FIX_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
//        driver.findElement(By.id("ADR_FIX_STREET_FV")).sendKeys("Hlavní" + Keys.INSERT);              // Ulice    
//        driver.findElement(By.id("ADR_FIX_NUMBER_RED_FV")).sendKeys("12" + Keys.INSERT);              // Číslo popisné    
//        driver.findElement(By.id("ADR_FIX_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
//        driver.findElement(By.id("ADR_FIX_ZIP_FV")).sendKeys("48963" + Keys.INSERT);                  // PSČ   
//            driver.findElement(By.id("REQ_SELLER_CODE_FV")).sendKeys("PGSA7.001.001" + Keys.INSERT);      // outlet

        Select droplistSIMkarta = new Select(driver.findElement(By.id("SUB_SIMTYPE_FV")));                  // vybrání SIM karty
        droplistSIMkarta.selectByVisibleText("Universal SIM");
        Select droplistTarif = new Select(driver.findElement(By.id("SUB_QPROTAR_QPROTAR_ID_FV")));                  // vybrání tarifu karty
        droplistTarif.selectByVisibleText("Profi na míru 5");

        //driver.findElement(By.id("SER_VPN_FV")).click();   //vypnout privátní podnikovou síť
        driver.findElement(By.xpath("/html/body/form/table[7]/tbody/tr[33]/td[4]/input[1]")).sendKeys("2017" + Keys.INSERT);  //vyplnit heslo      


//        Select droplistKraj = new Select(driver.findElement(By.id("ADR_FIX_REGION_FV")));
//        droplistKraj.selectByVisibleText("Hlavní město Praha");
        driver.findElement(By.id("SER_SIGNATURE_DATE_FV")).sendKeys(dnesniDatum + "" + Keys.INSERT);   //datum podpisu objednávky

        driver.findElement(By.id("but7")).click(); // Kontrola

        WebElement button_zalozka_sluzby = (new WebDriverWait(driver, 10)) /*čekání na prvek*/
                .until(ExpectedConditions.presenceOfElementLocated(By.id("but4")));

        driver.findElement(By.id("but4")).click();
        /* Založka služby*/

 /*Toto řeší uložení MSISDN do souboru*/
        System.out.println(driver.findElement(By.id("SUB_MSISDN_FV_RO")).getAttribute("value"));

        OutputInputFile.writeMSISDN(driver.findElement(By.id("SUB_MSISDN_FV_RO")).getAttribute("value"), SQL_selects.IMSIDdatabase(dbConnection.dbConnection_qap(testProstredi), testProstredi, driver.findElement(By.id("SUB_ICCID_FV")).getAttribute("value")));
        driver.findElement(By.id("but6")).click();

    }

}
