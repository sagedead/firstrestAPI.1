package pl.edu.vistula.RestAPI.sharedapiresponse;

public class errormessageresponse {

    private final String message;

    public errormessageresponse(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
