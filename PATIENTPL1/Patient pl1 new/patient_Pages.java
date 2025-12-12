package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class patient_Pages extends StartupPage {
	
//	TC-1 Locators
	By usernameTextfield = By.id("username_id");
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By patientModuleByElement = By.xpath("//a[@href='#/Patient']");
//	TC-2 Locators
	By patientModuleToggleIconByElement = By.xpath("//a[@href='#/Patient']//span[@data-target='#Patient']");
	By searchPatientSubModuleByElement = By.xpath("//a[@href='#/Patient/SearchPatient']//span[contains(text(), 'Search Patient')]");
	By registerPatientSubModuleByElement = By.xpath("//a[@href='#/Patient/RegisterPatient']//span[contains(text(), 'Register Patient')]");
//	TC-3 Locators
	By searchPatientTextboxByElement = By.xpath("//input[@id='quickFilterInput']");
//	TC-4 Locators
	By cameraIconByElement = By.xpath("//a[@title='Profile Picture']");
	By newPhotoButtonByElement = By.xpath("//button[@class='btn blue btn-sm']");
	By takeASnapShotButtonByElement = By.xpath("//button[@class='btn blue btn-sm']");
	By cancelButtonByElement = By.xpath("//button[contains(text(), 'Cancel')]");
//	TC-5 Locators
	By basicInformationLinkByElement = By.xpath("//a[contains(text(), 'Basic Information')]");
	By regPatientSubmitButtonByElement = By.xpath("//input[@id='regPatientSubmitBtn']");
	By errorMessageOfPhoneNumberTextboxByElement = By.xpath("//span[contains(text(), 'Primary Phone is required')]");
//	TC-6 Locators
	By firstNameTextboxByElement = By.xpath("//input[@id='regPatFirstName']");
	By middleNameTextboxByElement = By.xpath("//input[@placeholder='Middle Name']");
	By lastNameTextboxByElement = By.xpath("//input[@id='LastName']");
	By ageTextboxByElement = By.xpath("//input[@id='Age']");
	By phoneTextboxByElement = By.xpath("//input[@id='PhoneNumber']");
//	TC-7 & 8 Locators
	By bloodGroupDropdownByElement = By.xpath("//label[contains(text(), 'Blood group')]/..//select");

	String pageName = this.getClass().getSimpleName();
	public patient_Pages(WebDriver driver) {
		super(driver);
	}

	/**@Test1.1
	 * about this method loginTohealthAppByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in button
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			//			commonEvents.setBrowserZoomLevelTo80Percent();
			commonEvents.waitTillElementLocated(usernameTextbox, 10);
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			commonEvents.waitTillElementLocated(passwordTextbox, 10);
			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			commonEvents.waitTillElementLocated(signInButton, 20);
			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.jsClick(signInButton);

			if(commonEvents.isDisplayed(patientModuleByElement))
			{   
				WebElement operationTheatreModuleWebElement = commonEvents.findElement(patientModuleByElement);
				commonEvents.highlightElement(operationTheatreModuleWebElement);
				textIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**@Test1.2
	 * about this method verifyTitleOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the title of the current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTitleOfThePage() throws Exception {
		String pageTitle = "";
		try {
			pageTitle = commonEvents.getTitle();
			System.out.println("title of the page is  :" + pageTitle );
		}catch(Exception e) {
			throw e;
		}	
		return pageTitle;
	}

	/**@Test1.3
	 * about this method verifyURLOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			Thread.sleep(5000);
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}

	/**@Test2
	 * about this method verifyAllPresenceOfFieldIfPatientModuleIsPresent() 
	 * @param : null
	 * @description : 
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyAllPresenceOfFieldIfPatientModuleIsPresent() throws Exception {
		Boolean allFieldsAreDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(patientModuleByElement, 10);
			if(commonEvents.isDisplayed(patientModuleByElement)) {

				commonEvents.jsClick(patientModuleToggleIconByElement);

				if(commonEvents.isDisplayed(searchPatientSubModuleByElement) && 
						commonEvents.isDisplayed(registerPatientSubModuleByElement)) {

					System.out.println("all sub modules are present in patient module ");

					allFieldsAreDisplayed = true;
				}
			}
		}catch(Exception e) {
			throw e;
		}	
		return allFieldsAreDisplayed;
	}

	/**@Test3
	 * about this method verifyPlaceholderNameOfTexbox() 
	 * @param : null
	 * @description : verify the placeholder name of text box 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyPlaceholderNameOfTexbox() throws Exception {
		String placeholderNameOfTextbox = "";
		try {
			commonEvents.jsClick(searchPatientSubModuleByElement);

			commonEvents.waitTillElementLocated(searchPatientTextboxByElement, 10);
			if(commonEvents.isDisplayed(searchPatientTextboxByElement)) {

				commonEvents.click(searchPatientTextboxByElement);
				placeholderNameOfTextbox = commonEvents.getAttribute(searchPatientTextboxByElement, "placeholder");
				System.out.println("place holder name of search patient Textbox : " + placeholderNameOfTextbox );

				return placeholderNameOfTextbox;
			}
		}catch(Exception e) {
			throw e;
		}	
		return placeholderNameOfTextbox;
	}

	/**@Test4
	 * about this method verifyButtonIsPresent() 
	 * @param : null
	 * @description : 
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyButtonIsPresent() throws Exception {
		Boolean buttonIsDisplayed = false;
		try {

			commonEvents.waitTillElementLocated(registerPatientSubModuleByElement, 10);

			if(commonEvents.isDisplayed(registerPatientSubModuleByElement)) {

				commonEvents.jsClick(registerPatientSubModuleByElement);

				commonEvents.waitTillElementLocated(cameraIconByElement, 10);
				commonEvents.jsClick(cameraIconByElement);

				if(commonEvents.isDisplayed(newPhotoButtonByElement)) {

					commonEvents.jsClick(newPhotoButtonByElement);
					Thread.sleep(3000);

					commonEvents.waitTillElementLocated(takeASnapShotButtonByElement, 10);
					WebElement highLighttakeASnapShotButtonWebelement = commonEvents.findElement(takeASnapShotButtonByElement);
					commonEvents.highlight(highLighttakeASnapShotButtonWebelement);

					commonEvents.waitTillElementLocated(cancelButtonByElement, 10);
					commonEvents.click(cancelButtonByElement);

					buttonIsDisplayed = true;
				}
			}
		}catch(Exception e) {
			throw e;
		}	
		return buttonIsDisplayed;
	}

	/**@Test5
	 * about this method verifyErrorMessage() 
	 * @param : null
	 * @description : verify the error message
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyErrorMessage() throws Exception {
		String errorMessage = "";
		try {
			Thread.sleep(5000);
			commonEvents.waitTillElementLocated(basicInformationLinkByElement, 10);
			if(commonEvents.isDisplayed(basicInformationLinkByElement)) {
				commonEvents.click(basicInformationLinkByElement);

				commonEvents.waitTillElementLocated(regPatientSubmitButtonByElement, 10);
				commonEvents.click(regPatientSubmitButtonByElement);

				commonEvents.waitTillElementLocated(errorMessageOfPhoneNumberTextboxByElement, 10);
				commonEvents.isDisplayed(errorMessageOfPhoneNumberTextboxByElement);
				errorMessage = commonEvents.getText(errorMessageOfPhoneNumberTextboxByElement);
				System.out.println("error Message of Phone Number textbox : " + errorMessage );

				return errorMessage;
			}
		}catch(Exception e) {
			throw e;
		}
		return errorMessage;
	}


	/**@Test6
	 * about this method verifyTexboxIsPresentAndValidateEnteredValue() 
	 * @param : null
	 * @description : verify text box , then send value to that text box and validate the entered value
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTextboxIsPresentAndValidateEnteredValue(Map<String, String> expectedData) throws Exception {

		String firstNameTextboxValue = "";
		try {

			commonEvents.waitTillElementLocated(basicInformationLinkByElement, 10);
			if(commonEvents.isDisplayed(basicInformationLinkByElement)) {

				commonEvents.waitTillElementLocated(firstNameTextboxByElement, 10);
				commonEvents.sendKeys(firstNameTextboxByElement, expectedData.get("firstNameValue"));

				commonEvents.waitTillElementLocated(middleNameTextboxByElement, 10);
				commonEvents.sendKeys(middleNameTextboxByElement, expectedData.get("middleNameValue"));

				commonEvents.waitTillElementLocated(lastNameTextboxByElement, 10);
				commonEvents.sendKeys(lastNameTextboxByElement, expectedData.get("lastNameValue"));

				commonEvents.waitTillElementLocated(ageTextboxByElement, 10);
				commonEvents.sendKeys(ageTextboxByElement, expectedData.get("AgeValue"));

				commonEvents.waitTillElementLocated(phoneTextboxByElement, 10);
				commonEvents.sendKeys(phoneTextboxByElement, expectedData.get("phoneNumberValue"));

				firstNameTextboxValue = commonEvents.getAttribute(firstNameTextboxByElement, "value");
				System.out.println("attribute value of first Name Textbox : " + firstNameTextboxValue );
				return firstNameTextboxValue;
			}
		}catch(Exception e) {
			throw e;
		}	
		return firstNameTextboxValue;
	}

	/**@Test7
	 * about this method scrollToBottomAndVerifyFieldIsPresent() 
	 * @param : null
	 * @description : 
	 * @return : String
	 * @author : YAKSHA
	 */
	public Boolean scrollToBottomAndVerifyFieldIsPresent() throws Exception {
		Boolean bloodGroupDropdownIsDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(basicInformationLinkByElement, 10);
			commonEvents.jsScrollToBottomOfThePage();

			commonEvents.waitTillElementLocated(bloodGroupDropdownByElement, 10);
			if(commonEvents.isDisplayed(bloodGroupDropdownByElement)){

				System.out.println("blood group dropdown is present");

				bloodGroupDropdownIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return bloodGroupDropdownIsDisplayed;
	}

	/**@Test8
	 * about this method scrollToBottomVerifyFieldAndHighlight() 
	 * @param : null
	 * @description : 
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean highlightTheBloodGroupElement() throws Exception {
		Boolean textboxIsDisplayed = false;
		try {

			commonEvents.waitTillElementLocated(bloodGroupDropdownByElement, 10);
			if(commonEvents.isDisplayed(bloodGroupDropdownByElement)){

				WebElement bloodGroupDropdownWebElement = commonEvents.findElement(bloodGroupDropdownByElement);
				commonEvents.highlight(bloodGroupDropdownWebElement);

				textboxIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return textboxIsDisplayed;
	}

}
