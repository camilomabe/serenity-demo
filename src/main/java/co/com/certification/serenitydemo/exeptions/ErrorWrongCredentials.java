package co.com.certification.serenitydemo.exeptions;

public class ErrorWrongCredentials extends AssertionError {

    public static final String VALIDATE_WRONG_TEXT_CREDENTIALS = ">>>>>>>>>> Cannot interact with the searched web element when the wrong credentials are typed!";

    public ErrorWrongCredentials(String wrongMessageCredential) {
        super(wrongMessageCredential);
    }
}