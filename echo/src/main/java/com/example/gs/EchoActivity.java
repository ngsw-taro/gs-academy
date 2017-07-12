package com.example.gs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class EchoActivity extends AppCompatActivity {

    static final String ECHO_EXTRA = "echo";

    public static Intent intent(final Context context, final String echo) {
        return new Intent(context, EchoActivity.class)
                .putExtra(ECHO_EXTRA, echo);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        final String echo = getIntent().getStringExtra(ECHO_EXTRA);

        TextView echoTextView = (TextView) findViewById(R.id.echo_text_view);
        echoTextView.setText(decode(echo));
    }

    private String decode(final String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
