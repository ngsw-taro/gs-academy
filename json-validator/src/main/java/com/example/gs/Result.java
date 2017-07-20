package com.example.gs;

import android.support.annotation.Nullable;

public class Result {

    private final boolean validate;

    @Nullable
    private final String error;

    public Result(final boolean validate,
                  final String error) {
        this.validate = validate;
        this.error = error;
    }

    public boolean isValidate() {
        return validate;
    }

    @Nullable
    public String getError() {
        return error;
    }
}
