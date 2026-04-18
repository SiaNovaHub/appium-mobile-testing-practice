package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;
    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private WebElement productName;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPricesInCart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    private WebElement termsToastTitle;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement closeToastBtn;

    public void verifyProductInCart(String expectedProductName) {
        productName.getText();
        Assert.assertEquals(productName, expectedProductName);
    }
    public void verifyDisplayTotalSumIsCorrect () {
        double totalSum = 0;
        for (int i = 0; i < productPricesInCart.size(); i++) {
            String priceString = productPricesInCart.get(i).getText();
            Double price = Double.parseDouble(priceString.substring(1)); //price is in format $120.0
            totalSum = totalSum + price;
        }
        String displaySum = totalAmount.getText();
        Double displaySumValue = Double.parseDouble(displaySum.substring(1));
        Assert.assertEquals(totalSum, displaySumValue);
    }
    public void openTermsOfConditions() {
        longPressAction(termsBtn);
    }
    public void verifyTermsOfConditionsAreVisible() {
        Assert.assertTrue(termsToastTitle.isDisplayed());
    }
    public void closeToast() {
        closeToastBtn.click();
    }

}
