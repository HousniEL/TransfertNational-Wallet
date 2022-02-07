package com.example.Bank_wallet;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Bank_wallet.Datas.MultiTransfer;
import com.example.Bank_wallet.Datas.Transfer;
import com.example.be.R;
import com.example.Bank_wallet.Restituer.RestituAdapter;
import com.example.Bank_wallet.Restituer.RestituModel;
import com.example.Bank_wallet.Retrofit.JsonPlaceHolderApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resitution extends AppCompatActivity /*implements RestituAdapter.onNoteListener*/ {
    private static final String MY_PREFS_NAME ="MyPrefsFile";
    RecyclerView recycler_view;
    RestituAdapter adapter;
    SearchView searchView;
    List<RestituModel> restitu_list;
    Button b,r;
    EditText c,motif;
    TextView ln,fn,idcard,montant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resitution);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("Token", null);//"No name defined" is the default value.
        int idName = prefs.getInt("Id", 0); //0 is the default value.
        b= findViewById(R.id.rechercheref);
        r= findViewById(R.id.restituerRR);
        c= findViewById(R.id.ref);
        motif=findViewById(R.id.motif3);
        ln=findViewById(R.id.lname);
        fn=findViewById(R.id.fname);
        idcard=findViewById(R.id.idcar);
        montant=findViewById(R.id.price);

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://ensa-api-transfer.herokuapp.com/api_client/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        c.getText();
        JsonPlaceHolderApi jsonPlaceHolderApi =  retrofit.create(JsonPlaceHolderApi.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<MultiTransfer> call = jsonPlaceHolderApi.getTransfer("Bearer "+name, idName,c.getText().toString());
                call.enqueue(new Callback<MultiTransfer>() {
                    @Override
                    public void onResponse(Call<MultiTransfer> call, Response<MultiTransfer> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getApplicationContext(),
                                    "Patientez...",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(getApplicationContext(),
                                "yes",Toast.LENGTH_SHORT).show();
                        MultiTransfer benef = response.body();



                        Transfer trsmodel = benef.getTransfers().get(0);
                        Log.i(TAG, "onResponse1111: "+trsmodel.getReceiver_lname());
                        ln.setText(trsmodel.getReceiver_lname());
                        fn.setText(trsmodel.getReceiver_fname());
                        idcard.setText(trsmodel.getReceiver_phnumber());
                        String t=String.valueOf(trsmodel.getTransfer_amount());
                        montant.setText(t+"Dhs");


                    }


                    @Override
                    public void onFailure(Call<MultiTransfer> call, Throwable t) {
                        Log.d("TAG","kk = "+t.toString());
                        Toast.makeText(getApplicationContext(),
                                "Done",Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<MultiTransfer> call1 = jsonPlaceHolderApi.putTransfer("Bearer "+name, idName,c.getText().toString(),motif.getText().toString());
                call1.enqueue(new Callback<MultiTransfer>() {
                    @Override
                    public void onResponse(Call<MultiTransfer> call, Response<MultiTransfer> response) {
                        if(!response.isSuccessful()){
                            Log.d("TAG","kkk1= "+response.toString());
                            Toast.makeText(getApplicationContext(),
                                    "Ce payment est deja restitue",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(getApplicationContext(),
                                "Vous avez restitue le payment",Toast.LENGTH_SHORT).show();


                    }


                    @Override
                    public void onFailure(Call<MultiTransfer> call, Throwable t) {
                        Log.d("TAG","...= "+t.toString());
                        Toast.makeText(getApplicationContext(),
                                "Ce payment a deja ete restitue",Toast.LENGTH_SHORT).show();


                    }
                });


            }
        });

    }
}