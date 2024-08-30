package com.org.o2technologies.utility;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginationUtils {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public PaginationUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));// Adjust timeout as needed
        this.js = (JavascriptExecutor) driver;
    }

    public void paginationVerificationUI(List<WebElement> itemsDisplyed) {
        // Scroll to the bottom of the page
        js.executeScript("window.scrollBy(0, document.body.scrollHeight);");

        // Find and verify paginator elements
        WebElement display = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mat-mdc-paginator-container']")));
        WebElement rangeActions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mat-mdc-paginator-range-actions']")));

        if (display.isDisplayed() && rangeActions.isDisplayed()) {
            System.out.println("Page paginator and navigation are present");
        } else {
            System.out.println("Paginator or navigation is not present");
        }

        // Select an item from the dropdown
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mat-mdc-paginator-outer-container']//mat-select[@role='combobox']")));
        dropdown.click();
        WebElement itemsSelected = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-option[@role='option'][1]")));
        String itemSelectedText = itemsSelected.getText();
        itemsSelected.click();
        int itemsSelectedInt = Integer.parseInt(itemSelectedText);

        // Verify item counts
        WebElement rangeLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mat-mdc-paginator-range-label']")));
        String rangeLabelText = rangeLabel.getText();
        
        int startIndex = rangeLabelText.indexOf("\u2013") + 1;
        int endIndex = rangeLabelText.indexOf("of") - 1;

        int firstIndex = Integer.parseInt(rangeLabelText.substring(0, rangeLabelText.indexOf("\u2013")).trim());
        int lastIndex = Integer.parseInt(rangeLabelText.substring(startIndex, endIndex).trim());

        int displayedRange = lastIndex - firstIndex + 1;

        int totalCountIndex = rangeLabelText.indexOf("of") + 3;
        int totalCount = Integer.parseInt(rangeLabelText.substring(totalCountIndex).trim());
        int displayedItems = itemsDisplyed.size();
        if ((displayedRange == itemsSelectedInt || displayedRange < itemsSelectedInt) &&
                (displayedItems == itemsSelectedInt || displayedItems < itemsSelectedInt)) {
            System.out.println("Selected items per page (" + itemsSelectedInt + ") is displaying proper results");
        } else {
            System.out.println("Items per page (" + itemsSelectedInt + ") is not displaying selected items correctly");
        }
        }
    
}
