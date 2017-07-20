package com.example.gs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ValidationActivity extends AppCompatActivity {

    static final String VALIDATE_EXTRA = "validate";

    static final String ERROR_EXTRA = "error";

    public static Intent intent(final Context context, final Result result) {
        return new Intent(context, ValidationActivity.class)
                .putExtra(VALIDATE_EXTRA, result.isValidate())
                .putExtra(ERROR_EXTRA, result.getError());
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);

        final Intent intent = getIntent();
        final boolean validate = intent.getBooleanExtra(VALIDATE_EXTRA, false);
        final String error = intent.getStringExtra(ERROR_EXTRA);

        final TextView validateTextView = (TextView) findViewById(R.id.validate_text_view);
        validateTextView.setText(String.valueOf(validate));

        final TextView errorTextView = (TextView) findViewById(R.id.error_text_view);
        errorTextView.setText(error);
    }
}
