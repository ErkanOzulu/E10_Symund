package com.cydeo.step_definitions;


import com.cydeo.pages.ContactsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactsStepDefs {

    ContactsPage contactsPage = new ContactsPage();

    @When("User click on new contact")
    public void user_click_on_new_contact() {

        BrowserUtils.sleep(3);
        contactsPage.newContactButton.click();
    }

    @When("User enter name of the contact in  input Company {string} box")
    public void user_enter_name_of_the_contact_in_input_company_box(String name) {

        contactsPage.inputCompany.sendKeys(name);
        BrowserUtils.sleep(5);

    }

    @When("User enter last name  in  input Title {string} box")
    public void user_enter_last_name_in_input_title_box(String lastName) {
        contactsPage.inputTitle.sendKeys(lastName + Keys.ENTER);
        BrowserUtils.sleep(1);
    }

    @Then("Verify that appears in the <All contacts> list with matching initials")
    public void verify_that_appears_in_the_all_contacts_list_with_matching_initials() {
        List<WebElement> fullNameList = new ArrayList<>(contactsPage.fullNameList);
        List<WebElement> initialsList = new ArrayList<>(contactsPage.initialsList);
        for (int i = 0; i < initialsList.size(); i++) {
            String actual = initialsList.get(i).getText();
            for (int j = i; j < fullNameList.size(); j++) {
                String expected = fullNameList.get(j).getText().trim().substring(0, 1).toUpperCase();

                System.out.println("actual = " + actual);
                System.out.println("expected = " + expected);
                Assert.assertEquals(expected, actual);
                break;

            }
        }
    }

    @Then("Verify that appears in the <All contacts> list with matching initials1")
    public void verify_that_appears_in_the_all_contacts_list_with_matching_initials1() {
        List<WebElement> fullNameList = new ArrayList<>(contactsPage.fullNameList);
        List<WebElement> initialsList = new ArrayList<>(contactsPage.initialsList);
        for (int i = 0; i < initialsList.size(); i++) {
            String actual = initialsList.get(i).getText();
            for (int j = i; j < fullNameList.size(); j++) {
                String expected = fullNameList.get(j).getText().trim().substring(0, 1).toUpperCase();

                System.out.println("actual = " + actual);
                System.out.println("expected = " + expected);
                Assert.assertEquals(expected, actual);
                contactsPage.threeDotButton.click();
                contactsPage.deleteButton.click();
                break;
            }
        }
    }
}
