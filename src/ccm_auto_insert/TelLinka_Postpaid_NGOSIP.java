package ccm_auto_insert;

import generatorRC.RcGenerator;
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

public class TelLinka_Postpaid_NGOSIP {

    static void proved_TelLinka_Postpaid_NGOSIP_skript(int testProstredi) {

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

        String rc = RcGenerator.generateRcForAge(20, 60, RcGenerator.Gender.MALE, RcGenerator.RcType.NO_MOD_11);
        driver.findElement(By.name("i_rc")).sendKeys(rc = RcGenerator.generateRcForAge(19, 55) + "" + Keys.INSERT);  // Rodné číslo
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

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/a[9]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")));
        driver.findElement(By.xpath("/html/body/a[9]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")).click();

        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[18]/td/a")));
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[18]/td/a")).click();

        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("CON_P_COMP_LAST_NAME_FV")));

        driver.findElement(By.id("REQ_SELLER_CODE_FV")).sendKeys("PGSA7.001.001" + Keys.INSERT);                  // outlet  

        // záložka Zákazník
        driver.findElement(By.id("CON_P_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             //Jméno
        driver.findElement(By.id("CON_P_COMP_LAST_NAME_FV")).sendKeys("Bačka" + Keys.INSERT);  // Příjmení
        driver.findElement(By.id("ADR_CNR_STREET_FV")).sendKeys("Hlavní" + Keys.INSERT);            // Ulice              
        driver.findElement(By.id("ADR_CNR_NUMBER_RED_FV")).sendKeys("48" + Keys.INSERT);            // číslo popisné
        driver.findElement(By.id("ADR_CNR_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // město
        driver.findElement(By.id("ADR_CNR_ZIP_FV")).sendKeys("47850" + Keys.INSERT);                // PSČ
        driver.findElement(By.id("CON_P_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);         // Email
        driver.findElement(By.id("CON_P_MSISDN1_FV")).sendKeys("789456321" + Keys.INSERT);         // tel. číslo
        driver.findElement(By.id("CON_P_DOC1_NUMBER_FV")).sendKeys(nahodneCislo + "" + Keys.INSERT);    // Číslo dokumentu
        driver.findElement(By.id("CON_P_VALID_DOC1_FV")).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu
        driver.findElement(By.id("CON_P_PASSWORD_FV")).sendKeys("2015" + Keys.INSERT);              // Heslo

        // záložka Účtování
        driver.findElement(By.id("but3")).click();

        driver.findElement(By.id("ADR_BIL_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id("ADR_BIL_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id("ADR_BIL_STREET_FV")).sendKeys("Hlavní" + Keys.INSERT);              // Ulice    
        driver.findElement(By.id("ADR_BIL_NUMBER_RED_FV")).sendKeys("12" + Keys.INSERT);              // Číslo popisné    
        driver.findElement(By.id("ADR_BIL_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id("ADR_BIL_ZIP_FV")).sendKeys("48963" + Keys.INSERT);                  // PSČ    

        Select droplistOS = new Select(driver.findElement(By.id("ADR_BIL_QCUSSAL_ID_FV")));
        droplistOS.selectByVisibleText("Vážený zákazníku");

        // záložka Služby
        driver.findElement(By.id("but4")).click();

        //driver.findElement(By.id("SER_VPN_FV")).click();
        Select droplistMinimalPlneni = new Select(driver.findElement(By.id("SUB_MIN_COMMITMENT_CODE_FV")));
        droplistMinimalPlneni.selectByVisibleText("CCM - MMP 250");
        
        driver.findElement(By.id("SUB_PHONE_SAPCODE_FV")).sendKeys("000000000000800840 - IP telefon WELL-Yealink SIP-T20" + Keys.INSERT); //HW

        driver.findElement(By.id("ADR_FIX_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id("ADR_FIX_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id("ADR_FIX_STREET_FV")).sendKeys("Hlavní" + Keys.INSERT);              // Ulice    
        driver.findElement(By.id("ADR_FIX_NUMBER_RED_FV")).sendKeys("12" + Keys.INSERT);              // Číslo popisné    
        driver.findElement(By.id("ADR_FIX_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id("ADR_FIX_ZIP_FV")).sendKeys("48963" + Keys.INSERT);                  // PSČ   
        driver.findElement(By.id("ADR_FIX_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);         // email

        driver.findElement(By.id("SER_SIGNATURE_DATE_FV")).sendKeys(dnesniDatum + "" + Keys.INSERT);   //datum podpisu objednávky

        Select droplistInstalce = new Select(driver.findElement(By.id("SER_INSTALL_FV")));
        droplistInstalce.selectByVisibleText("Instalace");

        Select droplistKraj = new Select(driver.findElement(By.id("ADR_FIX_REGION_FV")));
        droplistKraj.selectByVisibleText("Hlavní město Praha");

        //driver.findElement(By.id("SER_OSIP_FV")).click();

        

        driver.findElement(By.id("SUB_IMEI_FV")).sendKeys("000000000000000" + Keys.INSERT); //IMSI
        driver.findElement(By.id("SCP_INSTALL_DATE_FV")).sendKeys(datumInstalace + "" + Keys.INSERT); // Preferované datum instalace

        driver.findElement(By.id("but7")).click(); // Kontrola

    }

}
