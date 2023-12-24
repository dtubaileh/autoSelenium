import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constants;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


public class SearchTests extends  BaseSetup{


    public SearchTests(){

    }

    @DataProvider
    public static Collection searchOptions() {
        return Arrays.asList(new Object[][] {
            { "Shirt", true },
            { "Blouse", true },
            { "Dress", true },
            { "", false },
            { "test", true }
        });
    }

    @Test(dataProvider = "searchOptions" )
    public void testingSearch(String inputString, Boolean expectedResult){
        driver.get(Constants.URL);
        assertEquals(expectedResult, homePage.searchElement(inputString));
    }


}
