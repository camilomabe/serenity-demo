package co.com.certification.serenitydemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser implements Task {
    @Override
    @Step("{0} closes the browser")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS) ;
        driver.quit();
    }

    public static Performable close() {
        return Tasks.instrumented(Browser.class);
    }

}
