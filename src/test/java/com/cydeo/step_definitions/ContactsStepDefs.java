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
import java.util.Map;

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

    @When("User enter {string} of the contact in  input Company box")
    public void user_enter_of_the_contact_in_input_company_box(String string) {
        BrowserUtils.sleep(3);
        contactsPage.newContactButton.click();
        contactsPage.inputCompany.sendKeys(string);
        BrowserUtils.sleep(5);
    }

    @When("User enter {string}  in  input Title box")
    public void user_enter_in_input_title_box(String string) {
        contactsPage.inputTitle.sendKeys(string + Keys.ENTER);
        BrowserUtils.sleep(1);
    }

    @When("User enter name of the contact and last name in  input Company box")
    public void user_enter_of_the_contact_and_in_input_company_box(Map<String, String> list) {


        for (Map.Entry<String, String> each : list.entrySet()) {
            contactsPage.inputCompany.sendKeys(each.getKey());
            BrowserUtils.sleep(3);
            contactsPage.inputTitle.sendKeys(each.getValue());
            BrowserUtils.sleep(1);
            if (each.getValue().equals("Ozulu")) {
                break;
            } else {
                contactsPage.newContactButton.click();
                BrowserUtils.sleep(3);
            }
        }
    }

    @Then("Verify that appears in the <All contacts> list with matching initials")
    public void verify_that_appears_in_the_all_contacts_list_with_matching_initials() {
        List<WebElement> fullNameList = new ArrayList<>(contactsPage.fullNameList);
        List<WebElement> initialsList = new ArrayList<>(contactsPage.initialsList);
        for (int i = 0; i < initialsList.size(); i++) {
            String actual = initialsList.get(i).getText();
            String expected = "";
            for (int j = i; j < fullNameList.size(); j++) {
                if (fullNameList.get(j).getText().trim().length() == 1) {
                    expected = fullNameList.get(j).getText().trim().toUpperCase();
                } else {
                    if (fullNameList.get(j).getText().trim().contains(" ")) {
                        expected = fullNameList.get(j).getText().trim().substring(0, 1).toUpperCase() +
                                fullNameList.get(j).getText().trim().substring((fullNameList.get(j).getText().indexOf(" ") + 1), (fullNameList.get(j).getText().indexOf(" ") + 2)).toUpperCase();
                    } else {
                        expected = fullNameList.get(j).getText().trim().substring(0, 1).toUpperCase();
                    }

                    System.out.println("actual = " + actual);
                    System.out.println("expected = " + expected);
                    Assert.assertEquals(expected, actual);
                    break;

                }
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
