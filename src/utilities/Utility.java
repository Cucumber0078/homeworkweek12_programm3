package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

    public class Utility extends BaseTest {
        /**
         * this methis will click on element
         */
        public void clickOnElement(By by){
            WebElement loginLink = driver.findElement(by);
            loginLink.click();
        }
        public void sendTextElement(By by,String text){
          // WebElement dataField = driver.findElement(by);
            driver.findElement(by).sendKeys(text);

        }
        public String getTextFromElement(By by){
            WebElement actualTextMessageElement = driver.findElement(by);
            return actualTextMessageElement.getText();
        }
    }


