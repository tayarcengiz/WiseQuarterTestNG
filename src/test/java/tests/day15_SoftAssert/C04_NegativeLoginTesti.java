package tests.day15_SoftAssert;

import Pages.QualitydemyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegativeLoginTesti {
    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin
    QualitydemyPage qualitydemyPage= new QualitydemyPage();

    @Test
    public void yanlisEmailTesti(){
        ReusableMethods.bekle(1);
        qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get("https://www.qualitydemy.com/");
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        qualitydemyPage.ilkLoginLinki.click();
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("31488081");
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.Loginkutusu.isDisplayed());
        Driver.closeDriver();
    }


    @Test
    public void yanlisPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        ReusableMethods.bekle(1);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.Loginkutusu.isDisplayed());
        Driver.closeDriver();

    }


    @Test
    public void yanlisEmailYanlisPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage= new QualitydemyPage();
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        ReusableMethods.bekle(2);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.Loginkutusu.isDisplayed());
        Driver.closeDriver();
    }

}
