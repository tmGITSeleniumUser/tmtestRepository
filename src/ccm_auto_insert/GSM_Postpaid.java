package ccm_auto_insert;

import generatorRC.RcGenerator;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GSM_Postpaid {

    static void proved_GSM_Postpaid_skript(int testProstredi) {

//        final String sUrl = "https://qdealers.cz.tmo/ap01/cui_web_search_entry.cui_startup?";
//        System.setProperty("webdriver.ie.driver", "C:\\Users\\oholik\\Documents\\My Games/IEDriverServer.exe");
//        InternetExplorerDriver driver = new InternetExplorerDriver();
//        driver.get(sUrl);
//        File file = new File("C:\\Users\\oholik\\Documents\\My Games\\IEDriverServer.exe");
//        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//        WebDriver driver = new InternetExplorerDriver();
        ///InternetExplorerDriver driver = new InternetExplorerDriver();
        //driver.get("https://qdealers.cz.tmo/ap01/cui_web_search_entry.cui_startup?");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        FirefoxDriver driver = new FirefoxDriver(myprofile);
   
        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);

        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        PomocneFunkce odkazNaCCM = new PomocneFunkce();
        String odkaz = odkazNaCCM.nastavURLTestovacihoProstredi(testProstredi);
        driver.navigate().to(odkaz);
        driver.manage().window().maximize();

        String rc = RcGenerator.generateRcForAge(20, 60, RcGenerator.Gender.MALE, RcGenerator.RcType.NO_MOD_11);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_rc"))).sendKeys(rc = RcGenerator.generateRcForAge(19, 55) + "" + Keys.INSERT);             // Rodné číslo  // Rodné číslo
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_solus"))).click();
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_pr_query"))).click();

        Select droplistSP = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_citizenship"))));
        droplistSP.selectByVisibleText("ČR");

        Select droplistTS = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_customer_type"))));
        droplistTS.selectByVisibleText("Fyzická osoba");

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

        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_zip"))).sendKeys("12800" + Keys.INSERT);

        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("vyhledej"))).click(); //vyhledání
        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace"))).click(); // aktivace
        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace_novy_zakaznik_gsm"))).click();  // aktivace nového zákazníka

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("REQ_SELLER_CODE_FV"))).sendKeys("PGSA7.001.001" + Keys.INSERT);                  // outlet  

        // záložka Zákazník
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_FIRST_NAME_FV"))).sendKeys("Jan" + Keys.INSERT);             //Jméno
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_COMP_LAST_NAME_FV"))).sendKeys("Bačka" + Keys.INSERT);  // Příjmení
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_STREET_FV"))).sendKeys("Hlavní" + Keys.INSERT);            // Ulice              
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_NUMBER_RED_FV"))).sendKeys("48" + Keys.INSERT);            // číslo popisné
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_TOWN_FV"))).sendKeys("Praha" + Keys.INSERT);               // město
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_ZIP_FV"))).sendKeys("47850" + Keys.INSERT);                // PSČ
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_EMAIL_FV"))).sendKeys("test@test.cz" + Keys.INSERT);         // Email
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_MSISDN1_FV"))).sendKeys("789456321" + Keys.INSERT);         // tel. číslo
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_DOC1_NUMBER_FV"))).sendKeys(nahodneCislo + "" + Keys.INSERT);    // Číslo dokumentu
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_VALID_DOC1_FV"))).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_PASSWORD_FV"))).sendKeys("2015" + Keys.INSERT);              // Heslo

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

        Select droplistKraj = new Select(driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SUB_SIMTYPE_FV"))));                  // vybrání SIM karty
        droplistKraj.selectByVisibleText(HTML_identifier_library.id_aktivace_cui("type_simka"));

        Select droplistTarif = new Select(driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SUB_QPROTAR_QPROTAR_ID_FV"))));                  // vybrání SIM karty
        droplistTarif.selectByVisibleText("S námi v sítích");

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SER_SIGNATURE_DATE_FV"))).sendKeys(dnesniDatum + "" + Keys.INSERT);   //datum podpisu objednávky

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("but7"))).click(); // Kontrola

    }

}
