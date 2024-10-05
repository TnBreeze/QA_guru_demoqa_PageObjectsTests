package tests;

import org.junit.jupiter.api.Test;
import page.TextBoxPage;

public class TextBoxPageObjectsTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulTextBoxWithFullDataTest() {
        String userName = "Kassandra M'Leur";
        String userEmail = "sandra@leur.com";
        String currentAddress = "street mau";
        String permanentAddress = "street mrr";

        textBoxPage.openPage()
                .setFullName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        textBoxPage
                .checkResult("Name:", userName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);
    }
}