package ccm_auto_insert;


import java.sql.SQLException;
import java.util.Random;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CCMDokonceni {

    static void dokonceni(int testProstredi, int pocetPocetZakazniku) throws SQLException {

        // System.setProperty("webdriver.ie.driver", "C:/Users/oholik/Desktop/Selenium/selenium-java-2.45.0/IEDriverServer.exe");
        //  InternetExplorerDriver IEDriver = new InternetExplorerDriver();
//        PomocneFunkce vyplnUdaje = new PomocneFunkce();
//        vyplnUdaje.vyplnUdajeICO(ICO, testProstredi);
//        
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");

        FirefoxDriver driver = new FirefoxDriver(myprofile);

        Random rand = new Random();
        int nahodneCislo = rand.nextInt(1000000000);
        String rc;
        int Status;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        PomocneFunkce odkazNaCCM = new PomocneFunkce();
        String odkaz = odkazNaCCM.nastavURLTestovacihoProstredi(testProstredi);
        driver.navigate().to(odkaz);
        driver.manage().window().maximize();

        Datumy datum = new Datumy();

        for (int i = 1; i <= pocetPocetZakazniku; i++) {
            System.out.println("Průchod:" + i);

            String MSISDN = OutputInputFile.getMSISDN("CCM");

            driver.findElement(By.name("i_msisdn")).sendKeys(MSISDN);

            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/table/tbody/tr/td[2]/table/tbody/tr[39]/td/input[1]")).click(); //vyhledání

            WebElement button_seznam = (new WebDriverWait(driver, 20)) /*čekání na prvek*/
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/table[3]/tbody/tr[1]/td/table/tbody/tr[2]/td/a[1]")));

            driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/table/tbody/tr[2]/td/a[1]")).click();

            WebElement button_dotaz = (new WebDriverWait(driver, 20)) /*čekání na prvek*/
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/center/form[2]/input[32]")));

            driver.findElement(By.xpath("/html/body/center/form[2]/input[32]")).click(); // Dotaz do seznamu

            driver.findElement(By.id("P_MSISDN")).sendKeys(MSISDN); // Zadej telefoni cislo
            driver.findElement(By.id("P_L_CCMRST_NAME")).sendKeys("InProgress"); // Status

            WebElement button_zadost = (new WebDriverWait(driver, 20)) /*čekání na prvek*/
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/center/form/p[2]/input[2]")));

            driver.findElement(By.xpath("/html/body/center/form/p[2]/input[2]")).click(); // Najit

            WebElement button_otevre_zadost = (new WebDriverWait(driver, 20)) /*čekání na prvek*/
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/center/p[2]/table/tbody/tr[2]/td[15]/div/a/img")));
            driver.findElement(By.xpath("/html/body/center/p[2]/table/tbody/tr[2]/td[15]/div/a/img")).click(); // Otevre zadost

            WebElement button_odeslat = (new WebDriverWait(driver, 20)) /*čekání na prvek*/
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("but8")));

            driver.findElement(By.id("but8")).click(); // Odeslat zadost

            Alert alert_odeslat = driver.switchTo().alert();
            alert_odeslat.accept();

            WebElement button_cus = (new WebDriverWait(driver, 90)) /*čekání na prvek*/
                    .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Customer Info")));
            Status = Integer.valueOf(SQL_selects.getStatusCCMRequest(dbConnection.dbConnection_qap(testProstredi), testProstredi, MSISDN));
            if (Status == 3) {

                WebElement button_whitefinel = (new WebDriverWait(driver, 60)) /*čekání na prvek*/
                        .until(ExpectedConditions.presenceOfElementLocated(By.id("but20")));
                driver.findElement(By.id("but20")).click(); // Odeslat do WhiteFinel

                Alert alert_wf = driver.switchTo().alert();
                alert_wf.accept();
                OutputInputFile.writeResultOffCheck(MSISDN, "CCM", "Žádost je dokončena.");
                PomocneFunkce.BackToHome(driver);

            } else {
                String IDRequest = SQL_selects.getIDRequest(dbConnection.dbConnection_qap(testProstredi), testProstredi, MSISDN);
                driver.findElement(By.linkText(IDRequest)).click();

                WebElement button_doc = (new WebDriverWait(driver, 20)) /*čekání na prvek*/
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/center/p[2]/table/tbody/tr[2]/td[17]/div/a/img")));
                driver.findElement(By.xpath("/html/body/center/p[2]/table/tbody/tr[2]/td[17]/div/a/img")).click(); // Otevre zadost

                Alert alert_odeslat_grey = driver.switchTo().alert();
                alert_odeslat.accept();

                WebElement button_zadosti = (new WebDriverWait(driver, 90)) /*čekání na prvek*/
                        .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Seznam žádostí")));

                driver.findElement(By.linkText(IDRequest)).click();
                WebElement button_open_zadost = (new WebDriverWait(driver, 10)) /*čekání na prvek*/
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/center/p[2]/table/tbody/tr[2]/td[15]/div/a/img")));

                driver.findElement(By.xpath("/html/body/center/p[2]/table/tbody/tr[2]/td[15]/div/a/img")).click(); // Otevre zadost                

                WebElement button_ceny = (new WebDriverWait(driver, 60)) /*čekání na prvek*/
                        .until(ExpectedConditions.presenceOfElementLocated(By.id("but9")));
                driver.findElement(By.id("but9")).click(); // Prepnout na zalozku Ceny

                WebElement button_whitefinel = (new WebDriverWait(driver, 60)) /*čekání na prvek*/
                        .until(ExpectedConditions.presenceOfElementLocated(By.id("but20")));
                driver.findElement(By.id("but20")).click(); // Odeslat do WhiteFinel

                Alert alert_odeslat_whitefinel = driver.switchTo().alert();
                alert_odeslat.accept();

                OutputInputFile.writeResultOffCheck(MSISDN, "CCM", "Žádost je dokončena.");

                PomocneFunkce.BackToHome(driver);

            }

        }
    }

}
