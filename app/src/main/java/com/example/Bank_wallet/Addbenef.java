package com.example.Bank_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.be.R;
import com.example.Bank_wallet.Retrofit.JsonPlaceHolderApi;
import com.example.Bank_wallet.Spinner.SpinnerModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Addbenef extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "MyPrefsFile" ;
    EditText ln,fn,pn,an;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbenef);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("Token", null);//"No name defined" is the default value.
        int idName = prefs.getInt("Id", 0);
        btn=findViewById(R.id.button_submit);
        fn=findViewById(R.id.editText1);
        an=findViewById(R.id.editText2);
        pn=findViewById(R.id.editText3);
        ln=findViewById(R.id.editText5);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://ensa-api-transfer.herokuapp.com/api_client/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        JsonPlaceHolderApi jsonPlaceHolderApi =  retrofit.create(JsonPlaceHolderApi.class);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<SpinnerModel> call = jsonPlaceHolderApi.postbenef(name,idName,new SpinnerModel(an.getText().toString(),fn.getText().toString(),ln.getText().toString(),pn.getText().toString()));
                call.enqueue(new Callback<SpinnerModel>() {
                    @Override
                    public void onResponse(Call<SpinnerModel> call, Response<SpinnerModel> response) {

                        if(!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "KHDM MOK...", Toast.LENGTH_SHORT).show();
                            Intent home = new Intent(Addbenef.this, Transfert.class);

                            startActivity(home);


                            return;
                        }else{
                            //Log.i("blabla",response.body().getToken());

                            Intent home = new Intent(Addbenef.this, Transfert.class);

                            startActivity(home);
                            //return;
                        }
                    }

                    @Override
                    public void onFailure(Call<SpinnerModel> call, Throwable t) {
                        Intent home = new Intent(Addbenef.this, Transfert.class);

                        startActivity(home);

                    }
                });

            }
        });



            }
}