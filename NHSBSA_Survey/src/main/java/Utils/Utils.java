package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {

    public static WebDriver driver;

    public static void initDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start");
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
    }

}


