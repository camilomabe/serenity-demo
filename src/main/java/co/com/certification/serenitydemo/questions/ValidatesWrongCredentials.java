package co.com.certification.serenitydemo.questions;

import co.com.certification.serenitydemo.userinterfaces.LoginHomePage;
import co.com.certification.serenitydemo.exeptions.ErrorWrongCredentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.certification.serenitydemo.exeptions.ErrorWrongCredentials.VALIDATE_WRONG_TEXT_CREDENTIALS;

public class ValidatesWrongCredentials implements Question<String> {

    public static Question<String> showedText() {
        return new ValidatesWrongCredentials();
    }

    @Override
    @Step("{0} enters wrong user or password")
    public String answeredBy(Actor actor) {
        if (LoginHomePage.TEXT_WRONG_LOGIN.resolveFor(actor).isVisible()) {
            return LoginHomePage.TEXT_WRONG_LOGIN.resolveFor(actor).getText();
        } else {
            throw new ErrorWrongCredentials(VALIDATE_WRONG_TEXT_CREDENTIALS);
        }
    }
}
