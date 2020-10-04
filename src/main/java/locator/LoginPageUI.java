package locator;

public class LoginPageUI {
    public static final String EMAIL_TEXTFIELD = "//label[contains(text(),'Email')]/following-sibling::div/input";
    public static final String PASSWORD_TEXTFIELD = "//label[contains(text(),'Password')]//following-sibling::div/input";
    public static final String LOGIN_BUTTON = "//button[contains(text(),'Login')]";
    public static final String LOGIN_HEADER = "//h3[contains(text(),'Sign In to Operative Underground')]";
    public static final String LOGIN_EMAIL_BUTTON = "//div[contains(text(),'Signin with Email')]";
    public static final String LOGIN_GMAIL_BUTTON = "//button[@data-test='google-auth-button']";
    public static final String GMAIL_EMAIL_TEXTFIELD = "//input[@id='identifierId' and @type='email']";
    public static final String GMAIL_NEXT_TO_PASSWORD_TEXTFIELD = "//span[@jsname='V67aGc']/following-sibling::div";
    public static final String GMAIL_PASSWORD_TEXTFIELD = "//input[@type='password']";
    public static final String LOGIN_FACEBOOK_BUTTON = "//div[contains(text(),'Signin with Facebook')]";
    public static final String LOGIN_FACEBOOK_EMAIL = "//input[@id='email']";
    public static final String LOGIN_FACEBOOK_PASSWORD = "//input[@id='pass']";
    public static final String LOGIN_FACEBOOK_POPUP_BUTTON = "//button[@id='loginbutton']";
}