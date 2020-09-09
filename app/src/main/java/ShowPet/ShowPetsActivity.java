package ShowPet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.GestureUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tst.Login.LogInActivity;
import com.example.tst.R;

import java.util.ArrayList;
import java.util.List;

import remote.ApiClient;
import remote.animals.Animal;
import remote.animals.Animals;
import remote.apiTokenService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPetsActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    RecyclerView recyclerView;
    ShowPetsAdapter adapter;
    apiTokenService api;
    List<Animal> animal;
    ShowPetsAdapter mAdapter;
    Button logout;
    LinearLayoutManager mLayoutmanager;
    Call<Animals> call;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pets_recyclerview);

        recyclerView = findViewById(R.id.show_petts_recycler);
        logout = findViewById(R.id.Logout);

        mLayoutmanager = new LinearLayoutManager(ShowPetsActivity.this);

        final SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String token = prefs.getString("PreferenceToken", "");
        Intent i = getIntent();
        String str = i.getStringExtra("LoginToken");
        Toast.makeText(this, "" + str, Toast.LENGTH_SHORT).show();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.remove("CLIENT_ID");
                editor.remove("CLIENT_SECRET");
                editor.remove("PreferenceToken");
                editor.commit();
                Intent goBackToLogin = new Intent(ShowPetsActivity.this, LogInActivity.class);
                startActivity(goBackToLogin);

            }
        });


        api = ApiClient.getClient().create(apiTokenService.class);
        if (token.equals("")) {

            call = api.getAllAnimals("Bearer " + str);
        } else {
            call = api.getAllAnimals("Bearer " + token);

        }

        call.enqueue(new Callback<Animals>() {
            @Override
            public void onResponse(Call<Animals> call, Response<Animals> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ShowPetsActivity.this, "" + response.body().getAnimals(), Toast.LENGTH_SHORT).show();

                    animal = new ArrayList<>();


                    recyclerView.setLayoutManager(mLayoutmanager);

                    animal.addAll(response.body().getAnimals());

                    mAdapter = new ShowPetsAdapter(getApplicationContext(), animal);

                    recyclerView.setAdapter(mAdapter);

                }
            }

            @Override
            public void onFailure(Call<Animals> call, Throwable t) {
                Toast.makeText(ShowPetsActivity.this, "Unexpected Error", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
