package sianova;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
//import sianova.util_methods.MobileActions;

public class BaseApp extends BaseMethods {
    @Test
    public void SetWifiSettings() {
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
    public void DragDropValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Drag and Drop\")")).click();

        WebElement firstElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement secondElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));

        dragAndDropGesture(firstElement,secondElement);
        WebElement resultElement = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertTrue(resultElement.isDisplayed());
        Assert.assertEquals(resultElement.getText(), "Dropped!");
    }
    @Test
    public void LandscapePopupValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"App\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Alert Dialogs\")")).click();
        driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();

        DeviceRotation landscape = new DeviceRotation(0, 0, 90);
        driver.rotate(landscape);

        WebElement popUpHeader = driver.findElement(By.id("android:id/alertTitle"));
        Assert.assertTrue(popUpHeader.isDisplayed());

        String popUpText = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(popUpText,
                "Plloaso mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno." +
                        " Whag schengos, uf efed, quiel ba mada su otrenzr.\n\n" +
                        "Swipontgwook proudgs hus yag su ba dagarmidad. Plasa maku noga wipont trenzsa schengos " +
                        "ent kaap zux comy.\n\nWipont trenz kipg naar mixent phona. Cak pwico siructiun " +
                        "ruous nust apoply tyu cak Uhex sisulutiun munityuw uw dseg");
        driver.findElement(By.id("android:id/button3")).click();
    }
    @Test
    public void ClipboardValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Preference\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"3. Preference dependencies\")"))
                .click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String popUpText = driver.findElement(By.id("android:id/alertTitle")).getText();
        driver.setClipboardText(popUpText);
        Assert.assertEquals(popUpText, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        Assert.assertEquals(driver.findElement(By.id("android:id/edit")).getText(), popUpText);
        driver.findElement(By.id("android:id/button1")).click();
    }
    @Test
    public void BackNavigationValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Preference\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"3. Preference dependencies\")"))
                .click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Assert.assertTrue(driver.findElement(
                new AppiumBy.ByAndroidUIAutomator("text(\"3. Preference dependencies\")"))
                .isDisplayed());
    }
}
