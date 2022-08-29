package screens;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.elements.TextField;
import base.waits.TypeWait;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.RandomUtils;
import java.util.List;

public class CityChoiceScreen extends BaseScreen {

    private static final By UNIQUE_ELEMENT = AppiumBy.id("com.zdv.secretcloset:id/lvSearchList");
    private final Button ok = getIFactory().getButton(AppiumBy.id("android:id/button1"), "allow", TypeWait.TO_BE_CLICKABLE);
    private List<Button> cities;
    private Button currentCity;

    public CityChoiceScreen() {
        super(new TextField(UNIQUE_ELEMENT, "search screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    public void allowAlert() {
        ok.click();
    }

    @Step("choose random city")
    public String getCitiesAndGetRandom() {
        cities = getIFactory().getButtons(
                AppiumBy.id("com.zdv.secretcloset:id/tvCityItemName"),
                "all cities",
                TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED);
        currentCity = cities.get(RandomUtils.getRandomNumber(cities.size()));
        return currentCity.getText();
    }

    public void clickOnCurrentCity() {
        currentCity.click();
    }
}