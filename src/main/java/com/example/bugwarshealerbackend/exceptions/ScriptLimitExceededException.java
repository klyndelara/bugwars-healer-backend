package com.example.bugwarshealerbackend.exceptions;

public class ScriptLimitExceededException extends RuntimeException {

    public ScriptLimitExceededException(String message) {
        super(message);
    }

}
