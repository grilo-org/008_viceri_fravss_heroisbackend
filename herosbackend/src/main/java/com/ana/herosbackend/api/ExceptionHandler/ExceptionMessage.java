package com.ana.herosbackend.api.ExceptionHandler;


public class ExceptionMessage {
    private int httpCode;
    private String errorClass;
    private String message;


    private ExceptionMessage(Builder builder) {
        this.httpCode = builder.httpCode;
        this.errorClass = builder.errorClass;
        this.message = builder.message;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getErrorClass() {
        return errorClass;
    }

    public String getMessage() {
        return message;
    }


    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private int httpCode;
        private String errorClass;
        private String message;

        public Builder httpCode(int httpCode) {
            this.httpCode = httpCode;
            return this;
        }

        public Builder errorClass(String errorClass) {
            this.errorClass = errorClass;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ExceptionMessage build() {
            return new ExceptionMessage(this);
        }
    }
}