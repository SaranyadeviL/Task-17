package Task;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDeal {
    public static void main(String[] args) {
        //initialize the driver
        WebDriver driver = new ChromeDriver();

        try {
            //2. Navigate the snapdeal website
            driver.get("http://www.snapdeal.com");

            // 3. Move thr cursor to the signin button and hold it
            Actions actions = new Actions(driver);
            WebElement signInButton = driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"));
            actions.moveToElement(signInButton).perform();

            //4. click on sign in button
            WebElement login = driver.findElement(By.xpath("//a[@href='https://www.snapdeal.com/login']"));
            login.click();

            //5. Enter a valid email Id in the email field
            WebElement emailField = driver.findElement(By.id("UserName"));
            emailField.sendKeys("dummyemail@gmail.com");

            //6. click on continue button
            WebElement cButton = driver.findElement(By.id("checkUser"));
            cButton.click();

            //7.enter the valid pwd in the pwd field
            WebElement pField = driver.findElement(By.id("j_password_login_uc"));
            pField.sendKeys("dummyPassword");

            //8.click on the login button
            WebElement SubButton = driver.findElement(By.id("submitLoginUC"));
            SubButton.click();

            //9. verify that the user loggedin successfully and print the verification message in console
            WebElement accName = driver.findElement(By.xpath("//span[contains(@class,'accountUserName')]"));

            if (accName.isDisplayed()) {
                System.out.println("Login Successfully ! Welcome ," + accName.getText());
            } else {
                System.out.println("Login Failed");
            }
            }catch (Exception e){
            e.printStackTrace();
            } finally {
            // close the browser
            driver.quit();
        }
    }
}
