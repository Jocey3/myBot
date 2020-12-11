package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumManage {
    WebDriver driver;
    SeleniumActions selActions;

    public SeleniumManage(){
        openChromeDriver();
    }

    private void openChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/ch_dr/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://steamcommunity.com/login/home/?goto=");
        selActions = new SeleniumActions(driver);

    }
}
