package screens;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.elements.TextField;
import base.waits.TypeWait;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainScreen extends BaseScreen {

    private static final By UNIQUE_ELEMENT = AppiumBy.id("com.zdv.secretcloset:id/rlTop");
    private final Button city = getIFactory().getButton(AppiumBy.id("com.zdv.secretcloset:id/tvToolbarCity"), "city choice", TypeWait.TO_BE_CLICKABLE);
    private final String currentProductLocator = "//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvDiscount']//ancestor::android.widget.RelativeLayout[@resource-id='com.zdv.secretcloset:id/rlBanner']";

    public MainScreen() {
        super(new TextField(UNIQUE_ELEMENT,"main screen"));
    }

    public void openCityChoice() {
        city.click();
    }

    @Step("Check city {0} was select")
    public boolean getCityName(String currentCity) {
        return getIFactory().getTextField(
                AppiumBy.androidUIAutomator("resourceId(\"com.zdv.secretcloset:id/tvToolbarCity\").text(\""+currentCity+"\")"),
                "city choice",
                TypeWait.PRESENCE_OF_ELEMENT_LOCATED).isEnabled();
    }

    public String getSumm() {
        return getIFactory().getTextFields(AppiumBy.xpath(currentProductLocator+"//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvSumm']"), "summ", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED).get(0).getText();
    }

    public String getPrice() {
        return getIFactory().getTextFields(AppiumBy.xpath(currentProductLocator+"//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvPrice']"), "price", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED).get(0).getText();
    }

    public void clickOnProduct() {
        getIFactory().getTextFields(AppiumBy.xpath(currentProductLocator), "current product", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED).get(0).click();
    }
}