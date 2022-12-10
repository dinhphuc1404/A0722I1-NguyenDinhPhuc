package on_tap_1.utils;

public class NotFoundMedicalRecordException extends Exception{
    public NotFoundMedicalRecordException(String string) {
        super(string);
    }

    public NotFoundMedicalRecordException() {
        super("Invalid");
    }
}
