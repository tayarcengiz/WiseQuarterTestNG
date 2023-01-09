package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Facebook {
    public Facebook(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath ="//*[text()='Temel ve isteğe bağlı çerezlere izin ver']" )
    public WebElement FacebookCookies;



}
