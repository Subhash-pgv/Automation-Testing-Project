package com.org.o2technologies.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigerWorkflowButton {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	@FindBy(xpath = "//span[normalize-space()='Dice']")
	private WebElement diceMenu;

	@FindBy(xpath = "//span[contains(text(),'Search New Candidates')]")
	private WebElement searchNewCandidateOption;

	@FindBy(xpath = "//span[normalize-space()='Configure Workflows']")
	private WebElement configureWorkflows;

	@FindBy(xpath = "//input[@placeholder='Provide Work Flow Name']")
	private WebElement nameInput;

	@FindBy(xpath = "//input[@formcontrolname='totalCount']")
	private WebElement totalCountInput;

	@FindBy(xpath = "(//div[@class='mdc-radio'])[1]")
	private WebElement continuousRadioButton;

	@FindBy(xpath = "//div//input[@formcontrolname='daysContinuous']")
	private WebElement daysInput;

	@FindBy(xpath = "(//div[@class='mdc-radio'])[2]")
	private WebElement oneTimeRadioButton;

	@FindBy(xpath = "//label[text()='University List']/ancestor::div//input[@type='checkbox']")
	private WebElement universityListCheckbox;

	@FindBy(xpath = "//div//input[@formcontrolname='priority']")
	private WebElement priorityInput;

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='priorityAll']//input")
	private WebElement priorityAllCheckbox;

	@FindBy(xpath = "//b[normalize-space()='Email']//parent::div//following-sibling::mat-form-field//child::mat-label[text()='Select Profile Name']")
	private WebElement emailSelectProfileName;

	@FindBy(xpath = "//b[normalize-space()='Email']//parent::div//following-sibling::mat-form-field[1]//div[1]//span[contains(@class, 'mat-mdc-select-value-text')]")
	private WebElement emailProfileText;

	@FindBy(xpath = "//b[normalize-space()='Email']//parent::div//following-sibling::mat-form-field//child::mat-label[text()='Select Templates']")
	private WebElement emailSelectTemplates;

	@FindBy(xpath = "//b[normalize-space()='Email']//parent::div//following-sibling::mat-form-field[2]//div[1]//span[contains(@class, 'mat-mdc-select-value-text')]")
	private WebElement emailTemplateText;

	@FindBy(xpath = "//div[@class='col-md-1 ng-star-inserted']//i-tabler[@name='square-plus']//*[name()='svg']")
	private WebElement emailPlusIcon;

	@FindBy(xpath = "//b[normalize-space()='SMS']//parent::div//following-sibling::mat-form-field//child::mat-label[text()='Select Profile Name']")
	private WebElement smsSelectProfileName;

	@FindBy(xpath = "//b[normalize-space()='SMS']//parent::div//following-sibling::mat-form-field[1]//div[1]//span[contains(@class, 'mat-mdc-select-value-text')]")
	private WebElement smsProfileText;

	@FindBy(xpath = "//b[normalize-space()='SMS']//parent::div//following-sibling::mat-form-field//child::mat-label[text()='Select Templates']")
	private WebElement smsSelectTemplates;

	@FindBy(xpath = "//b[normalize-space()='SMS']//parent::div//following-sibling::mat-form-field[2]//div[1]//span[contains(@class, 'mat-mdc-select-value-text')]")
	private WebElement smsTemplatesText;

	@FindBy(xpath = "//div[@class='col-md-1 f-s-12 ng-star-inserted']//i-tabler[@name='square-plus']//*[name()='svg']")
	private WebElement smsPlusIcon;

	@FindBy(xpath = "//div[@role='listbox']")
	private WebElement dropDownList;

	@FindBy(xpath = "//div[@role='listbox']//mat-option")
	private List<WebElement> dropDownOptions;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//mat-card-content//div[1]//tbody[1]/tr[1]/td[3]/i-tabler[1]")
	private WebElement emailEditIcon;

	@FindBy(xpath = "//mat-card-content//div[2]//tbody[1]/tr[1]/td[3]/i-tabler[1]")
	private WebElement smsEditIcon;

	public ConfigerWorkflowButton(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	private void clickElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	private void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}

	private void selectDropdownOption(WebElement element, int optionIndex) {
		clickElement(element);
		wait.until(ExpectedConditions.visibilityOf(dropDownList));
		dropDownOptions.get(optionIndex).click();
	}

	// ---- Adding configaration with jobtype "oneTime" ,"Email" ,"sms"edit and
	// save-----//
	public boolean performSearchNewCandidateCese1(String nameInputValue, String totalCountValue) {
		try {

			boolean isSearchNewCandidate = false;
			try {
				WebElement searchNewCandidateElement = wait
						.until(ExpectedConditions.elementToBeClickable(searchNewCandidateOption));
				isSearchNewCandidate = true;
			} catch (Exception e) {
				System.out.println("Search New Candidate sub menu is not clickable. Error: " + e.getMessage());
			}

			if (!isSearchNewCandidate) {
				clickElement(diceMenu);
			}
			clickElement(searchNewCandidateOption);
			clickElement(configureWorkflows);

			enterText(nameInput,nameInputValue);
			enterText(totalCountInput,totalCountValue);

			clickElement(oneTimeRadioButton);

			// selectDropdownOption(emailSelectProfileName, 0);
			clickElement(emailSelectProfileName);
			wait.until(ExpectedConditions.visibilityOfAllElements(dropDownOptions));
			String option1 = dropDownOptions.get(0).getText();
			clickElement(dropDownOptions.get(0));

			clickElement(emailSelectTemplates);
			wait.until(ExpectedConditions.visibilityOfAllElements(dropDownOptions));
			String option2 = dropDownOptions.get(0).getText();
			clickElement(dropDownOptions.get(0));

			clickElement(emailPlusIcon);
			clickElement(emailEditIcon);
			String result1 = emailProfileText.getText();
			String result2 = emailTemplateText.getText();
			if (option1.equals(result1) || option2.equals(result2)) {
				System.out.println("Email edit is working fine ");
			}
			clickElement(emailPlusIcon);

			clickElement(smsSelectProfileName);
			wait.until(ExpectedConditions.visibilityOfAllElements(dropDownOptions));
			String option3 = dropDownOptions.get(0).getText();
			clickElement(dropDownOptions.get(0));

			clickElement(smsSelectTemplates);
			wait.until(ExpectedConditions.visibilityOfAllElements(dropDownOptions));
			String option4 = dropDownOptions.get(0).getText();
			clickElement(dropDownOptions.get(0));

			clickElement(smsPlusIcon);
			clickElement(smsEditIcon);
			String result3 = smsProfileText.getText();
			String result4 = smsTemplatesText.getText();

			if (option3.equals(result3) || option4.equals(result4)) {
				System.out.println("sms edit is working fine");
			}
			clickElement(smsPlusIcon);
			clickElement(saveButton);

			System.out.println("Workflow configured successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ---- Adding configaration with jobtype "Continous days =2" ,"Email","SMS" ,
	// "UniversityLis priority =1" -----//
	public boolean performSearchNewCandidateCese2(String nameInputValue, String totalCountValue, String daysInputValue,
			String priorityInputValue) {
		try {
			boolean isSearchNewCandidate = false;
			try {
				WebElement searchNewCandidateElement = wait
						.until(ExpectedConditions.elementToBeClickable(searchNewCandidateOption));
				isSearchNewCandidate = true;
			} catch (Exception e) {
				System.out.println("Search New Candidate sub menu is not clickable. Error: " + e.getMessage());
			}

			if (!isSearchNewCandidate) {
				clickElement(diceMenu);
			}
			clickElement(searchNewCandidateOption);
			clickElement(configureWorkflows);
			if (!isSearchNewCandidate) {
				enterText(nameInput,nameInputValue);
				enterText(totalCountInput,totalCountValue);
			}
			clickElement(continuousRadioButton);
			enterText(daysInput,daysInputValue);

			scrollToElement(universityListCheckbox);
			universityListCheckbox.click();
			enterText(priorityInput,priorityInputValue);

			if (!isSearchNewCandidate) {
				selectDropdownOption(emailSelectProfileName, 0);
				selectDropdownOption(emailSelectTemplates, 0);

				clickElement(emailPlusIcon);

				selectDropdownOption(smsSelectProfileName, 0);
				selectDropdownOption(smsSelectTemplates, 0);

				clickElement(smsPlusIcon);
			}

			clickElement(saveButton);

			System.out.println("Workflow configured successfully with Countinous and university priority");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
