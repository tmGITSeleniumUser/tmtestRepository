package ccm_auto_insert;

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

public class TelLinka_Postpaid_Trifid_Pridruzeni {

    static void proved_TelLinka_Postpaid_Trifid_Pridruzeni_skript(int CisloKPridruzeni, int testProstredi) {

        System.setProperty("webdriver.ie.driver", "C:/Users/oholik/Desktop/Selenium/selenium-java-2.45.0/IEDriverServer.exe");
        //InternetExplorerDriver IEDriver = new InternetExplorerDriver();

        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");

        FirefoxDriver driver = new FirefoxDriver(myprofile);

        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        PomocneFunkce odkazNaCCM = new PomocneFunkce();
        String odkaz = odkazNaCCM.nastavURLTestovacihoProstredi(testProstredi);
        driver.navigate().to(odkaz);
        driver.manage().window().maximize();

        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();

        driver.findElement(By.name("i_msisdn")).sendKeys(CisloKPridruzeni + "" + Keys.INSERT);  //vlož tel. číslo k přidružení

        driver.findElement(By.name("i_solus")).click();
        driver.findElement(By.name("i_pr_query")).click();

        Select droplistSP = new Select(driver.findElement(By.name("i_citizenship")));
        droplistSP.selectByVisibleText("ČR");

        Select droplistTS = new Select(driver.findElement(By.name("i_customer_type")));
        droplistTS.selectByVisibleText("Fyzická osoba");

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

        driver.findElement(By.name("i_zip")).sendKeys("48563" + Keys.INSERT);

        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/table/tbody/tr/td[2]/table/tbody/tr[39]/td/input[1]")).click(); //vyhledání

        driver.findElement(By.xpath("/html/body/a[9]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")).click(); //aktivace

        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[24]/td/a")).click();  //přidružení SIM

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));

        WebElement elem = driver.findElement(By.xpath("//input[@type='password']"));
        elem.sendKeys("2015");

        //driver.findElement(By.name("iPsw")).sendKeys("2015" + Keys.INSERT); //zadaní hesla
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/input")).click();  //ověřit   

        // záložka ZO kontakt
//        driver.findElement(By.id("but2")).click();
//
//        driver.findElement(By.id("CON_I_FIRST_NAME_FV")).sendKeys("Marek" + Keys.INSERT);             // Jméno                  
//        driver.findElement(By.id("CON_I_COMP_LAST_NAME_FV")).sendKeys("Syrový" + Keys.INSERT);        // Příjmení  
//        String rc;
//        driver.findElement(By.id("CON_I_BIRTH_NUMBER_FV")).sendKeys(rc = RcGenerator.generateRcForAge(19, 55) + "" + Keys.INSERT);    // Rodné číslo
////        driver.findElement(By.id("ADR_CNT_STREET_FV")).sendKeys("Pražská" + Keys.INSERT);           // Ulice         
////        driver.findElement(By.id("ADR_CNT_NUMBER_RED_FV")).sendKeys("156" + Keys.INSERT);           // Číslo popisné
////        driver.findElement(By.id("ADR_CNT_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // Město
////        driver.findElement(By.id("ADR_CNT_ZIP_FV")).sendKeys("48520" + Keys.INSERT);                // PSČ
//        driver.findElement(By.id("CON_I_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);              // Email
//        driver.findElement(By.id("CON_I_DOC1_NUMBER_FV")).sendKeys(nahodneCislo + "" + Keys.INSERT);   // Číslo dokumentu
//        driver.findElement(By.id("CON_I_VALID_DOC1_FV")).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu
//        driver.findElement(By.id("CON_I_PASSWORD_FV")).sendKeys("2015" + Keys.INSERT);              // Heslo
//
////        // záložka Účtování
////        driver.findElement(By.id("but3")).click();
////
////        driver.findElement(By.id("ADR_BIL_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
////        driver.findElement(By.id("ADR_BIL_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
////        driver.findElement(By.id("ADR_BIL_STREET_FV")).sendKeys("Hlavní" + Keys.INSERT);              // Ulice    
////        driver.findElement(By.id("ADR_BIL_NUMBER_RED_FV")).sendKeys("12" + Keys.INSERT);              // Číslo popisné    
////        driver.findElement(By.id("ADR_BIL_TOWN_FV")).sendKeys("Praha" + Keys.INSERT); driver.findElement(By.id("but2")).click();
//
//        driver.findElement(By.id("CON_I_FIRST_NAME_FV")).sendKeys("Marek" + Keys.INSERT);             // Jméno                  
//        driver.findElement(By.id("CON_I_COMP_LAST_NAME_FV")).sendKeys("Syrový" + Keys.INSERT);        // Příjmení  
//        String rc;
//        driver.findElement(By.id("CON_I_BIRTH_NUMBER_FV")).sendKeys(rc = RcGenerator.generateRcForAge(19, 55) + "" + Keys.INSERT);    // Rodné číslo
////        driver.findElement(By.id("ADR_CNT_STREET_FV")).sendKeys("Pražská" + Keys.INSERT);           // Ulice         
////        driver.findElement(By.id("ADR_CNT_NUMBER_RED_FV")).sendKeys("156" + Keys.INSERT);           // Číslo popisné
////        driver.findElement(By.id("ADR_CNT_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // Město
////        driver.findElement(By.id("ADR_CNT_ZIP_FV")).sendKeys("48520" + Keys.INSERT);                // PSČ
//        driver.findElement(By.id("CON_I_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);              // Email
//        driver.findElement(By.id("CON_I_DOC1_NUMBER_FV")).sendKeys(nahodneCislo + "" + Keys.INSERT);   // Číslo dokumentu
//        driver.findElement(By.id("CON_I_VALID_DOC1_FV")).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu
//        driver.findElement(By.id("CON_I_PASSWORD_FV")).sendKeys("2015" + Keys.INSERT);              // Heslo
//
////        // záložka Účtování
////        driver.findElement(By.id("but3")).click();
////
////        driver.findElement(By.id("ADR_BIL_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);                      // Město    
////        driver.findElement(By.id("ADR_BIL_ZIP_FV")).sendKeys("48963" + Keys.INSERT);                  // PSČ    
////
////        Select droplistOS = new Select(driver.findElement(By.id("ADR_BIL_QCUSSAL_ID_FV")));
////        droplistOS.selectByVisibleText("Vážený zákazníku");
////
        // záložka Služby
        driver.findElement(By.id("but4")).click();

        // driver.findElement(By.id("SER_VPN_FV")).click();
//
        driver.findElement(By.id("ADR_FIX_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id("ADR_FIX_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id("ADR_FIX_STREET_FV")).sendKeys("Hlavní" + Keys.INSERT);              // Ulice    
        driver.findElement(By.id("ADR_FIX_NUMBER_RED_FV")).sendKeys("12" + Keys.INSERT);              // Číslo popisné    
        driver.findElement(By.id("ADR_FIX_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id("ADR_FIX_ZIP_FV")).sendKeys("48963" + Keys.INSERT);                  // PSČ   
        driver.findElement(By.id("ADR_FIX_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);         // email   

        driver.findElement(By.id("REQ_SELLER_CODE_FV")).sendKeys("PGSA7.001.001" + Keys.INSERT);      // outlet

        Select droplistKraj = new Select(driver.findElement(By.id("ADR_FIX_REGION_FV")));
        droplistKraj.selectByVisibleText("Hlavní město Praha");

        driver.findElement(By.id("SER_SIGNATURE_DATE_FV")).sendKeys(dnesniDatum + "" + Keys.INSERT);   //datum podpisu objednávky
        driver.findElement(By.id("but7")).click(); // Kontrola

    }

}
