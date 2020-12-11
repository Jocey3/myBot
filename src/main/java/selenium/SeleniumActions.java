package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumActions {
    WebDriver driver;

    SeleniumActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
