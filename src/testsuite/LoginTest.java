package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
        String baseUrl = "http://the-internet.herokuapp.com/login";

        @Before
        public void setUp() {
            openBroswer(baseUrl);
        }

        @Test
        public void UserSholdLoginSuccessfullyWithValidCredentials() {
            //Enter Valid Credentials
            sendTextElement(By.name("username"), "tomsmith");
            sendTextElement(By.name("password"), "SuperSecretPassword!");
            clickOnElement(By.xpath("//button[@type='submit']"));

            String expectedMessage = "Secure Area";
            String actualMessage = getTextFromElement(By.xpath("//h2[text()=' Secure Area']"));
            Assert.assertEquals("Secure Area", expectedMessage, actualMessage);
        }

        @Test
        public void verifyTheUsernameErrorMessage() {
            // Verify User name ErrorMessage
            sendTextElement(By.name("username"), "tomsmith1");
            sendTextElement(By.name("password"), "SuperSecretPassword!");
            clickOnElement(By.xpath("//button[@type='submit']"));

            String expectedErrorTextMessage = "Your username is invalid!";
            String actualErrorTextMessage = getTextFromElement(By.xpath("//div[@id='flash-messages']")).substring(0,25);
            //String test = actualErrorTextMessage.substring(0,25);
            Assert.assertEquals("Unexpected error happen",expectedErrorTextMessage, actualErrorTextMessage);

        }
        @Test
        public void verifyThePasswordErrorMessage() {
            // Verify the password Error Message
            sendTextElement(By.name("username"), "tomsmith");
            sendTextElement(By.name("password"), "SuperSecretPassword");
            clickOnElement(By.xpath("//button[@type='submit']"));

            String expectedErrorTextMessage = "Your password is invalid!";
            String actualErrorTextMessage = getTextFromElement(By.xpath("//div[@id='flash-messages']")).substring(0,25);
            //String test = actualErrorTextMessage.substring(0,25);
            Assert.assertEquals("Unexpected error happen",expectedErrorTextMessage, actualErrorTextMessage);

        }
    }

