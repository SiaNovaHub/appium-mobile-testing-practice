//package sianova.util_methods;
//
//import com.google.common.collect.ImmutableMap;
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebElement;
//
//public class MobileActions {
//    public AndroidDriver driver;
//
//    public void longPressAction(WebElement element) {
//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "duration", 2000));
//    }
//    public void scrollIntoView(String elementText) {
//        driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
//    }
//    public void swipeGesture (WebElement element, String direction) {
//        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "direction", direction,
//                "percent", 0.75));
//}
