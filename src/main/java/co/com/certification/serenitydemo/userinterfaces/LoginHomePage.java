package co.com.certification.serenitydemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginHomePage extends PageObject {

    public static final Target TXT_USER = Target.the("user name").located(By.id("LoginPanel0_Username"));
    public static final Target TXT_PASSWORD = Target.the("password").located(By.id("LoginPanel0_Password"));
    public static final Target BTN_LOGIN = Target.the("login").located(By.id("LoginPanel0_LoginButton"));
    public static final Target TEXT_WRONG_LOGIN = Target.the("wrong user or password!").located(By.id("toast-container"));

}