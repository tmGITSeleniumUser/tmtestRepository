/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import generatorRC.RcGenerator;
import java.sql.SQLException;
import java.util.regex.Pattern;
import static org.junit.Assert.*;
import java.util.Random;
import org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author oholik
 */
public class DSL_SIMPLE_VSE_SME {

    static void proved_DSL_SIMPLE_VSE_SME_skript(String ICO, int testProstredi) throws InterruptedException, SQLException {
        WebDriver driver = Uvodni_obrazovka.otevriProhlizecIE(testProstredi);
        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);

        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();
        String datumInstalace = datum.vratDatumProInstalaci();

        Thread.sleep(9000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("i_ic")));
        Uvodni_obrazovka.vyplnCUI(testProstredi, driver, false, ICO);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")).click(); //Aktivace
        // driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[10]/td/a")).click(); //Aktivace DSL - Nový zákazník
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[11]/td/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td/a")).click(); //Nemám hlasovou pevnou linku
        Thread.sleep(3000);
        Select droplistTypSluzby = new Select(driver.findElement(By.id("IXDSL_TYPE")));
        droplistTypSluzby.selectByVisibleText("Profi ADSL/Voice"); //Typ datové služby
        driver.findElement(By.id("NEXT")).click(); //Pokračovat

        Select droplistVariantaDatoveSluzby = new Select(driver.findElement(By.id("IVOICE_VARIANT")));
        droplistVariantaDatoveSluzby.selectByVisibleText("simple"); //Typ datové služby
        Select droplistTypPortu = new Select(driver.findElement(By.id("IVOICE_PORTTYPE")));
        droplistTypPortu.selectByVisibleText("POTS"); //Typ datové služby
        //driver.findElement(By.name("IDATA_POTS_NUMBER")).sendKeys(Keys.BACK_SPACE);
        // driver.findElement(By.name("IDATA_POTS_NUMBER")).sendKeys("0");

        driver.findElement(By.id("iregion")).sendKeys("Hlavní město Praha");
        //  Thread.sleep(3000);
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

        driver.findElement(By.id("ino")).sendKeys("10/13b");
        Thread.sleep(5000);
        driver.findElement(By.id("25120468")).click();

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

        driver.findElement(By.xpath("(//input[@name='ITARIFF'])[4]")).click();
        driver.findElement(By.id("NEXT")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(10000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("REQ_SELLER_CODE_FV")));
        driver.findElement(By.id("REQ_SELLER_CODE_FV")).sendKeys("ASC00.001.001" + Keys.INSERT); // outlet  
        Thread.sleep(3000);
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
