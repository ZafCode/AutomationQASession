package step_definitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utils.Driver;

public class LoginStepDefs {

    public void popup(){
        Driver.getDriver().findElement(By.id("")).getCssValue("color");
    }

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        Driver.getDriver().get("http://google.com");
    }
}
