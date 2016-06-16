/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author oholik
 */
public class PomocneFunkce {

    public String nastavURLTestovacihoProstredi(int hodnota) {
        String odkazTest = null;
        if (hodnota == 1) {
            odkazTest = "https://qdealers.cz.tmo/ap01/cui_web_search_entry.cui_startup?";
            //odkazTest = "https://tst001:paegas@qdealers.cz.tmo/ap01/cui_web_search_entry.cui_startup/";

        } else if (hodnota == 2) {
            odkazTest = "https://q2dealers.cz.tmo/ap01/cui_web_search_entry.cui_startup?";

        }
        return odkazTest;

    }

    public static void BackToHome(FirefoxDriver Fdriver) {
        WebElement button_cus = (new WebDriverWait(Fdriver, 60)) /*čekání na prvek*/
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Customer Info")));
        Fdriver.findElement(By.linkText("Customer Info")).click();

        WebElement button_Home = (new WebDriverWait(Fdriver, 10)) /*čekání na prvek*/
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
        Fdriver.findElement(By.linkText("Home")).click();

    }

    public static boolean existsElement(FirefoxDriver Fdriver, String path) {
        try {
            Fdriver.findElement(By.xpath(path));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

}
