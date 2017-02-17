/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import java.sql.SQLException;
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
        switch (hodnota) {
            case 1:
                odkazTest = "https://qdealers.cz.tmo/ap01/cui_web_search_entry.cui_startup?";
                //odkazTest = "https://tst001:paegas@qdealers.cz.tmo/ap01/cui_web_search_entry.cui_startup/";
                break;
            case 2:
                odkazTest = "https://q2dealers.cz.tmo/ap01/cui_web_search_entry.cui_startup?";
                break;
            case 3:
                odkazTest = "https://q3dealers.cz.tmo/ap01/cui_web_search_entry.cui_startup?";
                break;
            default:
                break;
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

    public String vyplnICO(boolean ICOzeSouboru, int testProstredi) throws SQLException {
        String ICO;
        if (ICOzeSouboru == true) {
            ICO = OutputInputFile.getICO("ICO");
            return ICO;

        } else {
            ICO = SQL_selects.ICOdatabase(dbConnection.dbConnection_dwh(testProstredi), testProstredi);
            return ICO;
        }

    }
}
