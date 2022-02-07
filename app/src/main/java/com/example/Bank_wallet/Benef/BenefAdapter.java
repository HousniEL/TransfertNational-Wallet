package com.example.Bank_wallet.Benef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.be.R;
import com.example.Bank_wallet.Spinner.SpinnerModel;

import java.util.List;

public class BenefAdapter extends RecyclerView.Adapter<BenefAdapter.ViewHolder>{

    Context context;
    List<SpinnerModel> benef_list;
    String c;
    public BenefAdapter(Context context, List<SpinnerModel> benef_list) {
        this.context = context;
        this.benef_list = benef_list;
    }

    public BenefAdapter(List<SpinnerModel> list) {
        this.benef_list=list;
       // payment_listFull = new ArrayList<>(payment_list);
    }
    public BenefAdapter(String s) {
        this.c=s;
        // payment_listFull = new ArrayList<>(payment_list);
    }

    @NonNull
    @Override
    public BenefAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout3,parent,false);
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull BenefAdapter.ViewHolder holder, int position) {
        if(benef_list!=null && benef_list.size()>0){
            SpinnerModel model=benef_list.get(position);
            holder.id_tv.setText((model.getAccount_number()));
            holder.name_tv.setText((model.getLastName()));
           // holder.payment_tv.setText((model.getPhone()));


        }else{
            return;
        }

    }

    @Override
    public int getItemCount() {
        return benef_list.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView id_tv,name_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_tv=itemView.findViewById(R.id.id2_tv);
            name_tv=itemView.findViewById(R.id.name2_tv);
            // payment_tv=itemView.findViewById(R.id.payment_tv);

        }
    }
}
