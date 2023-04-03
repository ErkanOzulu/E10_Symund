package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    /*
    In the class we will be able to pass pre&post conditions to each scenario and each step
     */


    //import from io.cucumber.java not from junit
   // @Before(order = 1)
    public void setupScenario() {

        System.out.println("===Setting up browser using cucumber @Before");

    }

    //@Before(value = "@login", order = 2)
    public void setupScenarioForLogins() {

        System.out.println("===this will only apply to scenarios with @login tag");

    }

    //@Before(value = "@db",order = 0)
    public void setupForDatabaseScenarios() {

        System.out.println("===this will only apply to scenarios with @db tag");

    }

    @After
    public void teardownScenario(Scenario scenario) {


        //scenario.isFailed()  --- > if scenario fails this method will return True boolean value   This method comes from cucumber-java library(from Scenario class)

        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());

        }




     //  Driver.closeDriver();

//        System.out.println("===Closing browser using cucumber @After");
//        System.out.println("===Scenario ended/Take screenshot if failed!");
    }

   // @BeforeStep
    public void setupStep() {
        System.out.println("-------applying setup using @BeforeStep");

    }

   // @AfterStep
    public void afterStep() {

        System.out.println("---------> applying teardown using @AfterStep");
    }


}
