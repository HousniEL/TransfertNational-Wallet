package com.example.Bank_wallet.Payment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Bank_wallet.Datas.MultiTransfer;

import com.example.Bank_wallet.Datas.Transfer;

import com.example.be.R;

import java.util.ArrayList;
import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder> implements Filterable {

    Context context;
    List<Transfer> payment_list;
    List<Transfer>  payment_listFull;
    List<MultiTransfer> pay_list;
    Button button;
    TextView textView;
    OnItemClickListener listener;
    public PaymentAdapter(Context context, List<Transfer> payment_list) {
        this.context = context;
        this.payment_list = payment_list;
    }

    /*public PaymentAdapter(List<TransferDTO> list) {
        this.pay_list=list;
        //payment_listFull = new ArrayList<>(payment_list);
    }*/
   /* public PaymentAdapter(List<MultiTransferDTO> list) {
        this.pay_list=list;
        //payment_listFull = new ArrayList<>(payment_list);
    }*/
    public PaymentAdapter(List<Transfer> list, Button b) {
        this.payment_list=list;
        this.button=b;

    }

    public PaymentAdapter(List<Transfer> arrayList2) {
        this.payment_list=arrayList2;
        payment_listFull = new ArrayList<>(payment_list);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(payment_list!=null && payment_list.size()>0){
            Transfer model=payment_list.get(position);
            holder.id_tv.setText((model.getTransfer_reference()));
            holder.name_tv.setText((model.getReceiver_lname()));
            holder.payment_tv.setText(String.valueOf(model.getTransfer_amount()));


        }else{
            return;
        }
    }
    public interface OnItemClickListener{
        void onRestClick(int position);
    }

    @Override
    public int getItemCount() {
        return payment_list.size();
    }

    @Override
    public Filter getFilter() {
        return payment_filter;
    }

    public Filter payment_filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Transfer> filteredList= new ArrayList<>();
            if (constraint ==  null || constraint.length() == 0){
                filteredList.addAll(payment_listFull);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(Transfer item:payment_listFull){
                    if(item.getTransfer_reference().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            payment_list.clear();
            payment_list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public void filterList(List<Transfer> filteredList) {
        payment_list=filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView id_tv,name_tv,payment_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_tv=itemView.findViewById(R.id.id_tv);
            name_tv=itemView.findViewById(R.id.name_tv);
            payment_tv=itemView.findViewById(R.id.payment_tv);

        }
    }

}
