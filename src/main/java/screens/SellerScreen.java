package screens;

import base.baseScreen.BaseScreen;
import base.elements.TextField;
import base.waits.TypeWait;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SellerScreen extends BaseScreen {

    private static final By UNIQUE_ELEMENT = AppiumBy.id("com.zdv.secretcloset:id/textMemberTitle");
    private final TextField name = getIFactory().getTextField(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.zdv.secretcloset:id/toolbar']//android.widget.TextView"), "seller name", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);
    private final TextField city = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);

    public SellerScreen() {
        super(new TextField(UNIQUE_ELEMENT, "seller screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    @Step("get seller name and city in seller screen")
    public List<String> getNameAndCity() {
        List<String> data = new ArrayList<>();
        data.add(name.getText());
        data.add(city.getText());
        return data;
    }
}