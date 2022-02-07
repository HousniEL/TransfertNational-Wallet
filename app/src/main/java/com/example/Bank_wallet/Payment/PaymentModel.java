package com.example.Bank_wallet.Payment;

import android.widget.Button;
import android.widget.TextView;

public class PaymentModel {
    String id;
    String name;
    String payment;
    TextView res;

    public PaymentModel(String id,String name,String payment){
        this.id=id;
        this.name=name;
        this.payment=payment;

    }

    public PaymentModel(String id, String name, String payment, TextView res){
        this.id=id;
        this.name=name;
        this.payment=payment;
        this.res=res;

    }
    public TextView getRes(){return res;}


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPayment() {
        return payment;
    }
}
