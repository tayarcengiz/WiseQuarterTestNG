package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {

    public QualitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(xpath="//*[@id='login-email']")
    public WebElement kullaniciEmailKutusu;

    @FindBy(id="login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement loginButonu;

    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public WebElement Cookies;

    @FindBy(xpath = "//*[@class='row mb-5 mt-3']")
   public WebElement Loginkutusu;




    @FindBy(linkText = "My courses")
    public WebElement basariliGirisCoursesLinki;


}
