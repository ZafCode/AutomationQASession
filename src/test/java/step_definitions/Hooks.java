package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@firefox")) {
            Driver.setDriver("firefox");
        } else if (scenario.getSourceTagNames().contains("@chrome")) {
            Driver.setDriver("chrome");
        }
    }

    /**
     * This method will bee executed after every single scenario
     *
     * @param scenario comes from Cucumber library. Contains info about executed scenario.
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //1. cast driver object to TakesScreenshot object
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            //2. save screenshot as an array of bytes
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //3. attach screenshot to the report
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
