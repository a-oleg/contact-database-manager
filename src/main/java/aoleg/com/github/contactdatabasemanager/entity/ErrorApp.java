package aoleg.com.github.contactdatabasemanager.entity;

import aoleg.com.github.contactdatabasemanager.enumeration.TypeError;

import java.util.TimeZone;

public class ErrorApp {
    String message;
    int code;
    TimeZone errorTime;
    TypeError type;
    String displayMessage;
}
