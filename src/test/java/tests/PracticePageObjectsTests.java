package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;


public class PracticePageObjectsTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successRegistrationTest() {
        String firstName = "Alex";
        String lastName = "Alexeev";
        String userEmail = "alexeev@alex.com";
        String gender = "Other";
        String userNumber = "9876283746";
        String dayOfBirth = "13";
        String monthOfBirth = "July";
        String yearOfBirth = "2024";
        String subjects = "English";
        String hobbies = "Reading";
        String pictureName = "krasiv.jpg";
        String currentAddress = "street, 1";
        String state = "Haryana";
        String city = "Panipat";


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictureName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successRegistrationRequiredFieldsTest() {
        String firstName = "Tanya";
        String lastName = "Alexeeva";
        String gender = "Other";
        String userNumber = "9876283746";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage().clickSubmit();

        registrationPage.negativeCheck();
    }
}