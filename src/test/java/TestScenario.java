import org.testng.annotations.Test;
import screens.CityChoiceScreen;
import screens.MainScreen;
import screens.ProductScreen;
import screens.SellerScreen;
import utils.StringUtils;
import java.util.List;

import static org.testng.Assert.*;

public class TestScenario extends BaseClass {

    @Test
    public void test() {
        MainScreen mainScreen = new MainScreen();
        mainScreen.openCityChoice();
        CityChoiceScreen cityChoiceScreen = new CityChoiceScreen();
        cityChoiceScreen.allowAlert();
        String currentCity = cityChoiceScreen.getCitiesAndGetRandom();
        cityChoiceScreen.clickOnCurrentCity();
        assertTrue(mainScreen.getCityName(currentCity), "City didn't choice");
        assertTrue(Integer.parseInt(StringUtils.splitString(mainScreen.getSumm(), " "))>Integer.parseInt(StringUtils.splitString(mainScreen.getPrice(), " ")), "price and discount didn't correct");
        mainScreen.clickOnProduct();
        ProductScreen productScreen = new ProductScreen();
        List<String> productData = productScreen.getSellerNameAndCity();
        productScreen.clickOnSeller();
        SellerScreen sellerScreen = new SellerScreen();
        assertEquals(sellerScreen.getNameAndCity(), productData, "seller name and city not correct");
    }
}