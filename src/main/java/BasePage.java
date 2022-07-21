import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait1;


    /**Constructor*/
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait1 = new WebDriverWait(driver, 10);
    }

    /** Click Methods*/
    //Click
    public void click(By elementLocation) throws InterruptedException {
        int attempts = 0;
        WebElement element = wait1.until(visibilityOfElementLocated(elementLocation));
        while (attempts < 2) {
            try {
                element.click();
                System.out.println(" Click  "+(elementLocation));
                break;
            }
            catch (JavascriptException e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element);
                System.out.println("JavascriptException. Action click "+(elementLocation));
                break;
            }
            catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException "+(elementLocation));
            }
            attempts++;
        }
    }

    public void click2(By elementLocation) throws InterruptedException {
        int attempts = 0;
        WebElement element = wait1.until(elementToBeClickable(elementLocation));
        while (attempts < 2) {
            try {
                element.click();
                System.out.println(" Click  "+(elementLocation));
                break;
            }
            catch (ElementClickInterceptedException e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element);
                System.out.println("JavascriptException. Action click "+(elementLocation));
                break;
            }
            catch (Exception e) {
                System.out.println("Something wrong "+(elementLocation));
            }
            attempts++;
        }
    }

    /**Write Text*/
    public void writeText(By elementLocation, String text2) {
        try {
            driver.findElement(elementLocation).sendKeys(text2);
            System.out.println("write  "+text2+" to "+(elementLocation));
        }
        catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('type',arguments[1]);",
                    driver.findElement(elementLocation), "text");
            driver.findElement(elementLocation).sendKeys(text2);
            System.out.println("write  "+text2+" to "+(elementLocation));
        }
    }

    /**Read Text*/
    /*public String readMessage(By elementLocation){
        System.out.println("Popup: "+driver.findElement(elementLocation).getText());
        return driver.findElement(elementLocation).getText();
    }*/

    public String readMessage(By elementLocation){
        wait1.until(visibilityOfElementLocated(elementLocation));
        return driver.findElement(elementLocation).getText();
    }

    public Boolean readMessage2(By elementLocation, String text){
        Boolean result = wait1.until(ExpectedConditions.textToBePresentInElementLocated(elementLocation, text));
        return result;
    }






}
