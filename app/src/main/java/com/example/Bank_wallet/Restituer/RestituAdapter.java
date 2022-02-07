package com.example.Bank_wallet.Restituer;

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


import com.example.be.R;

import java.util.ArrayList;
import java.util.List;

public class RestituAdapter extends RecyclerView.Adapter<RestituAdapter.ViewHolder>  implements Filterable{

    Context context;
    List<RestituModel> restitu_list;
    List<RestituModel>  restitu_listFull;
    Button button;
    TextView textView;
    private  onNoteListener mOnNoteListener;
    RestituAdapter.OnItemClickListener listener;
    public RestituAdapter(Context context, List<RestituModel> restitu_list) {
        this.context = context;
        this.restitu_list = restitu_list;
    }

    public RestituAdapter(List<RestituModel> list) {
        this.restitu_list=list;
        restitu_listFull = new ArrayList<>(restitu_list);
    }
    public RestituAdapter(List<RestituModel> list,onNoteListener onNoteListener) {
        this.restitu_list=list;
        this.mOnNoteListener=onNoteListener;
    }



    @NonNull
    @Override
    public RestituAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2,parent,false);
        return new RestituAdapter.ViewHolder(view,mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RestituAdapter.ViewHolder holder, int position) {
        if(restitu_list!=null && restitu_list.size()>0){
            RestituModel model=restitu_list.get(position);
            holder.id_tv.setText((model.getId()));
            holder.name_tv.setText((model.getName()));
            holder.payment_tv.setText((model.getPayment()));
            holder.restituer_tv.setText(model.getRes());


        }else{
            return;
        }
    }

    @Override
    public Filter getFilter() {
        return restitu_filter;
    }


    public Filter restitu_filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<RestituModel> filteredList= new ArrayList<>();
            if (constraint ==  null || constraint.length() == 0){
                filteredList.addAll(restitu_listFull);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(RestituModel item:restitu_listFull){
                    if(item.getName().toLowerCase().contains(filterPattern)){
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
            restitu_list.clear();
            restitu_list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public void filterList(List<RestituModel> filteredList) {
        restitu_list=filteredList;
        notifyDataSetChanged();
    }


    public interface OnItemClickListener{
        void onRestClick(int position);
    }

    @Override
    public int getItemCount() {
        return restitu_list.size();
    }





    public class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView id_tv,name_tv,payment_tv,restituer_tv;
        Button restitu_tv;
        onNoteListener onNoteListener;
        public ViewHolder(@NonNull View itemView,onNoteListener onNoteListener) {
            super(itemView);
            id_tv=itemView.findViewById(R.id.id1_tv);
            name_tv=itemView.findViewById(R.id.name1_tv);
            payment_tv=itemView.findViewById(R.id.payment1_tv);
            restituer_tv=itemView.findViewById(R.id.restituer_tv);
            this.onNoteListener=onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());

        }
    }
    public interface onNoteListener{
        void onNoteClick(int position);

    }

}
