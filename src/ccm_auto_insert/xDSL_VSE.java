/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import generatorRC.RcGenerator;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author oholik
 */
public class xDSL_VSE {
    
       static void proved_xDSL_VSE_skript(String ICO, int testProstredi) throws InterruptedException {
                //set the system property for Internet Explorer  
//        System.setProperty("webdriver.ie.driver", "Location of IE Driver");
        //System.setProperty("webdriver.ie.driver", "C:\\Users\\nikola\\Desktop\\T-mobile Testing\\IE DRIVER\\IEDriverServer.exe");
         System.setProperty("webdriver.ie.driver", "C:\\Webdriver\\IEDriverServer.exe");

//        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

        ieCapabilities.setCapability("nativeEvents", false);
        ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
        ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
        ieCapabilities.setCapability("disable-popup-blocking", true);
        ieCapabilities.setCapability("enablePersistentHover", true);
        ieCapabilities.setCapability("pageLoadStrategy", "unstable");
        ieCapabilities.setCapability("ignoreZoomSetting", true);

        WebDriver driver = new InternetExplorerDriver(ieCapabilities);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        // WebDriver driver = new InternetExplorerDriver(caps);

//        Maximize browser window 
        PomocneFunkce odkazNaCCM = new PomocneFunkce();
        driver.get(odkazNaCCM.nastavURLTestovacihoProstredi(testProstredi));
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);

        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();
        String datumInstalace = datum.vratDatumProInstalaci();
        //driver.get("http://sharepoint.cz.tmo/sites/projects/WhitelabelFleet/SitePages/Home.aspx?RootFolder=%2Fsites%2Fprojects%2FWhitelabelFleet%2FBRFS%2FngOSIP&FolderCTID=0x012000D2BEDE17FD13E64F93AFB39D05EDAE1C&View=%7B21B56BD4%2DFDDF%2D40BA%2DB559%2DAF6A5FC3B3CC%7D");
//        driver.get("http://90.183.26.79:1080/auth/sign/in");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.id("frm-loginForm-username")).sendKeys("james" + Keys.INSERT);
//        driver.findElement(By.id("frm-loginForm-password")).sendKeys("bond" + Keys.INSERT);
//        driver.findElement(By.id("frm-loginForm-send")).click();
//
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/nav/ul/li[1]/a")).click();     // nová objednávka
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[3]/a")).click();   // vytvořit novou objednávku
//        Datumy datum = new Datumy();
//        String dnesniDatum = datum.vratAktualniDatum();

        Thread.sleep(7000);
      //  WebDriverWait wait = new WebDriverWait(driver, 60);
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("i_ic")));
        driver.findElement(By.name("i_ic")).sendKeys(ICO+"" + Keys.INSERT);

        driver.findElement(By.name("i_solus")).click();
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

        driver.findElement(By.name("i_zip")).sendKeys("48563" + Keys.INSERT);

        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/table/tbody/tr/td[2]/table/tbody/tr[39]/td/input[1]")).click(); //vyhledání
        driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")).click(); //Aktivace
       // driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[10]/td/a")).click(); //Aktivace DSL - Nový zákazník
       driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[11]/td/a")).click();
        Thread.sleep(3000);
       driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td/a")).click(); //Nemám hlasovou pevnou linku
        Select droplistTypSluzby = new Select(driver.findElement(By.id("IXDSL_TYPE")));
         Thread.sleep(3000);
        droplistTypSluzby.selectByVisibleText("Profi ADSL/Voice"); //Typ datové služby
        driver.findElement(By.id("NEXT")).click(); //Pokračovat
        Select droplistVariantaDatoveSluzby = new Select(driver.findElement(By.id("IVOICE_VARIANT")));
        droplistVariantaDatoveSluzby.selectByVisibleText("multi"); //Typ datové služby
        Select droplistTypPortu = new Select(driver.findElement(By.id("IVOICE_PORTTYPE")));
        droplistTypPortu.selectByVisibleText("POTS"); //Typ datové služby
        driver.findElement(By.name("IDATA_POTS_NUMBER")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("IDATA_POTS_NUMBER")).sendKeys("1");
        driver.findElement(By.id("iregion")).sendKeys("Hlavní město Praha");
      //  Thread.sleep(6000);
       // driver.findElement(By.id("3100")).click();

        driver.findElement(By.id("icity")).sendKeys("Praha");
          Thread.sleep(3000);
        driver.findElement(By.id("554782")).click();
 
        driver.findElement(By.id("iscity")).sendKeys("Nusle");
          Thread.sleep(3000);
        driver.findElement(By.id("490156")).click();
    
        driver.findElement(By.id("istreet")).sendKeys("Na Květnici");
          Thread.sleep(3000);
        driver.findElement(By.id("458155")).click();
    
        driver.findElement(By.id("ino")).sendKeys("10/14");
         Thread.sleep(5000);
       driver.findElement(By.id("21941696")).click();
        

      //  driver.findElement(By.name("icity")).sendKeys("Praha");
       // driver.findElement(By.name("iscity")).sendKeys("Nusle");
      //  driver.findElement(By.name("istreet")).sendKeys("Táborská");
      //  driver.findElement(By.name("ino")).sendKeys("22");
      //  driver.findElement(By.id("1211218")).click();
       // Select droplistPSC = new Select(driver.findElement(By.id("INO")));
        //droplistPSC.selectByVisibleText("22"); //Typ datové služby

        
//        WebDriverWait wait = new WebDriverWait(driver, 500);
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("REQ_SELLER_CODE_FV")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("335")));
//        driver.findElement(By.partialLinkText("335")).click();
//        driver.findElement(By.id("NEXT")).click();
       
         driver.findElement(By.id("CHECK")).click();
       //  Thread.sleep(100000);
         
         driver.findElement(By.xpath("(//input[@name='ITARIFF'])[2]")).click();
         driver.findElement(By.id("NEXT")).click();
         Thread.sleep(1000);
         Alert alert = driver.switchTo().alert();
          alert.accept();
         Thread.sleep(2000);
       //  driver.findElement(By.id("i_val")).click();
       //  driver.findElement(By.xpath("(//input[@name='i_val'])[Ano]")).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("REQ_SELLER_CODE_FV")));
         Thread.sleep(15000);
        driver.findElement(By.id("REQ_SELLER_CODE_FV")).sendKeys("ASC00.001.001" + Keys.INSERT);                  // outlet  
        driver.findElement(By.id("REQ_PIN_FV")).sendKeys("5050" + Keys.INSERT);  // PIN zaměstnance

        // záložka Zákazník
        driver.findElement(By.id("CON_P_COMP_LAST_NAME_FV")).sendKeys("xDSL_NGOSIP_VSE" + Keys.INSERT);  // obchodní název
        driver.findElement(By.id("ADR_CNR_STREET_FV")).sendKeys("Hlavní" + Keys.INSERT);            // Ulice              
        driver.findElement(By.id("ADR_CNR_NUMBER_RED_FV")).sendKeys("48" + Keys.INSERT);            // číslo popisné
        driver.findElement(By.id("ADR_CNR_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // město
        driver.findElement(By.id("ADR_CNR_ZIP_FV")).sendKeys("47850" + Keys.INSERT);                // PSČ

        // záložka ZO kontakt
        driver.findElement(By.id("but2")).click();

        driver.findElement(By.id("CON_I_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno                  
        driver.findElement(By.id("CON_I_COMP_LAST_NAME_FV")).sendKeys("Nový" + Keys.INSERT);        // Příjmení  
        String rc = RcGenerator.generateRcForAge(20, 55, RcGenerator.Gender.MALE, RcGenerator.RcType.COMMON);
        driver.findElement(By.id("CON_I_BIRTH_NUMBER_FV")).sendKeys(rc + "" + Keys.INSERT);             // Rodné číslo
        driver.findElement(By.id("ADR_CNT_STREET_FV")).sendKeys("Pražská" + Keys.INSERT);           // Ulice         
        driver.findElement(By.id("ADR_CNT_NUMBER_RED_FV")).sendKeys("156" + Keys.INSERT);           // Číslo popisné
        driver.findElement(By.id("ADR_CNT_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // Město
        driver.findElement(By.id("ADR_CNT_ZIP_FV")).sendKeys("48520" + Keys.INSERT);                // PSČ
        driver.findElement(By.id("CON_I_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);         // Email
        driver.findElement(By.id("CON_I_MSISDN1_FV")).sendKeys("789456321" + Keys.INSERT);         // Email
        driver.findElement(By.id("CON_I_DOC1_NUMBER_FV")).sendKeys(nahodneCislo + "" + Keys.INSERT);            // Číslo dokumentu
        driver.findElement(By.id("CON_I_VALID_DOC1_FV")).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu
        driver.findElement(By.id("CON_I_PASSWORD_FV")).sendKeys("2015" + Keys.INSERT);              // Heslo

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

        Select droplistHW = new Select(driver.findElement(By.id("SCP_HW_RENT_TYPE_FV")));
        droplistHW.selectByVisibleText("Allied Data CJT-1616B-2 (ADSL router - ADSL2+, 1xEth, 2xPOTS)");
        driver.findElement(By.id("SER_SIGNATURE_DATE_FV")).sendKeys(dnesniDatum + "" + Keys.INSERT);   //datum podpisu objednávky

        driver.findElement(By.id("ADR_INST_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno 
        driver.findElement(By.id("ADR_INST_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);             // Příjmení 

        driver.findElement(By.id("ADR_DEL_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id("ADR_DEL_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id("ADR_DEL_STREET_FV")).sendKeys("Pražská" + Keys.INSERT);              //  ulice  
        driver.findElement(By.id("ADR_DEL_NUMBER_RED_FV")).sendKeys("12" + Keys.INSERT);              // email  
        driver.findElement(By.id("ADR_DEL_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id("ADR_DEL_ZIP_FV")).sendKeys("10000" + Keys.INSERT);                  // PSČ 

        driver.findElement(By.id("SCP_INSTALL_DATE_FV")).sendKeys(datumInstalace + "" + Keys.INSERT); // Preferované datum instalace

      
        Thread.sleep(5000);
        driver.findElement(By.id("but7")).click(); // Kontrola

           
       }
    
}
