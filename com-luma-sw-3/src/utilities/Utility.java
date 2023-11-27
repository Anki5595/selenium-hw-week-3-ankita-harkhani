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
    public void clickOnElement(By by) {
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
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /*
     *Assertion method
     */
    public void assertionMethod(String message, String expectedText, String actualText) {
        Assert.assertEquals(message, expectedText, actualText);
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
     * This Method will return ot select value from drop down menu
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //create an object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);

    }

    public void manageElementList(By by, String text) {
        List<WebElement> manageList = driver.findElements(by);
        for (WebElement element : manageList) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
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

}


