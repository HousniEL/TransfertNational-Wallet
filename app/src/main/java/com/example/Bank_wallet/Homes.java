package com.example.Bank_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Bank_wallet.Datas.Client;
import com.example.be.R;
import com.example.Bank_wallet.Retrofit.JsonPlaceHolderApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Homes extends AppCompatActivity {
    private static final String MY_PREFS_NAME ="MyPrefsFile";
    private static final String MY_PREFS_NAME1 = "my_pref";
    Button historique;
    Button transfert,restitution;
    TextView ln,fn,idcard,phone,adress,title;
    int id;
    String is, token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("Token", null);//"No name defined" is the default value.
        int idName = prefs.getInt("Id", 0); //0 is the default value.
        //Intent intent = getIntent();
        //is = intent.getStringExtra("Id");
       // token = intent.getStringExtra("token");
        historique = (Button) findViewById(R.id.Historique);
        restitution = (Button) findViewById(R.id.restitution);
        transfert = (Button) findViewById(R.id.Transfert);
        ln=findViewById(R.id.lastname);
        fn=findViewById(R.id.firstname);
        idcard=findViewById(R.id.cardid);
        phone=findViewById(R.id.phone);
        adress=findViewById(R.id.adress);
        title=findViewById(R.id.title);




        historique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),
                        //"Redirecting...", Toast.LENGTH_SHORT).show();
                Intent historique = new Intent(Homes.this, Historique.class);
                startActivity(historique);

            }

        });
        restitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "Redirecting...", Toast.LENGTH_SHORT).show();
                Intent res = new Intent(Homes.this, Resitution.class);
                startActivity(res);

            }

        });

        transfert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "Redirecting...", Toast.LENGTH_SHORT).show();
                Intent trans = new Intent(Homes.this, Transfert.class);
                startActivity(trans);

            }

        });
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://ensa-api-transfer.herokuapp.com/api_client/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi =  retrofit.create(JsonPlaceHolderApi.class);


        Call<Client> call = jsonPlaceHolderApi.getclient("Bearer "+name, idName);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),
                            "...",Toast.LENGTH_SHORT).show();
                    return;
                }
                Client client = response.body();

                String content="";
                title.setText(client.getTitle());
                    ln.setText(client.getLastName());
                idcard.setText(client.getIdCard());
                phone.setText(client.getPhoneNumber());
                adress.setText(client.getAddress());
                fn.setText(client.getFirstName());
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME1, MODE_PRIVATE).edit();
                editor.putString("fn", client.getFirstName());
                editor.putString("ln", client.getLastName());
                editor.putString("pn", client.getPhoneNumber());
                //editor.putInt("fname", response.body().getId());
                // editor.putInt("", response.body().getId());
                editor.apply();


                    content+="FirstName" +client.getFirstName()+"\n";
                    content+="LastName"+client.getLastName()+"\n";
                    content+="IDcard" +client.getIdCard()+"\n";
                 content+="PhoneNumber" +client.getPhoneNumber()+"\n";
                  content+="adress" +client.getAddress()+"\n";
                //content+="ID" +client.get+"\n";

                    //Intent home = new Intent(MainActivity.this, Homes.class);
                    Log.i("...","!");
                    //startActivity(home);

                }


            @Override
            public void onFailure(Call<Client> call, Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Redirecting...",Toast.LENGTH_SHORT).show();

            }
    });
    }



    }