import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Verify hamburger menu is clickable

boolean isHamburgerMenu = WebUI.verifyElementPresent(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/menu_CURAHealthcare'), 5, FailureHandling.STOP_ON_FAILURE)

if (isHamburgerMenu) {
	WebUI.click(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/menu_CURAHealthcare'))
	WebUI.comment('Hamburger menu was clickable')
} else {
	WebUI.comment('Hamburger menu was not clickable')
	return
}

// Verify login menu is clickable

boolean isLoginMenu = WebUI.verifyElementPresent(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/menu_Login'), 5, FailureHandling.STOP_ON_FAILURE)

if (isLoginMenu) {
	WebUI.click(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/menu_Login'))
	WebUI.comment('Login menu is clickable and login page is displayed')
} else {
	WebUI.comment('Login menu was not clickable')
}

// Enter username

WebUI.setText(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/input_Username'), GlobalVariable.username)
WebUI.comment('Username was filled')

//Enter Password

WebUI.setEncryptedText(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/input_Password'),
	GlobalVariable.password)
WebUI.comment('Password was filled')

// Verify login button is clickable

boolean isLoginButton = WebUI.verifyElementPresent(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/button_Login'), 5, FailureHandling.STOP_ON_FAILURE)

if (isLoginButton) {
	WebUI.click(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/button_Login'))
	WebUI.comment('Login button was clickable')
} else {
	WebUI.comment('Login button was not clickable')
	return
}

// Validate Login successful and navigate to make appoinment page

WebUI.verifyElementPresent(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/txt_MakeAppointment'), 0)

String makeAppointment = WebUI.getText(findTestObject('Object Repository/TOR_01_Login/Page_CURAHealthcareService/txt_MakeAppointment'))
WebUI.comment('The page is ' + makeAppointment)

