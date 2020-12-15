package selenium;

import menu.settings.ManageSettingsFile;
import menu.settings.SettingsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumActions {
    private WebDriver driver;
    private List<String> wasPurshed = new ArrayList<String>();
    private String accID;
    private SettingsData settingsData = getSettingsData();

    SeleniumActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private SettingsData getSettingsData() {
        ManageSettingsFile manageSettingsFile = new ManageSettingsFile();
        return manageSettingsFile.getSettingsData();
    }

    public void signIn() {
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"input_username\"]"));
        loginField.sendKeys(settingsData.userName);
        WebElement passField = driver.findElement(By.xpath("//*[@id=\"input_password\"]"));
        passField.sendKeys(settingsData.pass);
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login_btn_signin\"]/button"));
        loginBtn.click();
        WebElement guardField = driver.findElement(By.xpath("//*[@id=\"twofactorcode_entry\"]"));
        String code = JOptionPane.showInputDialog("Please input code: ");
        guardField.sendKeys(code);
        WebElement guardBtn = driver.findElement(By.xpath("//*[@id=\"login_twofactorauth_buttonset_entercode\"]/div[1]"));
        guardBtn.click();
        getAccId();
    }

    private void getAccId() {
        WebElement pan = driver.findElement(By.xpath("//*[@id=\"account_pulldown\"]"));
        pan.click();
        WebElement prof = driver.findElement(By.xpath("//*[@id=\"account_dropdown\"]/div/a[1]"));
        prof.click();
        String code = driver.getPageSource();
        Pattern pattern = Pattern.compile("g_steamID = \"(\\d*)\";");
        Matcher matcher = pattern.matcher(code);
        if (matcher.find()) accID = matcher.group(1);
    }


}
