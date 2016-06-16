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
public class RWE_pridruzeni {

    static void proved_RWE_pridruzeni_skript(String rod_cislo) {

        //System.setProperty("webdriver.ie.driver", "C:/Users/oholik/Desktop/Selenium/selenium-java-2.45.0/IEDriverServer.exe");
        //InternetExplorerDriver IEDriver = new InternetExplorerDriver();
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");

        FirefoxDriver driver = new FirefoxDriver(myprofile);

        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //driver.navigate().to("http://90.183.26.79:1080/auth/sign/in");
        driver.navigate().to("http://demorwe.a-box.cz/auth/sign/in");
        driver.manage().window().maximize();

        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();

        driver.findElement(By.id("frm-loginForm-username")).sendKeys("james" + Keys.INSERT);
        driver.findElement(By.id("frm-loginForm-password")).sendKeys("bond" + Keys.INSERT);
        driver.findElement(By.id("frm-loginForm-send")).click();


        
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/nav/ul/li[1]/a")).click();     // nová objednávka
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[3]/a")).click();   // vytvořit novou objednávku
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("frm-orderForm-customerForm-customer-subjectType")));       

        String rc = rod_cislo;
        String rc1 = rc.substring(0, 6);
        String rc2 = rc.substring(6, 10);
        driver.findElement(By.id("frm-orderForm-customerForm-contact-birthNumber1")).sendKeys(rc1 + "" + Keys.INSERT);  //rodne číslo začátek
        driver.findElement(By.id("frm-orderForm-customerForm-contact-birthNumber2")).sendKeys(rc2 + "" + Keys.INSERT);  //rodne číslo začátek
        driver.findElementByXPath("/html/body/div[1]/div[4]/form/fieldset[2]/div[2]/div[1]/label").click(); // Pro zobrazeni nabidky prechodu na stavajiciho zakaznika
       
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[5]/div[3]/div/div/div/div[2]/a")));  // Ceka na načtení nabídky
       // driver.findElementByXPath("/html/body/div[1]/div[5]/div[3]/div/div/div/div[2]/a").click(); // Proklik na prechod na stavajiciho zakaznika
        driver.findElementByLinkText("Přejít na existujícího zákazníka").click();
        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/a[4]")));
        driver.findElementByXPath("/html/body/div[1]/a[4]").click(); // Proklik na tlačítko přidat službu - přidružení
       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[3]/div/a")));
        driver.findElementByXPath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[3]/div/a").click(); // zvoleni MSISDN
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/a[1]")));
        driver.findElementByXPath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/a[1]").click(); // Vyber konkrétního čísla
        
        Select droplistTarif = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[4]/div/select"))); // zvoleni tarifu
        droplistTarif.selectByVisibleText("RWE Chytrý tarif");

        driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[2]/div[3]/div/input[1]")).sendKeys(dnesniDatum + "" + Keys.INSERT);  // datum aktivace

        
        driver.findElement(By.id("save")).click(); // Ulozeni zadosti
    }
}
