package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;




    public class NoteManagementStepDefs {

        private final WebDriver driver;

        public NoteManagementStepDefs(WebDriver driver) {
            this.driver = driver;
        }

        @Given("I am on the notes page")
        public void goToNotesPage() {
            driver.get("https://qa.symund.com/index.php/apps/notes/welcome");
        }

        @When("I click on the \"Create Note\" button")
        public void clickCreateNoteButton() {
            WebElement createNoteButton = driver.findElement(By.id("create-note-button"));
            createNoteButton.click();
        }

        @When("I fill in the note title and content")
        public void fillInNoteTitleAndContent() {
            WebElement noteTitleField = driver.findElement(By.id("note-title"));
            WebElement noteContentField = driver.findElement(By.id("note-content"));
            noteTitleField.sendKeys("New Note Title");
            noteContentField.sendKeys("This is the content of my new note.");
        }

        @When("I click on the \"Save\" button")
        public void clickSaveButton() {
            WebElement saveButton = driver.findElement(By.id("save-note-button"));
            saveButton.click();
        }

        @Then("I should see the new note on the notes page")
        public void verifyNewNoteOnNotesPage() {
            WebElement newNoteTitle = driver.findElement(By.xpath("//div[@class='note-title'][text()='New Note Title']"));
            WebElement newNoteContent = driver.findElement(By.xpath("//div[@class='note-content'][text()='This is the content of my new note.']"));
            Assert.assertNotNull(newNoteTitle);
            Assert.assertNotNull(newNoteContent);
        }

        @Given("I have a note")
        public void selectNote() {
            WebElement note = driver.findElement(By.xpath("//div[@class='note'][1]"));
            note.click();
        }

        @When("I click on the \"Add to Favorites\" button for that note")
        public void clickAddToFavoritesButton() {
            WebElement addToFavoritesButton = driver.findElement(By.id("add-to-favorites-button"));
            addToFavoritesButton.click();
        }

        @Then("the note should be added to my favorites list")
        public void verifyNoteAddedToFavorites() {
            WebElement favoritesList = driver.findElement(By.id("favorites-list"));
            List<WebElement> favoriteNotes = favoritesList.findElements(By.className("note"));
            Assert.assertTrue(favoriteNotes.size() > 0);
        }

        @When("I click on the note title")
        public void clickNoteTitle() {
            WebElement noteTitle = driver.findElement(By.xpath("//div[@class='note-title'][1]"));
            noteTitle.click();
        }

        @Then("I should see the note details, including the number of letters and words")
        public void verifyNoteDetailsDisplayed() {
            WebElement noteTitle = driver.findElement(By.id("note-title"));
            WebElement noteContent = driver.findElement(By.id("note-content"));
            WebElement numLetters = driver.findElement(By.id("num-letters"));
            WebElement numWords = driver.findElement(By.id("num-words"));
            Assert.assertNotNull(noteTitle);
            Assert.assertNotNull(noteContent);
            Assert.assertNotNull(numLetters);
            Assert.assertNotNull(numWords);
        }

        @Then("I should see the option to add a new category")
        public void verifyNewCategoryOptionDisplayed() {
            WebElement newCategoryField = driver.findElement(By.id("new-category-field"));
            WebElement createCategoryButton = driver.findElement(By.id("create-category-button"));
            Assert.assertNotNull(newCategoryField);
            Assert.assertNotNull(createCategoryButton);
        }

        @Given("I am on the note details page")
        public void goToNoteDetailsPage() {


        }

        @When("I click on the delete button for that note")
        public void iClickOnTheButtonForThatNote(String arg0) {
        }

        @When("i click  categories")
        public void iClickCategories() {
            
        }

        @And("write a new categories name ")
        public void writeANewCategories() {
        }

        @And("write a new category name")
        public void writeANewCategoryName() {
        }
    }

