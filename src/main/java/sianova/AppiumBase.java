package sianova;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AppiumBase extends BaseTest {
    @Test
    public void SetWifiSettings() throws URISyntaxException, MalformedURLException {
        //supported locators XPath, id, accessibilityID,classname,adroidUIAutomator
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Preference\")")).click();
    }
}
