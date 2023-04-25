package co.com.certification.serenitydemo.questions;

import co.com.certification.serenitydemo.exeptions.ErrorUserLogged;
import co.com.certification.serenitydemo.userinterfaces.MenuBarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

public class ValidatesLoggedUser implements Question<String> {

    public static Question<String> isDisplayed() {
        return new ValidatesLoggedUser();
    }

    @Override
    @Step("{0} searches user logged name")
    public String answeredBy(Actor actor) {
        if (MenuBarPage.LABEL_USER.resolveFor(actor).isVisible()) {
            return MenuBarPage.LABEL_USER.resolveFor(actor).getText();
        } else {
            throw new ErrorUserLogged(ErrorUserLogged.VALIDATE_USER_LOGGED);
        }

    }
}
