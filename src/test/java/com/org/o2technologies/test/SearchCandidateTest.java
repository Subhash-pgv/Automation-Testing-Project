package com.org.o2technologies.test;

import java.util.List;
import java.util.Map;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

import org.testng.annotations.*;

import com.org.o2technologies.pages.ConfigerWorkflowButton;
import com.org.o2technologies.pages.SearchNewCandidatesPage;
import com.org.o2technologies.utility.*;

public class SearchCandidateTest extends BaseLoginTest {

	private static SearchNewCandidatesPage searchNewCandidatesPage;
	private static ConfigerWorkflowButton configerWorkflowButton;
	private static Excel_InputValues Excel_InputValues;

	// private InputValues inputValues;
	@BeforeTest
	public void setupTestData() {

		searchNewCandidatesPage = new SearchNewCandidatesPage(driver);
		configerWorkflowButton = new ConfigerWorkflowButton(driver);

		try {
			String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata1.xlsx";
			Excel_InputValues = new Excel_InputValues(excelFilePath, "Sheet1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1, description = "TC002 ")
	public void searchCandidate() throws InterruptedException {
		List<Map<String, String>> dataList = Excel_InputValues.getExcelData();

		System.out.println("Driver: " + (driver != null ? "Initialized" : "Not Initialized"));
		System.out.println("searchNewCandidatesPage: " + (searchNewCandidatesPage != null ? "Initialized" : "Not Initialized"));

		for (Map<String, String> data : dataList) {
//		configerWorkflowButton.performSearchNewCandidateCese1(data.get("NameInputValue"),data.get("totalCountValue"));
//			configerWorkflowButton.performSearchNewCandidateCese2(data.get("NameInputValue"),data.get("totalCountValue"), data.get("daysInputValue"), data.get("priorityInputValue"));
			searchNewCandidatesPage.fillForm(data.get("searchCandidateInput"), data.get("location"),
					data.get("distance"), data.get("filterName"), data.get("SkillKeyWord"));
			searchNewCandidatesPage.paginationVerificationUI();
			searchNewCandidatesPage.KeywordSearchVerification(data.get("SkillKeyWord"));

		}
	}
}
