package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[@class='master-wrapper-page']/div[@class='header-menu']/ul[@class='top-menu notmobile']/li[1]"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleFromDropDown(By.id("products-orderby"), "Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        String expectedResult = "Name: Z to A";
        String actualResult = getTextFromElement(By.xpath("//option[text()='Name: Z to A']"));
        assertionMethod("The products are not in order", expectedResult, actualResult);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[@class='master-wrapper-page']/div[@class='header-menu']/ul[@class='top-menu notmobile']/li[1]"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));

        //1.3 Select Sort By position "Name: A to Z"
        selectByVisibleFromDropDown(By.id("products-orderby"), "Name: A to Z");

        //2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[text() = 'Build your own computer']"));

        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        assertionMethod("Text dose not match", expectedText, actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_4_9"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_5_12"));
        //  manageElementList(By.id("product_attribute_5_10"), "Microsoft Office [+$50.00]");
        // manageElementList(By.id("product_attribute_5_12"), "Total Commander [+$5.00]");

        //2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        String expectedValue = "$1,475.00";
        String actualValue = getTextFromElement(By.id("price-value-1"));
        assertionMethod("The value is not same", expectedValue, actualValue);

        //2.12 Click on "ADD TO CARD" Button
        clickOnElement(By.id("add-to-cart-button-1"));

        //2.13 Verify the Message "The product has been added to your shopping cart"
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        assertionMethod("Message is not same", expectedMessage, actualMessage);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"), By.xpath("//button[normalize-space()='Go to cart']"));

        //2.15 Verify the message "Shopping cart"
        Thread.sleep(500);
        String expectedMsg = "Shopping cart";
        String actualMsg = getTextFromElement(By.cssSelector("div[class='page-title'] h1"));
        assertionMethod("Message is not match", expectedMsg, actualMsg);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        //Change the Qty to "2"
        clearTextField(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Thread.sleep(2000);
        //Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        Thread.sleep(500);
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        assertionMethod("Total is not Matched", expectedTotal, actualTotal);

        //2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedText1 = "Welcome, Please Sign In!";
        String actualText1 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        assertionMethod("text are not same", expectedText1, actualText1);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //2.22 Fill the all mandatory field
        //First Name
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Michel");
        //Last name
        sendTextToElement(By.name("BillingNewAddress.LastName"), "Jackson");
        //Email
        sendTextToElement(By.name("BillingNewAddress.Email"), "micheljackson@gmail.com");
        //Country
        selectByVisibleFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        //City
        sendTextToElement(By.id("BillingNewAddress_City"), "Junagadh");
        //Address1
        sendTextToElement(By.name("BillingNewAddress.Address1"), "Bhavnath");
        //Zip/Pin code
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "354620");
        //Phone number
        sendTextToElement(By.cssSelector("#BillingNewAddress_PhoneNumber"), "0987654321");

        //2.23 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.name("save"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("(//div[@class='method-name'])[2]"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//label[normalize-space()='Credit Card']"));

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");

        //2.28 Fill all the details
        //CardholderName
        sendTextToElement(By.name("CardholderName"), "Michel Jackson");
        //CardNumber
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        //ExpiryDate
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"), 5);
        selectByValueFromDropDown(By.id("ExpireYear"), "2030");
        //CardCode
        sendTextToElement(By.name("CardCode"), "000");

        //2.29 Click on “CONTINUE
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedMethod = "Credit Card";
        String actualMethod = getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
        assertionMethod("Payment method is not Credit Card", expectedMethod, actualMethod);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        assertionMethod("Payment shipping method is not Credit Card", expectedShippingMethod, actualShippingMethod);

        //2.33 Verify Total is “$2,950.00”
        String expectedTotal1 = "$2,950.00";
        String actualTotal1 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        assertionMethod("The total is not same", expectedTotal1, actualTotal1);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank You”
        Thread.sleep(1000);
        String expected = "Thank you";
        String actual = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        assertionMethod("The text are not matched", expected, actual);

        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedMessage1 = "Your order has been successfully processed!";
        String actualMessage1 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        assertionMethod("Message is not same", expectedMessage1, actualMessage1);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.38 Verify the text “Welcome to our store”
        Thread.sleep(1000);
        String expected1 = "Welcome to our store";
        String actual1 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        assertionMethod("the text are not same", expected1, actual1);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}

