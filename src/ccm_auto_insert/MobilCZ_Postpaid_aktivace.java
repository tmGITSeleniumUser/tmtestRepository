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

/**
 *
 * @author oholik
 */
public class MobilCZ_Postpaid_aktivace {

    static void proved_MobilCZ_Postpaid_aktivace_skript(String tarif) {

       // System.setProperty("webdriver.ie.driver", "C:/Users/oholik/Desktop/Selenium/selenium-java-2.45.0/IEDriverServer.exe");
        //InternetExplorerDriver IEDriver = new InternetExplorerDriver();
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");

        FirefoxDriver driver = new FirefoxDriver(myprofile);

        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.navigate().to("http://90.183.26.79:1080/auth/sign/in");
        //driver.navigate().to("http://demorwe.a-box.cz/auth/sign/in");
        driver.manage().window().maximize();

        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();

        driver.findElement(By.id("frm-loginForm-username")).sendKeys("james" + Keys.INSERT);
        driver.findElement(By.id("frm-loginForm-password")).sendKeys("bond" + Keys.INSERT);
        driver.findElement(By.id("frm-loginForm-send")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/nav/ul/li[1]/a")).click();     // nová objednávka
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[3]/a")).click();   // vytvořit novou objednávku
        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("frm-orderForm-customerForm-customer-subjectType")));        
        driver.findElement(By.id("frm-orderForm-customerForm-customer-loyality")).sendKeys(nahodneCislo + "" + Keys.INSERT); // MAFRA ID

        driver.findElement(By.id("frm-orderForm-customerForm-contact-firstName")).sendKeys("Karel" + Keys.INSERT);            // jméno
        driver.findElement(By.id("frm-orderForm-customerForm-contact-lastName")).sendKeys("Kabel" + Keys.INSERT);            // příjmení
        String rc = RcGenerator.generateRcForAge(20, 55, RcGenerator.Gender.MALE, RcGenerator.RcType.NO_MOD_11);
        String rc1 = rc.substring(0, 6);
        String rc2 = rc.substring(6, 10);
        driver.findElement(By.id("frm-orderForm-customerForm-contact-birthNumber1")).sendKeys(rc1 + "" + Keys.INSERT);  //rodne číslo začátek
        driver.findElement(By.id("frm-orderForm-customerForm-contact-birthNumber2")).sendKeys(rc2 + "" + Keys.INSERT);  //rodne číslo začátek

        Select droplistTypDokladu = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[2]/fieldset[1]/div[1]/div/div[1]/div/select")));
        droplistTypDokladu.selectByVisibleText("Občanský průkaz");
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[2]/fieldset[1]/div[1]/div/div[2]/div/input")).sendKeys(nahodneCislo + "" + Keys.INSERT);  // ID občanky 
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[2]/fieldset[1]/div[1]/div/div[3]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[2]/fieldset[1]/div[1]/div/div[3]/div/input")).sendKeys("24.12.2025" + Keys.INSERT);  // platnost průkazu

        driver.findElement(By.id("frm-orderForm-customerForm-residence-street")).sendKeys("Tomíčkova" + Keys.INSERT);  // ulice jednatele
        driver.findElement(By.id("frm-orderForm-customerForm-residence-zip")).sendKeys("14800" + Keys.INSERT);  // PSČ jednatele
        driver.findElement(By.id("frm-orderForm-customerForm-residence-streetNumberRed")).sendKeys("2144" + Keys.INSERT);  // č.p. jednatele
        driver.findElement(By.id("frm-orderForm-customerForm-residence-streetNumberBlue")).sendKeys("1" + Keys.INSERT);  // č.o. jednatele        
        driver.findElement(By.id("frm-orderForm-customerForm-residence-city")).sendKeys("Praha" + Keys.INSERT);  // Město jednatele
        driver.findElement(By.id("validateContactAddress")).click(); // Kontrola adresy Contactni adresy
        
        Select droplistOsloveni = new Select(driver.findElement(By.id("frm-orderForm-customerForm-contact-salutation")));
        droplistOsloveni.selectByVisibleText("Vážený zákazníku");
        driver.findElement(By.id("frm-orderForm-customerForm-contact-email")).sendKeys("test@test.cz" + Keys.INSERT);  // email
        driver.findElement(By.id("passwordInput")).sendKeys("2015" + Keys.INSERT);  // email

        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-street")).sendKeys("Tomíčkova" + Keys.INSERT);  // ulice jednatele
        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-zip")).sendKeys("14800" + Keys.INSERT);  // PSČ jednatele
        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-streetNumberRed")).sendKeys("2144" + Keys.INSERT);  // č.p. jednatele
        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-streetNumberBlue")).sendKeys("1" + Keys.INSERT);  // č.o. jednatele        
        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-city")).sendKeys("Praha" + Keys.INSERT);  // Město jednatele

//        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-street")).sendKeys("Hlavní" + Keys.INSERT);     // ulice
//        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-zip")).sendKeys("45632" + Keys.INSERT);         // PSČ
//        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-streetNumberRed")).sendKeys("42" + Keys.INSERT); //číslo popisné
//        driver.findElement(By.id("frm-orderForm-customerForm-billingAddress-city")).sendKeys("Praha" + Keys.INSERT);            // město
        driver.findElement(By.id("frm-orderForm-customerForm-agreements-solus")).click();    //SOLUS1
        driver.findElement(By.id("frm-orderForm-customerForm-agreements-positiveSolus")).click();    //SOLUS2

        Select droplistTarif = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[4]/div/select")));
        droplistTarif.selectByVisibleText(tarif);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[2]/div[3]/div/input[1]")).sendKeys(dnesniDatum + "" + Keys.INSERT);  // datum aktivace
       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[3]/div/a"))); // ceka na nacteni nabidky
        driver.findElementByXPath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[3]/div/a").click(); // zvoleni MSISDN
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/a[1]")));// ceka na nacteni nabidky
        driver.findElementByXPath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/a[1]").click(); // Vyber konkrétního čísla

        driver.findElementByXPath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[3]/div/a").click(); // Pridej dalsi SU        
        
        
        driver.findElement(By.id("validateBillingAddress")).click(); // Kontrola adresy Billingove Adresy
        driver.findElement(By.id("save")).click(); // Ulozeni zadosti
//        driver.findElement(By.id("creditCheck")).click(); // Kontrola
    }
}
