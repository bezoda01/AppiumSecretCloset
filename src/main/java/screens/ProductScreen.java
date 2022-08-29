package screens;

import base.baseScreen.BaseScreen;
import base.elements.TextField;
import base.waits.TypeWait;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ProductScreen extends BaseScreen {

    private static final By UNIQUE_ELEMENT = AppiumBy.id("com.zdv.secretcloset:id/rlBasicInfo");
    private final TextField seller = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerName"), "seller", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);
    private final TextField city = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);

    public ProductScreen() {
        super(new TextField(UNIQUE_ELEMENT, "product screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    @Step("get seller name and city in product screen")
    public List<String> getSellerNameAndCity() {
        List<String> data = new ArrayList<>();
        data.add(seller.getText());
        data.add(city.getText());
        return data;
    }

    public void clickOnSeller() {
        seller.click();
    }
}