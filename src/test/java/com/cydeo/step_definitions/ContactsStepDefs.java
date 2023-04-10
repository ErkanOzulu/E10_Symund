package com.cydeo.step_definitions;


import com.cydeo.pages.ContactsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.w3c.dom.Node;

import netscape.javascript.JSObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathResult;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContactsStepDefs {

    ContactsPage contactsPage = new ContactsPage();
    String contactNumber;


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
                } else if (fullNameList.get(j).getText().trim().length() > 1) {
                    if (fullNameList.get(j).getText().trim().contains(" ")) {
                        expected = fullNameList.get(j).getText().trim().substring(0, 1).toUpperCase() +
                                fullNameList.get(j).getText().trim().substring((fullNameList.get(j).getText().indexOf(" ") + 1), (fullNameList.get(j).getText().indexOf(" ") + 2)).toUpperCase();
                    } else {
                        expected = fullNameList.get(j).getText().trim().substring(0, 1).toUpperCase();
                    }

                    System.out.println("actual = " + actual);
                    System.out.println("expected = " + expected);
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

        BrowserUtils.sleep(5);

        //document.querySelectorAll('.app-content-list-item-line-one');

        List<WebElement> elements = Driver.getDriver().findElements(By.cssSelector(".app-content-list-item-line-one"));
        Assert.assertTrue(!elements.isEmpty());
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }


    }

    @Then("Verify that  total number of the contacts near the “All Contacts” tab")
    public void verify_that_total_number_of_the_contacts_near_the_all_contacts_tab() {

        System.out.println("Number of Contacts : " + contactsPage.allContactsNumber.getText());

        Assert.assertTrue(contactsPage.allContactsNumber.isDisplayed());


    }

    @When("User select one of the contacts")
    public void userSelectOneOfTheContacts() {
        contactsPage.newContactButton.click();

        contactNumber = contactsPage.allContactsNumber.getText();

    }

    @When("User click on the picture icon")
    public void user_click_on_the_picture_icon() {
        BrowserUtils.sleep(3);
        contactsPage.pictureIcon.click();

    }

    @When("User click on Choose from files button")
    public void user_click_on_choose_from_files_button() {
        BrowserUtils.sleep(3);
        contactsPage.Choosefromfilesbutton.click();
    }

    @When("User pick any avatar and click on choose button")
    public void user_pick_any_avatar_and_click_on_choose_button() {
        BrowserUtils.sleep(3);
        contactsPage.picture_jpg.click();
        BrowserUtils.sleep(3);
        contactsPage.choose_button.click();
    }

    @Then("Verify that  the profile picture changes")
    public void verify_that_the_profile_picture_changes() {
        Assert.assertTrue(contactsPage.verifyPicture.getAttribute("style").contains("background-image"));
        System.out.println("image_Url = " + contactsPage.verifyPicture.getAttribute("style"));
    }

    @When("User click on three dot button")
    public void user_click_on_three_dot_button() {
        BrowserUtils.sleep(3);
        contactsPage.three_dot_button.click();
    }

    @When("User click on Delete button")
    public void user_click_on_delete_button() {
        BrowserUtils.sleep(3);
        contactsPage.delete_button.click();
    }

    @Then("Verify that  the contact deleted")
    public void verify_that_the_contact_deleted() {

        int expectedResult = Integer.parseInt(contactNumber) - Integer.parseInt(contactsPage.allContactsNumber.getText());

        Assert.assertTrue(expectedResult == 1);

        System.out.println("Number of Deleted Contacts = " + expectedResult);

    }


}
