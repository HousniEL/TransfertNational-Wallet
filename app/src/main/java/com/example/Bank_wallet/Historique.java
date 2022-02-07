package com.example.Bank_wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.Bank_wallet.Datas.MultiTransfer;

import com.example.Bank_wallet.Datas.Transfer;

import com.example.Bank_wallet.Payment.PaymentAdapter;
import com.example.be.R;
import com.example.Bank_wallet.Retrofit.JsonPlaceHolderApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Historique extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "MyPrefsFile";
    RecyclerView recycler_view;
    PaymentAdapter adapter;
    SearchView searchView;
    List<Transfer> arrayList2= new ArrayList<>();
    ArrayList arrayList3= new ArrayList();
    List<MultiTransfer> arrayList1;
    List<Transfer> payment_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("Token", null);//"No name defined" is the default value.
        int idName = prefs.getInt("Id", 0);
        recycler_view = findViewById(R.id.recycler_view);
        searchView= findViewById(R.id.action_search);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://ensa-api-transfer.herokuapp.com/api_client/MultiTransfers/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        JsonPlaceHolderApi jsonPlaceHolderApi =  retrofit.create(JsonPlaceHolderApi.class);
        Call<List<MultiTransfer>> call1 = jsonPlaceHolderApi.getMultitransfers(name,idName);
        call1.enqueue(new Callback<List<MultiTransfer>>() {
            @Override
            public void onResponse(Call<List<MultiTransfer>> call, Response<List<MultiTransfer>> response) {
                Log.i("response",response.body().toString());
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),
                            "...", Toast.LENGTH_SHORT).show();
                    return;
                }



                List<MultiTransfer> benef = response.body();
               // Log.i("benef",benef)
                Log.i("tttt", String.valueOf(benef));
                for (MultiTransfer benefmodel : benef) {
                        Log.i("f", benefmodel.getSender_fname());
                        payment_list = benefmodel.getTransfers();
                        for (Transfer trsmodel : benefmodel.getTransfers()) {
                            arrayList2.add(new Transfer(trsmodel.getTransfer_reference(), trsmodel.getReceiver_lname(), trsmodel.getTransfer_amount()));
                        }

                        // arrayList1.add(new MultiTransferDTO(benefmodel.getTransfers()));
                        Log.i("thissss25", String.valueOf(arrayList2));
                        //Log.i("thissss", String.valueOf(arrayList1));

                        setRecyclerView(arrayList2);







                    Log.i("thissss", String.valueOf(arrayList3));


                    Log.i("thiss12", String.valueOf(arrayList3));


                }}
            @Override
            public void onFailure(Call<List<MultiTransfer>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
                Toast.makeText(getApplicationContext(),
                        "Redirecting...",Toast.LENGTH_SHORT).show();
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }

            private void filter(String newText) {
                List<Transfer> filteredList = new ArrayList<>();
                for(Transfer item: arrayList2 ){
                    if(item.getTransfer_reference().toLowerCase().contains(newText.toLowerCase())){
                        filteredList.add(item);
                    }
                }
                adapter.filterList(filteredList);
            }
        });
    }
    private void setRecyclerView(List<Transfer> a) {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PaymentAdapter(a);
        recycler_view.setAdapter(adapter);

    }
    private List<Transfer> getList(){
        payment_list =  new ArrayList<>();

        /*
        payment_list.add(new PaymentModel("3","Mona","5000"));*/
        Log.i("pay", String.valueOf(payment_list));
        return payment_list;
    }

}