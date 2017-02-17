package ccm_auto_insert;

import generatorRC.RcGenerator;
import java.sql.SQLException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class Autopark_VSE_NGOSIP {

    static void proved_Autopark_VSE_skript(int testProstredi, boolean Installment) throws SQLException {

        WebDriver driver = Uvodni_obrazovka.otevriProhlizecFirefox(testProstredi);
        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);
        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        String ICO = null;
        ICO = Uvodni_obrazovka.vyplnCUI(testProstredi, driver, Installment, "0");

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace"))));
        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace"))).click();
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace_autopark_asc"))));
        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("aktivace_autopark_asc"))).click();
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("CON_P_COMP_LAST_NAME_FV")));
        //zalozka Zakaznik
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("REQ_SELLER_CODE_FV"))).sendKeys("ASC00.001.001" + Keys.INSERT);   // outlet
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("REQ_PIN_FV"))).sendKeys("5050" + Keys.INSERT);   // PIN zaměstnance         // záložka Zákazník
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_P_COMP_LAST_NAME_FV"))).sendKeys("Autopark_HPSM_" + ICO + Keys.INSERT);  // obchodní název
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_STREET_FV"))).sendKeys("Hlavní" + Keys.INSERT);            // Ulice              
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_NUMBER_RED_FV"))).sendKeys("48" + Keys.INSERT);            // číslo popisné
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_TOWN_FV"))).sendKeys("Praha" + Keys.INSERT);               // město
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNR_ZIP_FV"))).sendKeys("14000" + Keys.INSERT);                // PSČ

        // záložka ZO kontakt
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("but2"))).click();

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_FIRST_NAME_FV"))).sendKeys("Jan" + Keys.INSERT);             // Jméno                  
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_COMP_LAST_NAME_FV"))).sendKeys("Nový" + Keys.INSERT);        // Příjmení  
        String rc = RcGenerator.generateRcForAge(20, 60, RcGenerator.Gender.MALE, RcGenerator.RcType.COMMON);
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_BIRTH_NUMBER_FV"))).sendKeys(rc + "" + Keys.INSERT);             // Rodné číslo
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNT_STREET_FV"))).sendKeys("Pražská" + Keys.INSERT);           // Ulice         
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNT_NUMBER_RED_FV"))).sendKeys("156" + Keys.INSERT);           // Číslo popisné
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNT_TOWN_FV"))).sendKeys("Praha" + Keys.INSERT);               // Město
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_CNT_ZIP_FV"))).sendKeys("14000" + Keys.INSERT);                // PSČ
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_EMAIL_FV"))).sendKeys("test@test.cz" + Keys.INSERT);         // Email
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("CON_I_MSISDN1_FV"))).sendKeys("789456321" + Keys.INSERT);         // Email
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
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_BIL_ZIP_FV"))).sendKeys("14000" + Keys.INSERT);                  // PSČ    

        Select droplistOS = new Select(driver.findElement(By.id("ADR_BIL_QCUSSAL_ID_FV")));
        droplistOS.selectByVisibleText("Vážený zákazníku");

        // záložka Služby
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("but4"))).click();

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_DEL_FIRST_NAME_FV"))).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_DEL_COMP_LAST_NAME_FV"))).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_DEL_STREET_FV"))).sendKeys("Pražská" + Keys.INSERT);              //  ulice  
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_DEL_NUMBER_RED_FV"))).sendKeys("12" + Keys.INSERT);              // email  
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_DEL_TOWN_FV"))).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("ADR_DEL_ZIP_FV"))).sendKeys("14000" + Keys.INSERT);                  // PSČ   

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SER_SIGNATURE_DATE_FV"))).sendKeys(dnesniDatum + "" + Keys.INSERT);   //datum podpisu objednávky
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SER_OSIP_FV"))).click();  //NGOSIP checkbox

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SCP_CF_INST_FIRST_NAME_FV"))).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SCP_CF_INST_COMP_LAST_NAME_FV"))).sendKeys("Novák" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SCP_CF_NOTIFY_PHONE_FV"))).sendKeys("789456132" + Keys.INSERT);              // telefon
        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SCP_CF_NOTIFY_EMAIL_FV"))).sendKeys("test@test.cz" + Keys.INSERT);        //email

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("SUB_PHONE_SAPCODE_FV"))).sendKeys("000000000000803000 - Balíček Basic - GPS jednotka - montáž" + Keys.INSERT); //HW

        driver.findElement(By.id(HTML_identifier_library.id_aktivace_cui("but7"))).click(); // Kontrola

    }

}
