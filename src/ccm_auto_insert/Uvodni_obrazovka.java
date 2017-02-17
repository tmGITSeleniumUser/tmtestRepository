package ccm_auto_insert;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

public class Uvodni_obrazovka {

    static String vyplnCUI_driverFirefox(int testProstredi, FirefoxDriver driver) throws SQLException {

        //driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("ico"))).sendKeys(ICO + "" + Keys.INSERT);
        String ICO = SQL_selects.ICOdatabase(dbConnection.dbConnection_dwh(testProstredi), testProstredi) + "" + Keys.INSERT;
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("ico"))).sendKeys(ICO);

//driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_solus"))).click();
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_pr_query"))).click();
        Select droplistSP = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_citizenship"))));
        droplistSP.selectByVisibleText("ČR");
        Select droplistTS = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_customer_type"))));
        droplistTS.selectByVisibleText("Právnická osoba");
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_voice"))).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_fix_voice"))).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_data"))).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_fix_data"))).sendKeys("1" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_sim_roam"))).sendKeys("1" + Keys.INSERT);
        Select droplistPM = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_payment_type"))));
        droplistPM.selectByVisibleText("Cash");
        Select droplistDK = new Select(driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_contr_duration"))));
        droplistDK.selectByVisibleText("24 měsíců");
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_mmp"))).sendKeys("20000" + Keys.INSERT);
        driver.findElement(By.name(HTML_identifier_library.id_aktivace_cui("i_zip"))).sendKeys("14000" + Keys.INSERT);
        driver.findElement(By.xpath(HTML_identifier_library.id_aktivace_cui("vyhledej"))).click();

        return ICO;
    }

    static FirefoxDriver otevriProhlizec(int testProstredi) {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        FirefoxDriver driver = new FirefoxDriver(myprofile);
        PomocneFunkce odkazNaCCM = new PomocneFunkce();
        String odkaz = odkazNaCCM.nastavURLTestovacihoProstredi(testProstredi);
        driver.navigate().to(odkaz);
        driver.manage().window().maximize();
        return driver;
    }

}
