package co.com.certification.serenitydemo.exeptions;

public class ErrorValidatingBusinessUnitName extends AssertionError {
    public static final String ERROR_VALIDATING_UNIT = ">>>>>>>>>> has problems trying to log in to the app!";

    public ErrorValidatingBusinessUnitName(String message) {
        super(message);
    }
}

