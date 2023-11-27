package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.UUID;

public class ElectronicsTest extends Utility {
    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        // 1.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(500);
        mouseHoverToElement(By.xpath("(//a[normalize-space()='Cell phones'])[1]"), By.xpath("(//a[normalize-space()='Cell phones'])[1]"));

        // 1.3 Verify the text “Cell phones”
        Thread.sleep(1000);
        String expected = "Cell phones";
        String actual = getTextFromElement(By.cssSelector("div[class='page-title'] h1"));
        assertionMethod("The text are not matched", expected, actual);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(500);
        mouseHoverToElement(By.xpath("(//a[normalize-space()='Cell phones'])[1]"), By.xpath("(//a[normalize-space()='Cell phones'])[1]"));

        //2.3 Verify the text “Cell phones”
        Thread.sleep(1000);
        String expected = "Cell phones";
        String actual = getTextFromElement(By.cssSelector("div[class='page-title'] h1"));
        assertionMethod("The text are not matched", expected, actual);

        //2.4 Click on List View Tab
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[normalize-space()='List']"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.linkText("Nokia Lumia 1020"));

        //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(1000);
        String expectedText = "Nokia Lumia 1020";
        String actualText = getTextFromElement(By.cssSelector("div[class='product-name'] h1"));
        assertionMethod("The text are not matched", expectedText, actualText);

        //2.7 Verify the price “$349.00”
        Thread.sleep(1000);
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        assertionMethod("The Price is not same", expectedPrice, actualPrice);

        //2.8 Change quantity to 2
        clearTextField(By.id("product_enteredQuantity_20"));
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        assertionMethod("The Price is not same", expectedMessage, actualMessage);
        // close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(500);
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"), By.xpath("//button[normalize-space()='Go to cart']"));

        //2.12 Verify the message "Shopping cart"
        Thread.sleep(500);
        String expectedMsg = "Shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        assertionMethod("Message is not matched", expectedMsg, actualMsg);

        //2.13 Verify the quantity is 2
        Thread.sleep(500);
        String expectedQuantity = "2";
        String actualQuantity = driver.findElement(By.xpath("//input[@class = 'qty-input']")).getAttribute("value");
        assertionMethod("Incorrect quantity", expectedQuantity, actualQuantity);

        //2.14 Verify the Total $698.00
        Thread.sleep(500);
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        assertionMethod("Total is not matched", expectedTotal, actualTotal);

        //2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));

        //2.16 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.name("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(500);
        String expectedTxt = "Welcome, Please Sign In!";
        String actualTxt = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        assertionMethod("Text is not matched", expectedTxt, actualTxt);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //2.19 Verify the text “Register”
        Thread.sleep(500);
        String expectedText1 = "Register";
        String actualText1 = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        assertionMethod("Text is not matched", expectedText1, actualText1);

        //2.20 Fill the mandatory fields
        //click on radio button
        clickOnElement(By.xpath("//span[@class='male']"));
        //FirstName
        sendTextToElement(By.name("FirstName"), "Michel");
        //LastName
        sendTextToElement(By.id("LastName"), "Jackson");
        //Date of Birth
        selectByIndexFromDropDown(By.name("DateOfBirthDay"), 5);
        selectByVisibleFromDropDown(By.name("DateOfBirthMonth"), "May");
        selectByValueFromDropDown(By.name("DateOfBirthYear"), "1995");
        //Email
        //Generate A random Email
        final String randomEmail = randomEmail();
        sendTextToElement(By.name("Email"), randomEmail);
        //Password
        sendTextToElement(By.xpath("//input[starts-with(@id, 'Password')]"), "1234560");
        //ConfirmPassword
        sendTextToElement(By.xpath("//input[starts-with(@id, 'ConfirmPassword')]"), "1234560");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.name("register-button"));

        //2.22 Verify the message “Your registration completed”
        String expectedMessage1 = "Your registration completed";
        String actualMessage1 = getTextFromElement(By.xpath("//div[text()='Your registration completed']"));
        assertionMethod("Message is not matched", expectedMessage1, actualMessage1);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //2.24 Verify the text “Shopping cart”
        String expectedTxt1 = "Shopping cart";
        String actualTxt1 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        assertionMethod("Text is not matched", expectedTxt1, actualTxt1);

        //Login again
        clickOnElement(By.linkText("Log in"));

        //Verify the Text "Welcome, Please Sign In!"
        Thread.sleep(1000);
        String expectedWelcomeText = "Welcome, Please Sign In!";
        String actualWelcomeText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        assertionMethod("Incorrect Welcome Text!", expectedWelcomeText, actualWelcomeText);
        Thread.sleep(1000);

        //Enter Email into the email field
        Thread.sleep(2000);
        sendTextToElement(By.id("Email"), randomEmail);

        //Enter Password into the password field
        Thread.sleep(2000);
        sendTextToElement(By.name("Password"), "1234560");

        //Click on Login button
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
        selectByVisibleFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        //City
        sendTextToElement(By.id("BillingNewAddress_City"), "Junagadh");
        //Address1
        sendTextToElement(By.name("BillingNewAddress.Address1"), "Bhavnath");
        //Zip/Pin code
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "354620");
        //Phone number
        sendTextToElement(By.cssSelector("#BillingNewAddress_PhoneNumber"), "0987654321");

        //2.28 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.name("save"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("(//div[@class='method-name'])[3]"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//label[normalize-space()='Credit Card']"));
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

        //2.33 Fill all the details
        //CardholderName
        sendTextToElement(By.name("CardholderName"), "Michel Jackson");
        //CardNumber
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        //ExpiryDate
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"), 5);
        selectByValueFromDropDown(By.id("ExpireYear"), "2030");
        //CardCode
        sendTextToElement(By.name("CardCode"), "000");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedMethod = "Credit Card";
        String actualMethod = getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
        assertionMethod("Payment method is not Credit Card", expectedMethod, actualMethod);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//span[normalize-space()='2nd Day Air']"));
        assertionMethod("Payment shipping method is not Credit Card", expectedShippingMethod, actualShippingMethod);

        //2.37 Verify Total is “$698.00”
        String expectedTotal1 = "$698.00";
        String actualTotal1 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        assertionMethod("The total is not same", expectedTotal1, actualTotal1);

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.39 Verify the Text “Thank You”
        Thread.sleep(1000);
        String expected1 = "Thank you";
        String actual1 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        assertionMethod("The text are not matched", expected1, actual1);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMsg1 = "Your order has been successfully processed!";
        String actualMsg1 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        assertionMethod("Message is not same", expectedMsg1, actualMsg1);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.42 Verify the text “Welcome to our store”
        Thread.sleep(1000);
        String expectedResult = "Welcome to our store";
        String actualResult = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        assertionMethod("the text are not same", expectedResult, actualResult);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("(//a[normalize-space()='Log out'])[1]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/"
        Thread.sleep(1000);
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        assertionMethod("the text are not same", expectedUrl, actualUrl);
        System.out.println("Current Url: " + baseUrl);
    }

    private String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
