package com.example.Bank_wallet.Restituer;

import android.widget.Button;
import android.widget.TextView;

public class RestituModel {



        String id;
        String name;
        String payment;
        String res;

        public RestituModel(String id,String name,String payment){
            this.id=id;
            this.name=name;
            this.payment=payment;

        }

        public RestituModel(String id, String name, String payment, String res){
            this.id=id;
            this.name=name;
            this.payment=payment;
            this.res=res;

        }
        public String getRes(){return res;}


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


