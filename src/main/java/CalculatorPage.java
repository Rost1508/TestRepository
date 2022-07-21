
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CalculatorPage extends BasePage {

    /**Constructor*/
    public CalculatorPage(WebDriver driver){
        super(driver);
    }

    By INPUT_FIELD = By.xpath("//input[@Id='number']");
    By CALCULATE_BUTTON = By.cssSelector("#getFactorial");
    By RESULT = By.xpath("//p[@id='resultDiv']");


    public CalculatorPage goToMainPage(){
        driver.navigate().to("https://qainterview.pythonanywhere.com/");
        return this;
    }

    public Boolean calculateFactorial(String value, String result) throws InterruptedException {
        click(INPUT_FIELD);
        writeText(INPUT_FIELD, value);
        click2(CALCULATE_BUTTON);
        //Thread.sleep(2000);
        Boolean answer = readMessage2(RESULT, result);
        return answer;
    }





}
