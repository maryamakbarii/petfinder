package com.example.tst.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.example.tst.R;

import remote.ApiClient;
import remote.animals.Animals;
import remote.apiToken;
import remote.apiTokenService;
import ShowPet.ShowPetsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {
    CheckBox checkbox;
    EditText username, edtPassword;
    Button btn_entry;
    /*
    For Behnam
        String CLIENT_ID = "sitwi08eZx5gQqFxnd36SOVIYuXIjKEpJc3ZVJYYAmyBNMQP9P";
        String CLIENT_SECRET = "rUF5NfKbEjBx43KsD9tedsQxDuqKm4zuPkqcJZbi";
        --------------------------------------------------------------
    For Ehsan
        CLIENT_ID -> CgtmM2KEYZB6TCJ8ZjYgnMGg9cHSITVKDrRQ3Dv7zWDfDMoNQ4
        CLIENT_SECRET -> tTaukVRyVb7H1x8N3LEiJxTUnMsC4CMlOPxwWu15
        --------------------------------------------------------------
    For Maryam
      CLIENT_ID ->  uZZwgeCxla5CKnX8vBCqVxPllu5rhujcsZEaDyNzVM0efXT1Yw
      CLIENT_SECRET -> m8jMfznFC7lsMhfjGu5b9nLpY5dGNVlEedzhqMSd
      --------------------------------------------------------------
      For Aqa Shojaei
       CLIENT_ID -> DbUKvmkgXMxPD4fTt3EkJCYcGfbPX9qNrlBX1zY770rxwtvC0r
       CLIENT_SECRET -> 5ztsJj38Ww8teJpw1qDhVEwLz9AOHXs9wWkfgHY4
     */

    apiTokenService api;
    String CLIENT_ID = "";
    String CLIENT_SECRET = "";
    public static final String MyPREFERENCES = "MyPrefs";
    String Token;
    SharedPreferences saveToken;
    String localToken;
    String input1 = "";
    String input2 = "";
    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        api = ApiClient.getClient().create(apiTokenService.class);


        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        token = prefs.getString("PreferenceToken", "");
        input1 = prefs.getString("CLIENT_ID", "");
        input2 = prefs.getString("CLIENT_SECRET", "");
        Toast.makeText(this, "" + input1 + "\n" + input2 + "\n" + token + "\n", Toast.LENGTH_SHORT).show();

        btn_entry = findViewById(R.id.loginButton);
        checkbox = (AppCompatCheckBox) findViewById(R.id.checkbox);
        edtPassword = findViewById(R.id.passwordInputEditText);
        username = findViewById(R.id.usernameInputEditText);


        if (!(input1.equals("") && input2.equals(""))) {

            Intent intent = new Intent(LogInActivity.this, ShowPetsActivity.class);

            intent.putExtra("PreferenceToken", token);
            startActivity(intent);
        } else {

            btn_entry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CLIENT_ID = username.getText().toString();

                    CLIENT_SECRET = edtPassword.getText().toString();

                    if (!(CLIENT_ID.equals("") && CLIENT_SECRET.equals(""))) {
                        login(api, CLIENT_ID, CLIENT_SECRET);

                    } else {
                        Toast.makeText(LogInActivity.this, "please input your password or username", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }


    }

    public void login(apiTokenService api, String id, String SECRET) {
        Call<apiToken> call = api.getToken("client_credentials", id, SECRET);

        call.enqueue(new Callback<apiToken>() {
            @Override
            public void onResponse(Call<apiToken> call, Response<apiToken> response) {
                if (response.isSuccessful()) {
                    saveToken = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = saveToken.edit();

                    editor.putString("CLIENT_ID", CLIENT_ID);
                    editor.putString("CLIENT_SECRET", CLIENT_SECRET);
                    editor.putString("PreferenceToken", response.body().getAccessToken());
                    editor.commit();
                    Intent intent = new Intent(LogInActivity.this, ShowPetsActivity.class);
                    intent.putExtra("LoginToken", response.body().getAccessToken());
                    startActivity(intent);

                    Token = response.body().getAccessToken();
                    Toast.makeText(LogInActivity.this, "get Token" + Token, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(LogInActivity.this, "authentication failed", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<apiToken> call, Throwable t) {
                Toast.makeText(LogInActivity.this, "failed :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAnimals(apiTokenService api) {

        Call<Animals> animalsCall = api.getAllAnimals("Bearer " + Token);
        animalsCall.enqueue(new Callback<Animals>() {
            @Override
            public void onResponse(Call<Animals> call, Response<Animals> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(LogInActivity.this, "getting animals Successful :)" + Token, Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(LogInActivity.this, "getting animals failure :(", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Animals> call, Throwable t) {
                Toast.makeText(LogInActivity.this, "getting animals onFailure :(", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

