package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.UUID;

public class MyAccountsTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class = 'list-inline']//a"));
        for (WebElement list : options) {
            if (option.equalsIgnoreCase(list.getText())) {
                list.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account
        assertionMethod("Incorrect Text", "Register Account", By.xpath("//h1[normalize-space()='Register Account']"));

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        // 2.3 Verify the text “Returning Customer”.
        assertionMethod("Incorrect Text", "Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"));
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //3.3 Enter First Name
        sendTextToElement(By.name("firstname"), "Michel");

        //3.4 Enter Last Name
        sendTextToElement(By.name("lastname"), "Jackson");

        //3.5 Enter Email
        final String randomEmail = randomEmail();
        sendTextToElement(By.name("email"), randomEmail);

        //3.6 Enter Telephone
        sendTextToElement(By.name("telephone"), "0123456789");

        //3.7 Enter Password
        sendTextToElement(By.name("password"), "mkjk12");

        //3.8 Enter Password Confirm
        sendTextToElement(By.name("confirm"), "mkjk12");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("(//input[@name='newsletter'])[1]"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        assertionMethod("Incorrect Message", "Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //3.16 Verify the text “Account Logout”
        assertionMethod("Incorrect Text", "Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"));

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "mkjk@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.id("input-password"), "mkjk12");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        Thread.sleep(2000);

        //4.7 Verify text “My Account”
        assertionMethod("Incorrect Text", "My Account", By.xpath("//h2[text()='My Account']"));

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        assertionMethod("Incorrect Text", "Account Logout", By.xpath("//h1[text()='Account Logout']"));

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }

    private String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

