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
import org.testng.asserts.SoftAssert;

public class SearchNewCandidatesPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private SoftAssert sa;

	@FindBy(xpath = "//span[normalize-space()='Dice']")
	private WebElement diceMenu;

	@FindBy(xpath = "//span[contains(text(),'Search New Candidates')]")
	private WebElement searchNewCandidateOption;

	@FindBy(xpath = "//mat-label[contains(.,'Key word search')]")
	private WebElement keyWordSearch;

	@FindBy(xpath = "//input[@placeholder='Key Word Search or Boolean Search']")
	private WebElement keyWordSearchInput;

	@FindBy(xpath = "//i-tabler[@name='map-pin']//*[name()='svg']")
	private WebElement locationClick;

	@FindBy(xpath = "//input[@formcontrolname='locationFilter']")
	private WebElement locationInput;

	@FindBy(id = "distance")
	private WebElement distanceClick;

	@FindBy(id = "distance")
	private WebElement distanceInput;

	@FindBy(xpath = "//mat-label[contains(.,'UOM')]")
	private WebElement uom;

	@FindBy(xpath = "//mat-option[@value='km']")
	private WebElement km;

	@FindBy(xpath = "//div[@formgroupname='initialLocation']//i-tabler[@name='square-plus']")
	private WebElement plusIcon;

	@FindBy(xpath = "//label[normalize-space()='Willing To Relocate']")
	private WebElement willingToRelocate;

	@FindBy(xpath = "//span[normalize-space()='Save Filters']")
	private WebElement saveFiltersButton;

	@FindBy(xpath = "//input[@name='myInput']")
	private WebElement filterNameInput;

	@FindBy(xpath = "(//span[@class='mdc-button__label'][normalize-space()='Save Filters'])[2]")
	private WebElement saveFilterButtonIn;
	// --------------skillKeyWord----------------//
	@FindBy(xpath = "//span[contains(text(),'Skills Keyword')]")
	private WebElement skillKeyWordFilter;

	@FindBy(xpath = "//mat-label[text()='Skills Keyword']")
	private WebElement skillKeyWordFilterClick;

	@FindBy(xpath = "//mat-label[text()='Skills Keyword']/ancestor::div/div/input")
	private WebElement skillKeyWordInput;
	// ---------------skills---------------//

	@FindBy(xpath = "(//span[contains(text(),'Skills')])[2]")
	private WebElement skills;

	@FindBy(xpath = "//mat-label[normalize-space()='Skills']")
	private WebElement skillsFilterClick;

	@FindBy(xpath = "//mat-label[normalize-space()='Skills']/ancestor::div/div/input")
	private WebElement skillsInput;

	@FindBy(xpath = "//mat-label[normalize-space()='Skill Years Of Experience']")
	private WebElement skillYearClick;

	@FindBy(xpath = "//mat-label[normalize-space()='Skill Years Of Experience']/ancestor::div/div/input")
	private WebElement skillsYearInput;

	@FindBy(xpath = "//i-tabler[@mattooltip='Add Skills Year Of Experaince']")
	private WebElement addSkillsYearInput;

	// ------------Job Title Keyword------------------//

	@FindBy(xpath = "//span[contains(text(),'Job Title Keyword')]")
	private WebElement jobTitleKeyword;

	@FindBy(xpath = "//mat-label[normalize-space()='Job Title Keyword']")
	private WebElement jobTitleKeywordClick;

	@FindBy(xpath = "//mat-label[normalize-space()='Job Title Keyword']/ancestor::div/div/input")
	private WebElement jobTitleKeywordInput;
	// ------------Job Title------------------//

	@FindBy(xpath = "//span[contains(text(),'Job Title')]")
	private WebElement jobTitle;

	@FindBy(xpath = "//mat-label[normalize-space()='Job Title']")
	private WebElement jobTitleClick;

	@FindBy(xpath = "//span/span[normalize-space()='Current']")
	private WebElement currentCheckBox;

	@FindBy(xpath = "//span/span[normalize-space()='Preffered']")
	private WebElement prefferedCheckBox;

	@FindBy(xpath = "//span/span[normalize-space()='Past']")
	private WebElement pastCheckBox;
	// -------------CompanyKeyWord--------//
	@FindBy(xpath = "//span[contains(text(),'Company Keyword')]")
	private WebElement companyKeyWord;

	@FindBy(xpath = "//mat-label[normalize-space()='Company Keyword']")
	private WebElement companyKeyWordClick;

	@FindBy(xpath = "//mat-label[normalize-space()='Company Keyword']/ancestor::div/div/input")
	private WebElement companyKeyWordInput;

	// ---------------Company Current-----------------//

	@FindBy(xpath = "//span[contains(text(),'Company Current')]")
	private WebElement companyCurrent;

	@FindBy(xpath = "//label[normalize-space()='Company Current']")
	private WebElement companyCurrentCheckBox;

	// ---------------Company-----------------//

	@FindBy(xpath = "(//span[contains(text(),'Company')])[3]")
	private WebElement company;

	@FindBy(xpath = "//mat-label[normalize-space()='Company']")
	private WebElement companyClick;

	@FindBy(xpath = "//mat-label[normalize-space()='Company']/ancestor::div/div/input")
	private WebElement companyInput;
	// ---------------Last Active-----------------//

	@FindBy(xpath = "//span[contains(text(),'Last Active')]")
	private WebElement lastActive;

	@FindBy(xpath = "//mat-label[normalize-space()='Last Active']")
	private WebElement lastActiveClick;

	@FindBy(xpath = "//mat-label[normalize-space()='Last Active']/ancestor::div/div/input")
	private WebElement lastActiveInput;
	// ------------Search Type------------------//

	@FindBy(xpath = "//span[contains(text(),'Search Type')]")
	private WebElement searchType;

	@FindBy(xpath = "//mat-label[normalize-space()='Search Type']")
	private WebElement searchTypeClick;

	@FindBy(xpath = "//div/span[normalize-space()='Resume']")
	private WebElement resumeCheckBox;

	@FindBy(xpath = "//div/span[normalize-space()=' Integrated ']")
	private WebElement integratedCheckBox;
	// ------------Contact & IP------------------//

	@FindBy(xpath = "//span[contains(text(),'Contact & IP')]")
	private WebElement contactAndIP;

	@FindBy(xpath = "//label[normalize-space()='Has Email']")
	private WebElement hasEmailCheckBox;

	@FindBy(xpath = "//label[normalize-space()='Has Phonenumber']")
	private WebElement hasPhonenumberCheckBox;

	@FindBy(xpath = "//label[normalize-space()='Has Patent']")
	private WebElement hasPatentCheckBox;

	// ------------ Likely To Switch ------------------//

	@FindBy(xpath = "//span[contains(text(),'Likely To Switch')]")
	private WebElement likelyToSwitch;

	@FindBy(xpath = "//label[normalize-space()='Likely To Switch']")
	private WebElement likelyToSwitchCheckBox;

	// -----------Years Experience----------------//
	@FindBy(xpath = "//span[contains(text(),'Years Experience')]")
	private WebElement yearsExperience;

	@FindBy(xpath = "(//mat-label[normalize-space()='Min'])[1]")
	private WebElement minClick;

	@FindBy(xpath = "(//mat-label[normalize-space()='Min']/ancestor::div/div/input)[1]")
	private WebElement minInput;

	@FindBy(xpath = "(//mat-label[normalize-space()='Max'])[1]")
	private WebElement maxClick;

	@FindBy(xpath = "(//mat-label[normalize-space()='Max']/ancestor::div/div/input)[1]")
	private WebElement maxInput;

	// ------------ Exclude Third Party ------------------//

	@FindBy(xpath = "//span[contains(text(),'Exclude Third Party')]")
	private WebElement excludeThirdParty;

	@FindBy(xpath = "//label[normalize-space()='Exclude Third Party']")
	private WebElement excludeThirdPartyCheckBox;

	// -----------LastUpdated----------------//
	@FindBy(xpath = "//span[contains(text(),'LastUpdated')]")
	private WebElement lastUpdated;

	@FindBy(xpath = "//mat-label[normalize-space()='LastUpdated']")
	private WebElement lastUpdatedClick;

	@FindBy(xpath = "//mat-label[normalize-space()='LastUpdated']/ancestor::div/div/input")
	private WebElement lastUpdatedInput;

	// -----------Compensation----------------//
	@FindBy(xpath = "//span[contains(text(),'Compensation')]")
	private WebElement compensation;

	@FindBy(xpath = "(//mat-label[normalize-space()='Min'])[2]")
	private WebElement compensationMinClick;

	@FindBy(xpath = "(//mat-label[normalize-space()='Min']/ancestor::div/div/input)[2]")
	private WebElement compensationMinInput;

	@FindBy(xpath = "(//mat-label[normalize-space()='Max'])[2]")
	private WebElement compensationMaxClick;

	@FindBy(xpath = "(//mat-label[normalize-space()='Max']/ancestor::div/div/input)[2]")
	private WebElement compensationMaxInput;

	@FindBy(xpath = "//mat-label[normalize-space()='Currency']")
	private WebElement currencyClick;

	@FindBy(xpath = "//div//mat-option[1]")
	private WebElement currencyInputOption;

	@FindBy(xpath = "//mat-label[normalize-space()='Frequency']")
	private WebElement frequencyClick;

	@FindBy(xpath = "//div//mat-option[1]")
	private WebElement hourlyInputOption;

	@FindBy(xpath = "//div//mat-option[2]")
	private WebElement yearlyInputOption;

	@FindBy(xpath = "//label[normalize-space()='Include Unspecified']")
	private WebElement includeUnspecifiedCheckBox;

	// -------------------Security Clearance---------------------------//
	@FindBy(xpath = "//span[contains(text(),'Security Clearance')]")
	private WebElement securityClearance;

	@FindBy(xpath = "//label[normalize-space()='Security Clearance']")
	private WebElement securityClearanceCheckBox;

	// -------------------Social Profiles---------------------------//
	@FindBy(xpath = "//span[contains(text(),'Social Profiles')]")
	private WebElement socialProfiles;

	@FindBy(xpath = "//label[normalize-space()='Github']")
	private WebElement githubCheckBox;

	@FindBy(xpath = "//label[normalize-space()='Stackoverflow']")
	private WebElement stackoverflowCheckBox;

	@FindBy(xpath = "//label[normalize-space()='Facebook']")
	private WebElement facebookCheckBox;

	@FindBy(xpath = "//label[normalize-space()='Linkedin']")
	private WebElement linkedinCheckBox;

	// -------------------Languages---------------------------//
	@FindBy(xpath = "//span[contains(text(),'Languages')]")
	private WebElement languages;

	@FindBy(xpath = "//span[contains(text(),'Languages')]/ancestor::mat-expansion-panel/div//mat-checkbox[1]")
	private WebElement languagesOptionCheckBoxs;

	// -------------------Employment Type---------------------------//
	@FindBy(xpath = "//span[contains(text(),'Employment Type')]")
	private WebElement employmentType;

	@FindBy(xpath = "//span[contains(text(),'Employment Type')]/ancestor::mat-expansion-panel/div//mat-checkbox[1]")
	private WebElement employmentTypeCheckBoxs;

	// -------------------Education---------------------------//
	@FindBy(xpath = "//span[contains(text(),'Education')]")
	private WebElement education;

	@FindBy(xpath = "//span[contains(text(),'Education')]/ancestor::mat-expansion-panel/div//mat-checkbox[1]")
	private WebElement educationCheckBoxs;

	// -------------------Work Permit---------------------------//
	@FindBy(xpath = "//span[contains(text(),'Work Permit')]")
	private WebElement workPermit;

	@FindBy(xpath = "//span[contains(text(),'Work Permit')]/ancestor::mat-expansion-panel/div//mat-checkbox[1]")
	private WebElement workPermitCheckBoxs;
	// -----------Travel Preference----------------//
	@FindBy(xpath = "//span[contains(text(),'Travel Preference')]")
	private WebElement travelPreference;

	@FindBy(xpath = "//div[contains(text(),'Travelpreference')]")
	private WebElement travelPreferenceClick;

	@FindBy(xpath = "(//div[@role='option'])[1]")
	private WebElement travelPreferenceInputList;

	// -----------Sort By----------------//
	@FindBy(xpath = "//span[contains(text(),'Sort By')]")
	private WebElement sortBy;

	@FindBy(xpath = "//div[contains(text(),'Sortby')]")
	private WebElement sortByClick;

	@FindBy(xpath = "(//div[@role='option'])[1]")
	private WebElement sortByInputList;

	// -----------Sort By Direction----------------//
	@FindBy(xpath = "//span[contains(text(),'Sort By Direction')]")
	private WebElement sortByDirection;

	@FindBy(xpath = "//div[contains(text(),'Sortbydirection')]")
	private WebElement sortByDirectionClick;

	@FindBy(xpath = "(//div[@role='option'])[1]")
	private WebElement sortByDirectionInputList;

//  --------------------------------------------------- // 

	@FindBy(xpath = "//button[@type='button']//span[contains(text(),'Apply Filter')]")
	private WebElement applyFilter;

	@FindBy(xpath = "//mat-chip-listbox//b[normalize-space()='Q:']")
	private WebElement chipQ;

	@FindBy(xpath = "//mat-chip-listbox//b[normalize-space()='Q:']/ancestor::span/span[2]")
	private WebElement chipQText;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Skillskeyword:']")
	private WebElement chipSkillskeyword;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Skillskeyword:']/ancestor::span/span[2]")
	private WebElement chipSkillskeywordText;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Skillyearsofexperiences:']")
	private WebElement chipSkillyearsofexperiences;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Skillyearsofexperiences:']/ancestor::span/span[2]")
	private WebElement chipSkillyearsofexperiencesText;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Jobtitlekeyword:']")
	private WebElement chipJobtitlekeyword;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Jobtitlekeyword:']/ancestor::span/span[2]")
	private WebElement chipJobtitlekeywordText;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Jobtitle:']")
	private WebElement chipJobtitle;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Jobtitle:']/ancestor::span/span[2]")
	private WebElement chipJobtitleText;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Companykeyword:']")
	private WebElement chipCompanykeyword;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Companykeyword:']/ancestor::span/span[2]")
	private WebElement chipCompanykeywordText;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Companycurrent:']")
	private WebElement chipCompanycurrent;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Companycurrent:']/ancestor::span/span[2]")
	private WebElement chipCompanycurrentText;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Company:']")
	private WebElement chipCompany;

	@FindBy(xpath = " //mat-chip-listbox//b[normalize-space()='Company:']/ancestor::span/span[2]")
	private WebElement chipCompanyText;

	public SearchNewCandidatesPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	public WebElement getChipElement(String text) {
		String xpath = String.format("//mat-chip-listbox//b[normalize-space()='%s']", text);
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement getChipElementText(String text) {
		String xpath = String.format("//mat-chip-listbox//b[normalize-space()='%s']/ancestor::span/span[2]", text);
		return driver.findElement(By.xpath(xpath));
	}

	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public boolean visibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}

	public void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
	}

	

	public void fillForm(String searchCandidateInput, String location, String distance, String filterName,
			String skillKeyWord) {
		
		
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(searchNewCandidateOption));
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					diceMenu);
			clickElement(diceMenu);
		}
		clickElement(searchNewCandidateOption);
		clickElement(keyWordSearch);
		enterText(keyWordSearchInput, searchCandidateInput);
		//----chips verfication----//
		sa.assertTrue(visibility(getChipElement("Q:")));
		sa.assertEquals(searchCandidateInput, (getChipElementText("Q:").getText()));
		clickElement(locationClick);
		enterText(locationInput, location);
		enterText(distanceInput, distance);
		clickElement(uom);
		clickElement(km);
		clickElement(plusIcon);
		clickElement(willingToRelocate);
		clickElement(saveFiltersButton);
		enterText(filterNameInput, filterName);
		clickElement(saveFilterButtonIn);

		scrollToElement(skillKeyWordFilter);
		js.executeScript("arguments[0].click();", skillKeyWordFilter);
		wait.until(ExpectedConditions.visibilityOf(skillKeyWordFilterClick));
		js.executeScript("arguments[0].click();", skillKeyWordFilterClick);

		enterText(skillKeyWordInput, skillKeyWord);
		sa.assertTrue(visibility(chipSkillskeyword));
		sa.assertEquals(skillKeyWord, chipSkillskeywordText.getText());
		scrollToElement(applyFilter);
		js.executeScript("arguments[0].click();", applyFilter);

		wait.until(ExpectedConditions.visibilityOf(skillKeyWordFilterClick));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']//mat-card")));
		
	    sa.assertAll();
	}

	int displayedItems = 0;

	public void paginationVerificationUI() {
		// Scroll to the bottom of the page
		js.executeScript("window.scrollBy(0, document.body.scrollHeight);");

		// Find and verify paginator elements
		WebElement display = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mat-mdc-paginator-container']")));
		WebElement rangeActions = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='mat-mdc-paginator-range-actions']")));

		if (display.isDisplayed() && rangeActions.isDisplayed()) {
			System.out.println("Page paginator and navigation are present");
		} else {
			System.out.println("Paginator or navigation is not present");
		}

		// Select an item from the dropdown
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='mat-mdc-paginator-outer-container']//mat-select[@role='combobox']")));
		dropdown.click();
		WebElement itemsSelected = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-option[@role='option'][1]")));
		String itemSelectedText = itemsSelected.getText();
		itemsSelected.click();
		int itemsSelectedInt = Integer.parseInt(itemSelectedText);

		// Verify item counts
		WebElement rangeLabel = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='mat-mdc-paginator-range-label']")));
		String rangeLabelText = rangeLabel.getText();

		int startIndex = rangeLabelText.indexOf("\u2013") + 1;
		int endIndex = rangeLabelText.indexOf("of") - 1;

		int firstIndex = Integer.parseInt(rangeLabelText.substring(0, rangeLabelText.indexOf("\u2013")).trim());
		int lastIndex = Integer.parseInt(rangeLabelText.substring(startIndex, endIndex).trim());

		int displayedRange = lastIndex - firstIndex + 1;

		int totalCountIndex = rangeLabelText.indexOf("of") + 3;
		int totalCount = Integer.parseInt(rangeLabelText.substring(totalCountIndex).trim());
		displayedItems = driver.findElements(By.xpath("//div[@class='row']//mat-card")).size();
		if ((displayedRange == itemsSelectedInt || displayedRange < itemsSelectedInt)
				&& (displayedItems == itemsSelectedInt || displayedItems < itemsSelectedInt)) {
			System.out.println("Selected items per page (" + itemsSelectedInt + ") is displaying proper results");
		} else {
			System.out.println("Items per page (" + itemsSelectedInt + ") is not displaying selected items correctly");
		}

		WebElement totalRecordsElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(),'Total Records')]")));
		String totalRecordsText = totalRecordsElement.getText();
		int totalRecordCount = Integer.parseInt(totalRecordsText.substring(totalRecordsText.indexOf("s") + 3).trim());
		if (totalRecordCount == totalCount) {
			System.out.println("Total records: " + totalRecordCount + " verified with pagination");

		}

	}

	public void KeywordSearchVerification(String SkillKeyWord) {
		try {
			// Find all span elements with the class 'skill-item'
			List<WebElement> spanElements = driver
					.findElements(By.xpath("//mat-card[@class='mat-mdc-card mdc-card dicematcard ng-star-inserted']"));

			// Keyword to search for
			// String keywords = skillKeyWord;
			String[] words = SkillKeyWord.toLowerCase().split(",");

			int i = 0;
			// Check each span element's text for the keyword
			for (WebElement span : spanElements) {
				String text = span.getText();
				for (String Word : words) {
					if (text.toLowerCase().contains(Word.toLowerCase())) {
						i++;
					}
				}
				if (i == displayedItems) {
					System.out.println("Enterd skills are present on all profile cards.Search result is validated");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
