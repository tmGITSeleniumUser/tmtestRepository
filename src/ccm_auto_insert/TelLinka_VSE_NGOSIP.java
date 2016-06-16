package ccm_auto_insert;

import generatorRC.RcGenerator;
import java.sql.SQLException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelLinka_VSE_NGOSIP {

    static void telLinka(int testProstredi) throws SQLException {

        System.setProperty("webdriver.ie.driver", "C:/Users/oholik/Desktop/Selenium/selenium-java-2.45.0/IEDriverServer.exe");
        //InternetExplorerDriver IEDriver = new InternetExplorerDriver();

        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        FirefoxDriver driver = new FirefoxDriver(myprofile);

        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);

        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();
        String datumInstalace = datum.vratDatumProInstalaci();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        PomocneFunkce odkazNaCCM = new PomocneFunkce();
        String odkaz = odkazNaCCM.nastavURLTestovacihoProstredi(testProstredi);
        driver.navigate().to(odkaz);
        driver.manage().window().maximize();

        //driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("ico"))).sendKeys(ICO + "" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("ico"))).sendKeys(SQL_selects.ICOdatabase(dbConnection.dbConnection_dwh(testProstredi), testProstredi) + "" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_solus"))).click();
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_pr_query"))).click();

        Select droplistSP = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_citizenship"))));
        droplistSP.selectByVisibleText("ČR");

        Select droplistTS = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_customer_type"))));
        droplistTS.selectByVisibleText("Právnická osoba");

        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_voice"))).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_fix_voice"))).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_data"))).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_fix_data"))).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_roam"))).sendKeys("1" + Keys.INSERT);

        Select droplistPM = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_payment_type"))));
        droplistPM.selectByVisibleText("Cash");
        Select droplistDK = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_contr_duration"))));
        droplistDK.selectByVisibleText("24 měsíců");

        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_mmp"))).sendKeys("20000" + Keys.INSERT);

        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_zip"))).sendKeys("48563" + Keys.INSERT);

        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("vyhledej"))).click();

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace"))));
        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace"))).click();

        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace_telefonni_linky_novy_zakaznik"))));
        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace_telefonni_linky_novy_zakaznik"))).click();

        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_COMP_LAST_NAME_FV"))));

        // záložka Zákazník
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_COMP_LAST_NAME_FV"))).sendKeys("Trifid_sro" + Keys.INSERT);  // obchodní název
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_STREET_FV"))).sendKeys("Hlavní" + Keys.INSERT);            // Ulice              
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_NUMBER_RED_FV"))).sendKeys("48" + Keys.INSERT);            // číslo popisné
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_TOWN_FV"))).sendKeys("Praha" + Keys.INSERT);               // město
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_ZIP_FV"))).sendKeys("47850" + Keys.INSERT);                // PSČ

        // záložka ZO kontakt
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("but2"))).click();

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_FIRST_NAME_FV"))).sendKeys("Jan" + Keys.INSERT);             // Jméno                  
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_COMP_LAST_NAME_FV"))).sendKeys("Nový" + Keys.INSERT);        // Příjmení  
        String rc;
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_BIRTH_NUMBER_FV"))).sendKeys(rc = RcGenerator.generateRcForAge(19, 55) + "" + Keys.INSERT);    // Rodné číslo
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNT_STREET_FV"))).sendKeys("Pražská" + Keys.INSERT);           // Ulice         
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNT_NUMBER_RED_FV"))).sendKeys("156" + Keys.INSERT);           // Číslo popisné
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNT_TOWN_FV"))).sendKeys("Praha" + Keys.INSERT);               // Město
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNT_ZIP_FV"))).sendKeys("48520" + Keys.INSERT);                // PSČ
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_EMAIL_FV"))).sendKeys("test@test.cz" + Keys.INSERT);         // Email
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_MSISDN1_FV"))).sendKeys("789456321" + Keys.INSERT);                                                   // Kontaktní telefon
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_DOC1_NUMBER_FV"))).sendKeys(nahodneCislo + "" + Keys.INSERT);            // Číslo dokumentu
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_VALID_DOC1_FV"))).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_PASSWORD_FV"))).sendKeys("2015" + Keys.INSERT);              // Heslo

        // záložka Účtování
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("but3"))).click();

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_BIL_FIRST_NAME_FV"))).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_BIL_COMP_LAST_NAME_FV"))).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_BIL_STREET_FV"))).sendKeys("Hlavní" + Keys.INSERT);              // Ulice    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_BIL_NUMBER_RED_FV"))).sendKeys("12" + Keys.INSERT);              // Číslo popisné    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_BIL_TOWN_FV"))).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_BIL_ZIP_FV"))).sendKeys("48963" + Keys.INSERT);                  // PSČ    

        Select droplistOS = new Select(driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_BIL_QCUSSAL_ID_FV"))));
        droplistOS.selectByVisibleText("Vážený zákazníku");

        // záložka Služby
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("but4"))).click();

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SER_VPN_FV"))).click();

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_FIX_FIRST_NAME_FV"))).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_FIX_COMP_LAST_NAME_FV"))).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_FIX_STREET_FV"))).sendKeys("Hlavní" + Keys.INSERT);              // Ulice    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_FIX_NUMBER_RED_FV"))).sendKeys("12" + Keys.INSERT);              // Číslo popisné    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_FIX_TOWN_FV"))).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_FIX_ZIP_FV"))).sendKeys("48963" + Keys.INSERT);                  // PSČ   

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("REQ_SELLER_CODE_FV"))).sendKeys("PGSA7.001.001" + Keys.INSERT);      // outlet

        Select droplistKraj = new Select(driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_FIX_REGION_FV"))));
        droplistKraj.selectByVisibleText("Hlavní město Praha");

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SER_SIGNATURE_DATE_FV"))).sendKeys(dnesniDatum + "" + Keys.INSERT);
        Select droplistInstalce = new Select(driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SER_INSTALL_FV"))));
        droplistInstalce.selectByVisibleText("Instalace");

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SER_OSIP_FV"))).click();  //NGOSIP checkbox

        Select droplistPlneni = new Select(driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SUB_MIN_COMMITMENT_CODE_FV")))); // Minimalni plneni
        droplistPlneni.selectByVisibleText("CCM - MMP 250");

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SUB_PHONE_SAPCODE_FV"))).sendKeys("000000000000800840 - IP telefon WELL-Yealink SIP-T20" + Keys.INSERT); //HW

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SUB_IMEI_FV"))).sendKeys("000000000000000" + Keys.INSERT); //IMSI
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SCP_INSTALL_DATE_FV"))).sendKeys(datumInstalace + "" + Keys.INSERT); // Preferované datum instalace

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("but7"))).click(); // Kontrola

    }

}
