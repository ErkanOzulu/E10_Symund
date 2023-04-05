package com.cydeo.step_definitions;


import com.cydeo.pages.ContactsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
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




    @When("User enter name of the contact and last name in  input Company box")
    public void user_enter_of_the_contact_and_in_input_company_box(Map<String, String> list) {


        for (Map.Entry<String, String> each : list.entrySet()) {
            contactsPage.inputCompany.sendKeys(each.getKey());
            BrowserUtils.sleep(3);
            contactsPage.inputTitle.sendKeys(each.getValue());
            BrowserUtils.sleep(3);
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
                } else if (fullNameList.get(j).getText().trim().length() > 1){
                    if (fullNameList.get(j).getText().trim().contains(" ")) {
                        expected = fullNameList.get(j).getText().trim().substring(0, 1).toUpperCase() +
                                fullNameList.get(j).getText().trim().substring((fullNameList.get(j).getText().indexOf(" ") + 1), (fullNameList.get(j).getText().indexOf(" ") + 2)).toUpperCase();
                    } else {
                        expected = fullNameList.get(j).getText().trim().substring(0,1).toUpperCase();
                    }

                    System.out.println("actual = " + actual);
                    System.out.println("expected = " + expected);
                    Assert.assertEquals(expected, actual);
                    break;

                }
            }
        }
    }




    @And("User click on All contact button")
    public void userClickOnAllContactButton() {

        contactsPage.allContacts.click();


    }

    @Then("Verify that  contacts as a list inside the middle column")
    public void verify_that_contacts_as_a_list_inside_the_middle_column() {

        List<WebElement> fullNameList = new ArrayList<>(contactsPage.fullNameList);

        for (WebElement webElement : fullNameList) {
            System.out.println( webElement.getText());
        }
    }

    @Then("Verify that  total number of the contacts near the “All Contacts” tab")
    public void verify_that_total_number_of_the_contacts_near_the_all_contacts_tab() {

        System.out.println(contactsPage.allContactsNumber.getText());
        Assert.assertTrue(contactsPage.allContactsNumber.isDisplayed());


    }


}
