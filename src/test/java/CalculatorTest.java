
import org.testng.Assert;
import org.testng.annotations.Test;



public class CalculatorTest extends BaseTest{

    @Test(priority = 1, description = "Send a valid value")
    public void testCalculator_validValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("5", "The factorial of 5 is: 120");
        Assert.assertTrue(result);
    }

    @Test(priority = 2, description = "Send a valid value")
    public void testCalculator_zeroValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("0", "The factorial of 0 is: 1");
        Assert.assertTrue(result);
    }

    @Test(priority = 3, description = "Send a valid value")
    public void testCalculator_oneValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("1", "The factorial of 1 is: 1");
        Assert.assertTrue(result);
    }

    @Test(priority = 4, description = "Send a valid value")
    public void testCalculator_maxCalculatedValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("170", "The factorial of 170 is: 7.257415615307999e+306");
        Assert.assertTrue(result);
    }

    @Test(priority = 5, description = "Send a valid value")
    public void testCalculator_infinityResult() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("171", "The factorial of 171 is: Infinity");
        Assert.assertTrue(result);
    }

    @Test(priority = 6, description = "Send a valid value")
    public void testCalculator_tooBigValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("99999999999", "The factorial of 99999999999 is: Infinity");
        Assert.assertTrue(result);
    }

    @Test(priority = 7, description = "Send a invalid value")
    public void testCalculator_nullValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("", "Please enter an integer");
        Assert.assertTrue(result);
    }

    @Test(priority = 8, description = "Send a invalid value")
    public void testCalculator_letterValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("f", "Please enter an integer");
        Assert.assertTrue(result);
    }

    @Test(priority = 9, description = "Send a invalid value")
    public void testCalculator_symbolicValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("%", "Please enter an integer");
        Assert.assertTrue(result);
    }

    @Test(priority = 10, description = "Send a invalid value")
    public void testCalculator_spaceValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial(" ", "Please enter an integer");
        Assert.assertTrue(result);
    }

    @Test(priority = 11, description = "Send a invalid value")
    public void testCalculator_minusValue() throws InterruptedException {
        Boolean result = calculatorPage.
                goToMainPage().
                calculateFactorial("-1", "Please enter an integer");
        Assert.assertTrue(result);
    }
}
