package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // * 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"), By.xpath("//a[normalize-space()='Desktops']"));

        // * 1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        selectMenu("Show AllDesktops");

        // * 1.3 Verify the text ‘Desktops’
        assertionMethod("Incorrect Text", "Desktops", By.xpath("//h2[normalize-space()='Desktops']"));
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"), By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        assertionMethod("Incorrect Text", "Laptops & Notebooks", By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Components']"), By.xpath("//a[normalize-space()='Components']"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

        //3.3 Verify the text ‘Components’
        assertionMethod("Incorrect Text", "Components", By.xpath("//h2[normalize-space()='Components']"));
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}

