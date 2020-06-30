package utils;

import javax.servlet.http.HttpServletRequest;

public class ServletUtils {

    public static final String NAME_PARAMETER_KEY = "name";
    public static final String PASSWORD_PARAMETER_KEY = "password";

    public static final String GREETINGS_KEY = "greetings";

    public static final String ACCOUNT_MANAGER_kEY = "account manager";

    public static void setAtributes(HttpServletRequest req, String title, String h1Message, String additionalMessage){
        req.setAttribute("title", title);
        req.setAttribute("h1Message", h1Message);
        req.setAttribute("additionalMessage", additionalMessage);
    }
}
