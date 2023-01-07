package utilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /* Driver class'indan driver'i getDriver() ile kullaniyoruz
       Sonradan projeye katilan insanlarin Driver class'indan obje olusturarak
       driver kullanmaya calismalarini engellemek icin

       Driver class'ini SINGLETON PATERN ile duzenleyebiliriz

       Bunun icin Driver class'inin parametresiz constructor'ini olusturup
       access modifier'ini PRIVATE yapmamiz yeterli olur.
     */

    static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;

    }

    public static void closeDriver(){

        if (driver != null){
            driver.close();
            driver=null;
        }

    }

}
