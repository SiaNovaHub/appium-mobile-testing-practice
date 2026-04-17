package pages.android;

import enums.Gender;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

public class StartFormPage extends AndroidActions {
    AndroidDriver driver;
    public StartFormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver; //assigns driver from the test case to the local class
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement radioMale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement radioFemale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryDropDown;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopBtn;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    private WebElement errToast;

    public void enterName(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }
    public void selectGender(Gender gender) {
        switch (gender) {
            case MALE -> radioMale.click();
            case FEMALE -> radioFemale.click();
        }
    }
    public void selectCountry(String country) {
        countryDropDown.click();
        scrollIntoView(country);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"" + country + "\")")).click();
    }
    public void clickShopBtn() {
        shopBtn.click();
    }
    public void validateToastText(String expectedText) {
        String toastText = errToast.getAttribute("name");
        Assert.assertEquals(toastText, expectedText);
    }
}
