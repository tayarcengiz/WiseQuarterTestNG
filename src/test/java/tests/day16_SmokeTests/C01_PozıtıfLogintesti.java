package tests.day16_SmokeTests;

import Pages.QualitydemyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PozıtıfLogintesti {

    @Test
    public void pozitiflogintest(){
        // qualitydemy anasayfaya git


        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        ReusableMethods.bekle(1);
        qualitydemyPage.Cookies.click();
        ReusableMethods.bekle(1);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());
        ReusableMethods.bekle(1);
        Driver.closeDriver();
        



    }


}
