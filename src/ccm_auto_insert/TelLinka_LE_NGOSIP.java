package ccm_auto_insert;

import generatorRC.RcGenerator;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelLinka_LE_NGOSIP {

    static void telLinka(int CisloKPridruzeni, int testProstredi) {

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

        driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td/table/tbody/tr[2]/td/a[2]")).click(); //aktivace

        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr[22]/td/a")).click();  //přidružení SIM

        wait.until(ExpectedConditions.elementToBeClickable(By.id("but2")));
        // záložka ZO kontakt
        driver.findElement(By.id("but2")).click();

        driver.findElement(By.id("CON_I_FIRST_NAME_FV")).sendKeys("Marek" + Keys.INSERT);             // Jméno                  
        driver.findElement(By.id("CON_I_COMP_LAST_NAME_FV")).sendKeys("Syrový" + Keys.INSERT);        // Příjmení  
        String rc;
        driver.findElement(By.id("CON_I_BIRTH_NUMBER_FV")).sendKeys(rc = RcGenerator.generateRcForAge(19, 55) + "" + Keys.INSERT);    // Rodné číslo
        driver.findElement(By.id("CON_I_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);              // Email
        driver.findElement(By.id("CON_I_DOC1_NUMBER_FV")).sendKeys(nahodneCislo + "" + Keys.INSERT);   // Číslo dokumentu
        driver.findElement(By.id("CON_I_VALID_DOC1_FV")).sendKeys("1220" + Keys.INSERT);            // Platnost dokumentu

//        // záložka Služby
        driver.findElement(By.id("but4")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("CON_P_PASSWORD1_FV")));

        //driver.findElement(By.id("CON_P_PASSWORD1_FV")).sendKeys("1111" + Keys.INSERT);  //heslo
        driver.findElement(By.id("ADR_FIX_FIRST_NAME_FV")).sendKeys("Jan" + Keys.INSERT);             // Jméno    
        driver.findElement(By.id("ADR_FIX_COMP_LAST_NAME_FV")).sendKeys("Pilný" + Keys.INSERT);       // Příjmení    
        driver.findElement(By.id("ADR_FIX_STREET_FV")).sendKeys("Hlavní" + Keys.INSERT);              // Ulice    
        driver.findElement(By.id("ADR_FIX_NUMBER_RED_FV")).sendKeys("12" + Keys.INSERT);              // Číslo popisné    
        driver.findElement(By.id("ADR_FIX_TOWN_FV")).sendKeys("Praha" + Keys.INSERT);                 // Město    
        driver.findElement(By.id("ADR_FIX_ZIP_FV")).sendKeys("48963" + Keys.INSERT);                  // PSČ   
        driver.findElement(By.id("ADR_FIX_EMAIL_FV")).sendKeys("test@test.cz" + Keys.INSERT);         // email   
        driver.findElement(By.id("ADR_FIX_CONT_NUMBER_FV")).sendKeys("789456123" + Keys.INSERT);         // email   

        Select droplistInstalace = new Select(driver.findElement(By.id("SER_INSTALL_FV")));
        droplistInstalace.selectByVisibleText("Instalace");

        driver.findElement(By.id("SER_OSIP_FV")).click();  //NGOSIP checkbox

        Select droplistKraj = new Select(driver.findElement(By.id("ADR_FIX_REGION_FV")));
        droplistKraj.selectByVisibleText("Hlavní město Praha");

        Select droplistTarif = new Select(driver.findElement(By.id("SUB_QPROTAR_QPROTAR_ID_FV")));
        droplistTarif.selectByVisibleText("Telefonní linka Premium HIT");

        driver.findElement(By.id("SER_SIGNATURE_DATE_FV")).sendKeys(dnesniDatum + "" + Keys.INSERT);   //datum podpisu objednávky
        driver.findElement(By.id("SCP_INSTALL_DATE_FV")).sendKeys("29.10.2015" + Keys.INSERT);   //datum podpisu objednávky
        driver.findElement(By.id("but7")).click(); // Kontrola

    }
}
