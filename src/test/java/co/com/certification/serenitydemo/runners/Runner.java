package co.com.certification.serenitydemo.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"co.com.certification.serenitydemo.stepsdefinitions"},
        tags = "@Regression")
public class Runner {
}
