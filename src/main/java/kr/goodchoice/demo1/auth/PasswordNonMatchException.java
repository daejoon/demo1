package kr.goodchoice.demo1.auth;

public class PasswordNonMatchException extends RuntimeException {
    public PasswordNonMatchException() {
    }

    public PasswordNonMatchException(String message) {
        super(message);
    }

    public PasswordNonMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNonMatchException(Throwable cause) {
        super(cause);
    }

    public PasswordNonMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
