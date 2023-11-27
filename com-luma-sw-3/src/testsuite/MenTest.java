package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //* Mouse Hover on Men Menu
        mouseHover(By.cssSelector("li[class='level0 nav-3 category-item level-top parent ui-menu-item']"));

        //* Mouse Hover on Bottoms
        Thread.sleep(1000);
        mouseHover(By.xpath("//a[@id='ui-id-18']"));

        //* Click on Pants
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"), By.id("option-label-size-143-item-175"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"), By.id("option-label-color-93-item-49"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"), By.xpath("(//button[@title='Add to Cart'])[1]"));

        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        assertionMethod("Text is not matched", expectedText, actualText);

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)'] a"));

        //* Verify the text ‘Shopping Cart.’
        Thread.sleep(500);
        String expected = "Shopping Cart";
        String actual = getTextFromElement(By.xpath("(//span[@class='base'])[1]"));
        assertionMethod("Text is not matched", expected, actual);

        //* Verify the product name ‘Cronus Yoga Pant’
        Thread.sleep(500);
        String expectedName = "Cronus Yoga Pant";
        String actualName = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        assertionMethod("Name is not matched", expectedName, actualName);

        //* Verify the product size ‘32’
        Thread.sleep(500);
        String expectedSize = "32";
        String actualSize = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        assertionMethod("Size is not matched", expectedSize, actualSize);

        //* Verify the product colour ‘Black’
        Thread.sleep(500);
        String expectedColour = "Black";
        String actualColour = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        assertionMethod("Colour is not matched", expectedColour, actualColour);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

