package co.com.certification.serenitydemo.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class NavigateTo implements Task {

    @Override
    @Step("{0} opens the url serenity demo"  )
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url("https://serenity.is/demo"));
    }
}
