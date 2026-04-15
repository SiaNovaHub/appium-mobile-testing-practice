package sianova;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
//import sianova.util_methods.MobileActions;

public class AppiumBase extends BaseTest {
    @Test
    public void SetWifiSettings() {
        //supported locators XPath, id, accessibilityID,classname,adroidUIAutomator
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Preference\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"3. Preference dependencies\")"))
                .click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String popUpText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(popUpText, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Test Wifi");
        driver.findElement(By.id("android:id/button1")).click();
    }
    @Test
    public void LongPressMenuValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Expandable Lists\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"1. Custom Adapter\")")).click();

        WebElement peopleNamesElement = driver.findElement(
                new AppiumBy.ByAndroidUIAutomator("text(\"People Names\")"));
        //longPressAction(peopleNamesElement);
        String longPressMenuTitle = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(longPressMenuTitle, "Sample menu");
        Assert.assertTrue(driver.findElement(
                new AppiumBy.ByAndroidUIAutomator("text(\"Sample menu\")")).isDisplayed());
    }
    @Test
    public void ScrollValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        //scrollIntoView("WebView");
    }
    @Test
    public void SwipeValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Gallery\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"1. Photos\")")).click();
        WebElement firstImage = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "className(\"android.widget.ImageView\").instance(0)"));
        String isFocusable = firstImage.getAttribute("focusable");
        Assert.assertEquals(isFocusable, "true");
        swipeGesture(firstImage, "left");
        isFocusable = firstImage.getAttribute("focusable");
        Assert.assertEquals(isFocusable, "false");
    }
    @Test
    public void DragDropValidation() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Drag and Drop\")")).click();

        WebElement firstElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement secondElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));

        dragAndDropGesture(firstElement,secondElement);
        WebElement resultElement = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertTrue(resultElement.isDisplayed());
        Assert.assertEquals(resultElement.getText(), "Dropped!");
    }
}
