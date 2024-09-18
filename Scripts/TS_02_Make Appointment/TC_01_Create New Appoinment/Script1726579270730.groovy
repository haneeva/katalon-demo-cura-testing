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
import java.text.SimpleDateFormat
import java.util.Date

//Call Login test case

WebUI.callTestCase(findTestCase('TS_01_Login/TC_01_Login Successful'), [:], FailureHandling.STOP_ON_FAILURE)

// Select a Facility

WebUI.selectOptionByValue(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/select_Facility'), 
    facility, true)
WebUI.comment('Facilty was selected')

// Check for Apply for hospital readmission

WebUI.click(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/checkbox_ApplyForHospitalReadmission'))
WebUI.comment('Apply for hospital readmission was checked')

// Choose Healthcare Program

WebUI.click(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/input_MedicaidProgram'))
WebUI.comment('Healthcare program medicaid was chosen')


// Select visit date

SimpleDateFormat dateFormat = new SimpleDateFormat('dd/MM/yyyy')

Date today = new Date()

// Set visit date
Date visitDate = today.plus(3)

// Format the visit dates
String formattedVisitDate = dateFormat.format(visitDate)

// Set the visit date
WebUI.click(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/input_Visit Date'))
WebUI.setText(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/input_Visit Date'), formattedVisitDate)
WebUI.comment('Visit Date was set: ' + formattedVisitDate)

// Enter comment

WebUI.setText(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/input_Comment'), 
    comment)
WebUI.comment('Comment was filled')

// Verify the book appointment button is clickable

boolean isBookAppoimentButton = WebUI.verifyElementPresent(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/button_Book Appointment'), 5)

if (isBookAppoimentButton) {
	WebUI.click(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/button_Book Appointment'))
	WebUI.comment('Book Appointment was clickable')
} else {
	WebUI.comment('Book Appointment was not clickable')
	return
}

// Validate Appoinment confirmation

WebUI.click(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/txt_AppointmentConfirmation'))
WebUI.verifyElementPresent(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/txt_AppointmentConfirmation'), 5)
String appoinmentconfirmation = WebUI.getText(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/txt_AppointmentConfirmation'))
WebUI.comment('The page was displayed: ' + appoinmentconfirmation)

// Return back Home page

WebUI.click(findTestObject('Object Repository/TOR_02_Make Appointment/Page_CURA Healthcare Service/button_GoToHomepage'))
WebUI.comment('Home page was displayed')


