package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * This method will click on any element whatever locator you're passing
     */
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /*
     * This method will get text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    /*
     * This method will get text on element
     */
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /*
     *Assertion method
     */
//    public void assertionMethod(String message, String expectedText, String actualText) {
//        Assert.assertEquals(message, expectedText, actualText);
//    }
    public void assertionMethod(String message, String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(" ", expected, actual);
    }

    //****************************************** Select Method ****************************************************8//
    /*
     *This method will return or select text from drop down menu
     */
    public void selectByVisibleFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        //create an object of select class
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /*
     * This Method will return to select value from drop down menu select class is there
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //create an object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);

    }

    /*
     * This Method will return ot select value from drop down menu when select class is not there
     */
    public void manageElementList(By by, String text) {
        List<WebElement> manageList = driver.findElements(by);
        for (WebElement element : manageList) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
//        public void selectMenu(String menu) {
//        List<WebElement> elementList = driver.findElements(By.name("menu"));
//        for (WebElement element : elementList) {
//            if (element.getText().equalsIgnoreCase(menu)) {
//                element.click();
//                break;
//            }
//        }
//    }
            }
        }
    }

    /*
     * This Method will verify the number of products on display
     */
    public void productElement(By by) {
        List<WebElement> productsElement = driver.findElements(by);
        System.out.println("Total number of products on display are: " + productsElement.size());
    }


    /*
     * This Method will return ot select value from drop down menu
     */
    public void selectByIndexFromDropDown(By by, int value) {
        WebElement dropDown = driver.findElement(by);
        //create an object of select class
        Select select = new Select(dropDown);
        select.selectByIndex(value);
    }

    /*
     *Clear method to clear the text
     */
    public void clearTextField(By by) {
        driver.findElement(by).clear();
    }


    //****************************************** MouseHover Method*********************************************************//
    /*
     * This is mouse hover method
     */
    public void mouseHoverToElement(By by, By by1) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by1)).click().build().perform();
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();

    }

    /*
     *Action method for click on top menu tab
     */
    public void selectMenu(String menu) {
        WebElement menuList = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
    }


    // Navigate to the specified month and year in the datePicker
    public static void selectDate(By by, String targetDate) {
        List<WebElement> allDates = driver.findElements(by);
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(targetDate)) {
                dt.click();
                break;
            }
        }
    }

}

