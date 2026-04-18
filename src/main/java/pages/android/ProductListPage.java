package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

public class ProductListPage extends AndroidActions {
    AndroidDriver driver;
    public ProductListPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
    private WebElement cartItemsCounter;

    private By productCardLocator(String productName) {
        return By.xpath("//android.widget.TextView[@text='" + productName + "']/parent::android.widget.LinearLayout");
    }

    private By addToCartButtonLocator() {
        return By.xpath(".//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']");
    }

    public void addProductToCart (String productName) {
        scrollIntoView(productName);

        WebElement productCard = driver.findElement(productCardLocator(productName));
        WebElement addToCartBtn = productCard.findElement(addToCartButtonLocator());

        addToCartBtn.click();
    }
    public void verifyAddToCartBtnLabelChanged (String productName, String expectedLabel) {
        WebElement productCard = driver.findElement(productCardLocator(productName));
        WebElement addToCartBtn = productCard.findElement(addToCartButtonLocator());

        Assert.assertEquals(addToCartBtn.getText(), expectedLabel);
    }
    public void verifyCartItemsCounter (int expectedCounter) {
        Assert.assertEquals(cartItemsCounter.getText(), Integer.toString(expectedCounter));
    }
    public void navigateToCart () {
        cartBtn.click();
    }
}
