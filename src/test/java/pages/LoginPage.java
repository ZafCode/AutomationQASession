package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {

    @FindBy(id = "password")
    public WebElement passwordElement;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public By passwordBy = By.id("password");
    public By userNameBy = By.id("email");

}
