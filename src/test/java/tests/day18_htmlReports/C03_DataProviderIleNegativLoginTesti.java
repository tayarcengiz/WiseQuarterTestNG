package tests.day18_htmlReports;

import Pages.QualitydemyPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderIleNegativLoginTesti{
// Qualitydemy anasayfaya gidin
    // verilen yanlis kullanici adi ve password kombinasyonlari icin
    // giris yapilamadigini test edin
    // username     password
    // A11          A12345
    // B12          B12345
    // C13          C12345
    // D14          D12345
    // E15          E12345

    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        Object[][] kullaniciBilgileriArr=
                {{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};
        return kullaniciBilgileriArr;
    }

    @Test(dataProvider = "kullaniciBilgileri")
    public void negativeLoginTest(String username, String password){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        qualitydemyPage.ilkLoginLinki.click();
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);
        if (qualitydemyPage.Cookies.isDisplayed()) {
            qualitydemyPage.Cookies.click();
        }
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
    }

}
