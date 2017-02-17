/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import generatorRC.RcGenerator;
import java.sql.SQLException;
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
public class DSL_VSE_reselling {

    static void proved_xDSL_VSE_skript(String ICO, int testProstredi) throws InterruptedException, SQLException {
       
        WebDriver driver = Uvodni_obrazovka.otevriProhlizecIE(testProstredi);

        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);
        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();
        Thread.sleep(8000);
        Uvodni_obrazovka.vyplnCUI(testProstredi, driver, false, ICO);

        driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")).click(); //Aktivace
        driver.findElement(By.linkText("Aktivace DSL - Nový zákazník")).click(); //Aktivace DSL - nový zákazník
        Thread.sleep(4000);

        driver.findElement(By.linkText("- nemám hlasovou pevnou linku")).click(); //Nemám hlasovou pevnou linku
        driver.findElement(By.id("NEXT")).click(); //Pokračovat
        Thread.sleep(6000);
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
        driver.findElement(By.id("CHECK")).click();
        driver.findElement(By.xpath("(//input[@name='ITARIFF'])[2]")).click();
        driver.findElement(By.id("NEXT")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("REQ_SELLER_CODE_FV")));
        Thread.sleep(15000);
        driver.findElement(By.id("REQ_SELLER_CODE_FV")).sendKeys("PGSA7.001.001" + Keys.INSERT);                  // outlet  
        driver.findElement(By.id("REQ_PIN_FV")).sendKeys("5050" + Keys.INSERT);  // PIN zaměstnance

        // záložka Zákazník
        driver.findElement(By.id("CON_P_COMP_LAST_NAME_FV")).sendKeys("xDSL_NGOSIP_VSE_" + ICO + Keys.INSERT);  // obchodní název
        driver.findElement(By.id("ADR_CNR_STREET_FV")).sendKeys("Na Pankráci" + Keys.INSERT);            // Ulice              
        driver.findElement(By.id("ADR_CNR_NUMBER_RED_FV")).sendKeys("86" + Keys.INSERT);            // číslo popisné
        driver.findElement(By.id("ADR_CNR_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // město
        driver.findElement(By.id("ADR_CNR_ZIP_FV")).sendKeys("14000" + Keys.INSERT);                // PSČ

        // záložka ZO kontakt
        driver.findElement(By.id("but2")).click();

        driver.findElement(By.id("CON_I_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno                  
        driver.findElement(By.id("CON_I_COMP_LAST_NAME_FV")).sendKeys("DSLkový" + Keys.INSERT);        // Příjmení  
        String rc = RcGenerator.generateRcForAge(20, 55, RcGenerator.Gender.MALE, RcGenerator.RcType.COMMON);
        driver.findElement(By.id("CON_I_BIRTH_NUMBER_FV")).sendKeys(rc + "" + Keys.INSERT);             // Rodné číslo
        driver.findElement(By.id("ADR_CNT_STREET_FV")).sendKeys("Na Pankráci" + Keys.INSERT);           // Ulice         
        driver.findElement(By.id("ADR_CNT_NUMBER_RED_FV")).sendKeys("86" + Keys.INSERT);           // Číslo popisné
        driver.findElement(By.id("ADR_CNT_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);               // Město
        driver.findElement(By.id("ADR_CNT_ZIP_FV")).sendKeys("14000" + Keys.INSERT);                // PSČ
        driver.findElement(By.id("CON_I_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);         // Email
        driver.findElement(By.id("CON_I_MSISDN1_FV")).sendKeys("789456321" + Keys.INSERT);         // Email
        driver.findElement(By.id("CON_I_DOC1_NUMBER_FV")).sendKeys(nahodneCislo + "" + Keys.INSERT);            // Číslo dokumentu
        driver.findElement(By.id("CON_I_VALID_DOC1_FV")).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu
        driver.findElement(By.id("CON_I_PASSWORD_FV")).sendKeys("2017" + Keys.INSERT);              // Heslo

        // záložka Účtování
        driver.findElement(By.id("but3")).click();

        driver.findElement(By.id("ADR_BIL_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id("ADR_BIL_COMP_LAST_NAME_FV")).sendKeys("BAčkový" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id("ADR_BIL_STREET_FV")).sendKeys("Na Pankráci" + Keys.INSERT);              // Ulice    
        driver.findElement(By.id("ADR_BIL_NUMBER_RED_FV")).sendKeys("86" + Keys.INSERT);              // Číslo popisné    
        driver.findElement(By.id("ADR_BIL_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id("ADR_BIL_ZIP_FV")).sendKeys("14000" + Keys.INSERT);                  // PSČ    

        Select droplistOS = new Select(driver.findElement(By.id("ADR_BIL_QCUSSAL_ID_FV")));
        droplistOS.selectByVisibleText("Vážený zákazníku");

        // záložka Služby
        driver.findElement(By.id("but4")).click();

        Select droplistHW = new Select(driver.findElement(By.id("SCP_HW_RENT_TYPE_FV")));
        driver.findElement(By.id("SER_SIGNATURE_DATE_FV")).sendKeys(dnesniDatum + "" + Keys.INSERT);   //datum podpisu objednávky

        driver.findElement(By.id("ADR_INST_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno 
        driver.findElement(By.id("ADR_INST_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);             // Příjmení 

        driver.findElement(By.id("ADR_DEL_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id("ADR_DEL_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id("ADR_DEL_STREET_FV")).sendKeys("Na Pankráci" + Keys.INSERT);              //  ulice  
        driver.findElement(By.id("ADR_DEL_NUMBER_RED_FV")).sendKeys("86" + Keys.INSERT);              // email  
        driver.findElement(By.id("ADR_DEL_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id("ADR_DEL_ZIP_FV")).sendKeys("14000" + Keys.INSERT);                  // PSČ 

        Thread.sleep(5000);
        driver.findElement(By.id("but7")).click(); // Kontrola

    }

}
