package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        Thread.sleep(500);
        mouseHover(By.cssSelector("#ui-id-6"));

        //* Click on Bags
        Thread.sleep(500);
        clickOnElement(By.xpath("(//a[@id='ui-id-25'])[1]"));

        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        //* Verify the text ‘Overnight Duffle’
        Thread.sleep(500);
        String expected = "Overnight Duffle";
        String actual = getTextFromElement(By.cssSelector(".base"));
        assertionMethod("Text is not matched", expected, actual);

        //* Change Qty 3
        Thread.sleep(1000);
        clearTextField(By.id("qty"));
        sendTextToElement(By.id("qty"), "3");

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));

        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        Thread.sleep(500);
        String expectedText = "You added Overnight Duffle to your shopping cart.";
        String actualText = getTextFromElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        assertionMethod("Text is not matched", expectedText, actualText);

        //* Click on ‘shopping cart’ Link into message
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //* Verify the product name ‘Overnight Duffle’
        Thread.sleep(500);
        String expectedName = "Overnight Duffle";
        String actualName = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        assertionMethod("Name is not matched", expectedName, actualName);

        //* Verify the Qty is ‘3’
        Thread.sleep(1000);
        String expectedQty = "3";
        String actualQty = getTextFromElement(By.xpath("//span[@class='counter-number']"));
        assertionMethod("Qty is not matched", expectedQty, actualQty);

        //* Verify the product price ‘$135.00’
        Thread.sleep(500);
        String expectedPrice = "$135.00";
        String actualPrice = getTextFromElement(By.cssSelector("td[class='col subtotal'] span[class='price']"));
        assertionMethod("Price is not matched", expectedPrice, actualPrice);

        //* Change Qty to ‘5’
        Thread.sleep(1000);
        clearTextField(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input"));
        sendTextToElement(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input"), "5");

        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//button[@title='Update Shopping Cart']"));

        //* Verify the product price ‘$225.00'
        Thread.sleep(500);
        String expectedAmount = "$225.00";
        String actualAmount = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        assertionMethod("Price is not matched", expectedAmount, actualAmount);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

