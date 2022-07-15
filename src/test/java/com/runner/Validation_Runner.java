package com.runner;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/java/com/features"},
        glue={"step_Definitions"},
        plugin = {"pretty", "html:target/Html_Reports/htmlReport.html"},

        dryRun=false)
public class Validation_Runner {

}
