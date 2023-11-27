package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    static String baseUrl = " https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() throws InterruptedException {
        //* Enter “standard_user” username
        sendTextToElement(By.name("user-name"), "standard_user");

        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        //* Click on ‘LOGIN’ button
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("#login-button"));

        //* Verify the text “PRODUCTS”
        Thread.sleep(1000);
        String expected = "Products";
        String actual = getTextFromElement(By.xpath("//span[@class='title']"));
        assertionMethod("The text are not matched", expected, actual);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //* Enter “standard_user” username
        sendTextToElement(By.name("user-name"), "standard_user");

        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        //* Click on ‘LOGIN’ button
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("#login-button"));

        //* Verify that six products are displayed on page
        productElement(By.className("inventory_item"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

