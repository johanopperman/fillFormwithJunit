import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertEquals;

public class fillFormwithJunit {
    private static WebDriver driver;
    @BeforeClass
    public static void openBrowser() {
        driver = new ChromeDriver();
    }
    @Test
    public void userName() {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
            String Title = driver.getTitle();
            System.out.println("I am at " + Title);
            WebElement usernameInput;
            usernameInput = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[1]/td/input"));
            String ThisIsMyUsername = "jack";
            usernameInput.sendKeys(ThisIsMyUsername);

            WebElement passwordInput;
            passwordInput = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[2]/td/input"));
            String ThisIsMyPassword = "12345";
            passwordInput.sendKeys(ThisIsMyPassword);

            WebElement TextAreaCommentInput;
            TextAreaCommentInput = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea"));
            TextAreaCommentInput.clear();
            String ThisIsMyComment = "I am adding my comments here. I am adding my comments here. I am adding my comments here. I am adding my comments here";
            TextAreaCommentInput.sendKeys(ThisIsMyComment);

            WebElement submitButton;
            submitButton = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]"));

            submitButton.click();

            String NewTitle = driver.getTitle();
            System.out.println("I am at " + NewTitle);

            String userNameOutcome;
            userNameOutcome = driver.findElement(By.xpath("//*[@id=\"_username\"]/ul/li")).getText();
            assertEquals ("Expect username on next page", ThisIsMyUsername,userNameOutcome);

            String passwordResults;
            passwordResults = driver.findElement(By.xpath("//*[@id=\"_valuepassword\"]")).getText();
            assertEquals("Expect username on next page", ThisIsMyPassword, passwordResults);

            String commentResults;
            commentResults = driver.findElement(By.xpath("//*[@id=\"_valuecomments\"]")).getText();
            assertEquals("Expect username on next page", ThisIsMyComment, commentResults);


    }
    @AfterClass
    public static  void quitDriver(){
        driver.quit();
    }
}