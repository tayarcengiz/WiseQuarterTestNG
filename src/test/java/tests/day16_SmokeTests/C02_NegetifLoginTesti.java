package tests.day16_SmokeTests;

import Pages.QualitydemyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegetifLoginTesti {

    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin

    QualitydemyPage qualitydemyPage= new QualitydemyPage();

    @Test
    public void yanlisEmailTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        ReusableMethods.bekle(1);
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.Cookies.click();
        ReusableMethods.bekle(1);
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.Cookies.click();

        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        ReusableMethods.bekle(1);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.Loginkutusu.isDisplayed());

        ReusableMethods.bekle(1);
        Driver.closeDriver();
    }

    @Test
    public void yanlisPasswordTesti(){
        qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));

        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.Cookies.click();ReusableMethods.bekle(1);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.Loginkutusu.isDisplayed());

        ReusableMethods.bekle(1);
        Driver.closeDriver();

    }


    @Test
    public void yanlisUsernameYanlisPasswordTesti(){

        qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.Cookies.click();
        ReusableMethods.bekle(1);
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        ReusableMethods.bekle(1);
        qualitydemyPage.loginButonu.click();
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        ReusableMethods.bekle(1);
        Assert.assertTrue(qualitydemyPage.Loginkutusu.isDisplayed());

        ReusableMethods.bekle(1);
        Driver.closeDriver();

    }



}
