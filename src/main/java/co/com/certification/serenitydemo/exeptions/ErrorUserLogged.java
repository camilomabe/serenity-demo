package co.com.certification.serenitydemo.exeptions;

public class ErrorUserLogged extends AssertionError {

    public static final String VALIDATE_USER_LOGGED = ">>>>>>>>>> Cannot interact with the user's label!";

    public ErrorUserLogged(String failedMessage) {
        super(failedMessage);
    }
}