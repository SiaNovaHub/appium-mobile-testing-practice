package ecomm_app_e2e;

import enums.Gender;
import org.testng.annotations.Test;
import pages.android.StartFormPage;
import sianova.BaseMethods;

public class eCommApp_StartForm extends BaseMethods {
    @Test
    public void FillFormSuccessfully() {
        StartFormPage startFormPage = new StartFormPage(driver);

        startFormPage.enterName("User Test");
        startFormPage.selectGender(Gender.FEMALE);
        startFormPage.selectCountry("Aruba");
        startFormPage.clickShopBtn();
    }
    @Test
    public void SendEmptyFormErrorToast() {
        StartFormPage startFormPage = new StartFormPage(driver);

        startFormPage.clickShopBtn();
        startFormPage.validateToastText("Please enter your name");
    }
}
