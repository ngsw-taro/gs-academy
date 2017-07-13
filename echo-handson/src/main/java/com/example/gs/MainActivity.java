package com.example.gs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Dialog.OnCancelListener {

    EchoService echoService;

    EditText editText;

    Button submitButton;

    Call<EchoResponse> call;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupServices();
        setupViews();
    }

    /**
     * サービスのセットアップ
     */
    private void setupServices() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://echo.jsontest.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        echoService = retrofit.create(EchoService.class);
    }

    /**
     * ビューのセットアップ
     */
    private void setupViews() {
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        /* ボタンを取得し、タップ時の処理を登録する */
    }

    /**
     * 送信ボタンが押されたときの処理
     */
    private void onSubmitButtonClicked() {
        final ProgressDialogFragment dialog = new ProgressDialogFragment();
        dialog.show(getSupportFragmentManager(), "dialog");

        final String text = editText.getText().toString();
        call = echoService.echo(text);
        call.enqueue(new Callback<EchoResponse>() {
            @Override
            public void onResponse(final Call<EchoResponse> call, final Response<EchoResponse> response) {
                dialog.dismiss();

                if (response.isSuccessful()) {
                    final EchoResponse echoResponse = response.body();
                    /* エコーの結果を渡して、EchoActivityを起動する */
                } else {
                    showToast("失敗しました: " + response.code());
                }
            }

            @Override
            public void onFailure(final Call<EchoResponse> call, final Throwable t) {
                dialog.dismiss();
                showToast("失敗しました: " + t.getMessage());
            }
        });
    }

    /**
     * トーストを表示する
     */
    private void showToast(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * ダイアログがキャンセルされたときの処理
     */
    @Override
    public void onCancel(final DialogInterface dialogInterface) {
        tryToCancel();
    }

    @Override
    protected void onDestroy() {
        tryToCancel();
        super.onDestroy();
    }

    /**
     * WebAPI呼び出し処理のキャンセルを試みる
     */
    private void tryToCancel() {
        if (call != null) {
            call.cancel();
        }
    }
}
