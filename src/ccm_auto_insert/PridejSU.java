/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

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
 * @author Petr
 */
public class PridejSU {  /* Procedura pro přidávání více SU pod jedno CU v jedné žádosti*/
    public void funkcePridejSubcribera(int PocetSU) {
        String Xpath = "";
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");

        FirefoxDriver driver = new FirefoxDriver(myprofile);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Datumy datum = new Datumy();
        String dnesniDatum = datum.vratAktualniDatum();
        
        
        if (PocetSU==1) { /* Pokud je jen jedno Su uděla jen jedno*/
            
            Select droplistTarif = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[4]/div/select")));
            droplistTarif.selectByVisibleText("RWE Chytrý tarif");
            driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[2]/div[3]/div/input[1]")).sendKeys(dnesniDatum + "" + Keys.INSERT);  // datum aktivace

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[3]/div/a"))); // ceka na nacteni nabidky
            driver.findElementByXPath("/html/body/div[1]/div[4]/form/fieldset[6]/div[3]/div/div[1]/div[3]/div/a").click(); // zvoleni MSISDN
        
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/a[1]")));// ceka na nacteni nabidky
            driver.findElementByXPath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/a[1]").click(); // Vyber konkrétního čísla
            
        }
        else{ /*Pokud bude více požadavků na SU přidá více SU*/
                    for (int i = 1; i < PocetSU; i++) {
                    driver.findElementByXPath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/a[1]").click(); //   
        }
                        
        }
        
    }    
}
