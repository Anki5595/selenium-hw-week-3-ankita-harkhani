package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class DesktopsTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"), By.xpath("//a[normalize-space()='Desktops']"));

        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleFromDropDown(By.id("input-sort"), "Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        assertionMethod("Products are not in Descending order", "Name (Z - A)", By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Currency Dropdown and click
        mouseHoverToElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']"), By.xpath("//button[@class='btn btn-link dropdown-toggle']"));

        //2.2 Mouse hover on £Pound Sterling and click
        mouseHoverToElement(By.xpath("//button[normalize-space()='£Pound Sterling']"), By.xpath("//button[normalize-space()='£Pound Sterling']"));

        //2.3 Mouse hover on Desktops Tab.
        mouseHover(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

        //2.4 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //2.5 Select Sort By position "Name: A to Z"
        Thread.sleep(1000);
        selectByVisibleFromDropDown(By.id("input-sort"), "Name (A - Z)");

        //2.6 Select product “HP LP3065”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));

        //2.7 Verify the Text "HP LP3065"
        Thread.sleep(1000);
        assertionMethod("Text are not same", "HP LP3065", By.xpath("//a[normalize-space()='HP LP3065']"));

        //2.8 Select Delivery Date "2023-11-27"
//        clearTextField(By.xpath("//input[@id='input-option225']"));
//        sendTextToElement(By.xpath("//input[@id='input-option225']"), "2023-11-27");
//        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']"));
//        selectDate(By.xpath("//div[@class='datepicker']"), "27-11-2023");

        String year = "2027";
        String month = "November";
        String date = "23";

        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); // open the calendar
        while (true) {
            //inspect April 2021
            String monthYear = getTextFromElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'picker-switch']"));
            System.out.println(monthYear);
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'next']"));
            }
        }

        //2.9.Enter Qty "1” using Select class.
        clearTextField(By.name("quantity"));
        sendTextToElement(By.name("quantity"), "1");

        //2.10 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        assertionMethod("Incorrect Message", "Success: You have added HP LP3065 to your shopping cart!\n×",
                By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.12 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // * 2.13 Verify the text "Shopping Cart  (1.00kg)"
        assertionMethod("Wrong Text", "Shopping Cart  (1.00kg)",
                By.xpath("//h1[contains(text(),'Shopping Cart')]"));

        // * 2.14 Verify the Product name "HP LP3065"
        assertionMethod("Incorrect Product Name", "HP LP3065",
                By.xpath("(//a[contains(text(),'HP LP3065')])[2]"));

        // * 2.15 Verify the Delivery Date "2023-11-27"
        assertionMethod("Incorrect Date", "Delivery Date:2023-11-27",
                By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']"));

        // * 2.16 Verify the Model "Product 21"
        assertionMethod("Incorrect Model", "Product 21", By.xpath("//td[normalize-space()='Product 21']"));

        // * 2.17 Verify the Total "£74.73"
        assertionMethod("Incorrect Price", "£74.73", By.xpath("(//td[contains(text(),'£74.73')])[4]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
