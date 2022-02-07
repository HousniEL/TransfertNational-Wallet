package com.example.Bank_wallet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Bank_wallet.Benef.BenefAdapter;
import com.example.Bank_wallet.Benef.BenefModel;
import com.example.Bank_wallet.Datas.MultiTransfer;
import com.example.Bank_wallet.Datas.Transfer;
import com.example.be.R;
import com.example.Bank_wallet.Retrofit.JsonPlaceHolderApi;
import com.example.Bank_wallet.Spinner.SpinnerModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Transfert extends AppCompatActivity {


    private static final String MY_PREFS_NAME = "MyPrefsFile";
    private static final String MY_PREFS_NAME1 = "my_pref";
    private NotificationManagerCompat notificationManagerCompat;

    SpinnerAdapter adapter;
    com.example.Bank_wallet.Spinner.SpinnerAdapter adapters;
    BenefAdapter adapter2;
    Button send;
    Spinner spinner;
    Button ajouterbenef;
    String F,D,G;
    Button addben;
    RecyclerView recycler_view;
    ArrayList<SpinnerModel> arrayList = new ArrayList<>();
    ArrayList<SpinnerModel> arrayList1 = new ArrayList<>();
    ArrayList<BenefModel> arrayList2 = new ArrayList<>();
    ArrayList<BenefModel> arrayList3 = new ArrayList<>();
    AlertDialog dialog;
    LinearLayout layout;
    TextView txt;
    EditText edtxt;
    Button bdel;
    EditText motif;
    int a;
    ListView simpleList = null;
    private ArrayAdapter mAdapter;
    private Object NotificationApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_transfert);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel("My notification","My notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("Token", null);//"No name defined" is the default value.
        int idName = prefs.getInt("Id", 0);
        SharedPreferences prefs1 = getSharedPreferences(MY_PREFS_NAME1, MODE_PRIVATE);
        String fn = prefs1.getString("fn", null);//"No name defined" is the default value.
        String ln = prefs1.getString("ln", null);
        String pn = prefs1.getString("pn", null);
        motif=findViewById(R.id.motif4);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ensa-api-transfer.herokuapp.com/api_client/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<SpinnerModel>> call = jsonPlaceHolderApi.getlistbenef("Bearer " + name, idName);
        call.enqueue(new Callback<List<SpinnerModel>>() {
            @Override
            public void onResponse(Call<List<SpinnerModel>> call, Response<List<SpinnerModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),
                            "Veuillez Patienter...", Toast.LENGTH_SHORT).show();
                    return;
                }

                arrayList1 = new ArrayList<>();

                arrayList1 = new ArrayList<>();

                String content = " ";
                List<SpinnerModel> benef = response.body();
                for (SpinnerModel benefmodel : benef) {
                    Log.i("f", benefmodel.getAccount_number());
                    arrayList1.add(new SpinnerModel(benefmodel.getAccount_number(), benefmodel.getFirstName(), benefmodel.getLastName(),benefmodel.getPhoneNumber()));
                    Log.i("thissss", String.valueOf(arrayList1));

                    content += "FirstName" + benefmodel.getFirstName() + "\n";
                    content += "LastName" + benefmodel.getLastName() + "\n";
                    content += "Phone number" + benefmodel.getPhoneNumber() + "\n";
                    content += "PhoneNumber" + benefmodel.getAccount_number() + "\n";



                    Log.i("...", "!");
                    //startActivity(home);

                }
                Log.i("thissss", String.valueOf(arrayList1));

                // spinner.setSelection(0);
                //spinner.text
                Log.i("thiss12", String.valueOf(arrayList1));
                adapters = new com.example.Bank_wallet.Spinner.SpinnerAdapter(getApplicationContext(), R.layout.row, arrayList1);
                spinner.setAdapter(adapters);

            }

            @Override
            public void onFailure(Call<List<SpinnerModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Redirecting...", Toast.LENGTH_SHORT).show();
            }
        });


        // SpinnerAdapter adapter = new SpinnerAdapter(Transfert.this,R.layout.spinner)
        spinner = findViewById(R.id.spinner);
        txt = findViewById(R.id.ikik);
        send = findViewById(R.id.envoyertransfer);
        addben = (Button) findViewById(R.id.Ajouterbenefi);
        bdel = findViewById(R.id.deletbenef);
        //recycler_view =findViewById(R.id.recycler_view3);
        edtxt = findViewById(R.id.dkik);
        ajouterbenef = findViewById(R.id.ajouterbenef);
        bdel.setVisibility(View.INVISIBLE);
        //layout=findViewById(R.id.container1);
        //buildDialog();
        //setRecyclerView(a);
        //simpleList =findViewById(R.id.simpleListView);
        //setRecyclerView();
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                bdel.setVisibility(View.INVISIBLE);
            }
        });


                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        SpinnerModel myModel = (SpinnerModel) parent.getSelectedItem();
                        Log.e("dddDATA", myModel.getAccount_number());
                        Log.e("dddDATA", myModel.getLastName());
                        Log.i("ddddDATA", String.valueOf(position));
                        a = position;
                        Log.e("dddDATA", String.valueOf(a));
                        ajouterbenef.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bdel.setVisibility(View.VISIBLE);
                                com.example.Bank_wallet.Spinner.SpinnerAdapter customAdapter = new com.example.Bank_wallet.Spinner.SpinnerAdapter(getApplicationContext(), R.id.kik, arrayList1);
                                //content+="ID" +client.get+"\n";
                                if (edtxt.getText().length() == 0) {
                                    Toast.makeText(getApplicationContext(),
                                            "Le montant ne peut pas etre vide", Toast.LENGTH_SHORT).show();
                                } else {



                                    txt.setText(customAdapter.getItem(a).getLastName() + "-" +customAdapter.getItem(a).getFirstName() + "-" + customAdapter.getItem(a).getAccount_number() + "-" + customAdapter.getItem(a).getPhoneNumber() + "-"+ edtxt.getText() + "Dhs\n");
                                }

                            }
                        });



                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                //Intent register = new Intent(MainActivity.this, Register.class);
                //startActivity(register);
                //dialog.show();
                // setRecyclerView();
                //ArrayAdapter<String> arr;
                //arr = new ArrayAdapter<String>(this, R.layout.mylayout,simpleList );
                //simpleList.setAdapter(arr);
                Log.i("dddd1DATA", String.valueOf(a));
                //Log.i("dddd2DATA", String.valueOf(arrayList2.get(a)));
                // Log.i("dddd3DATA", String.valueOf(getList3().get(a)));
                Log.i("thissss1", String.valueOf(arrayList1));
                Log.i("lol", String.valueOf(arrayList1));


        addben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent res = new Intent(Transfert.this, Addbenef.class);
                startActivity(res);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List list = new ArrayList();


                com.example.Bank_wallet.Spinner.SpinnerAdapter customAdapter1 = new com.example.Bank_wallet.Spinner.SpinnerAdapter(getApplicationContext(), R.id.kik, arrayList1);
                List<Transfer> l1 =new ArrayList<>();

                String[] arrSplit =txt.getText().toString().split("-");

                Log.i("bla11",arrSplit[0]);
                Log.i("bla11",arrSplit[1]);
                Log.i("bla11",arrSplit[2]);
                Log.i("bla11",arrSplit[3]);


                int l=Integer.parseInt(edtxt.getText().toString());

                Transfer b=new Transfer(Float.parseFloat(edtxt.getText().toString()),1,arrSplit[1],arrSplit[0],arrSplit[3]);
                l1.add(b);
                Log.i("bla", String.valueOf(l1));
                Call<MultiTransfer> call2 = jsonPlaceHolderApi.postTransfer(name,idName,new MultiTransfer(idName,fn,ln,pn,Float.parseFloat(edtxt.getText().toString()), 230.5F,2,motif.getText().toString(),true, l1));
                call2.enqueue(new Callback<MultiTransfer>() {
                    @Override
                    public void onResponse(Call<MultiTransfer> call, Response<MultiTransfer> response) {

                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "Transfert effectuer", Toast.LENGTH_SHORT).show();


                            return;
                        }



                        Intent home = new Intent(Transfert.this, Homes.class);
                        addNotification();

                        Log.i("...", "...");
                        startActivity(home);
                        return;

                    }

                    @Override
                    public void onFailure(Call<MultiTransfer> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Transfert effectue",Toast.LENGTH_SHORT).show();

                    }
                });
            }

        });
    }

    private void addNotification() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "my_channel_01";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.ic_baseline_email_24)
                        .setContentTitle("Test Message")
                        .setContentText("another msg")
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
    };







