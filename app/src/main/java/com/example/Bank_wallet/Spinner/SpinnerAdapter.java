package com.example.Bank_wallet.Spinner;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.be.R;

import java.util.ArrayList;
import java.util.Collections;

public class SpinnerAdapter extends ArrayAdapter<SpinnerModel> {
    private ArrayList<SpinnerModel> myarrayList;
    TextView label,label2;
    SpinnerModel myModel;
    String name;

    public SpinnerAdapter(Context context, int textViewResourceId, ArrayList<SpinnerModel> modelArrayList) {
        super(context, textViewResourceId, modelArrayList);
        this.myarrayList = modelArrayList;
    }

    public SpinnerAdapter(Context context, int textViewResourceId, SpinnerModel model) {
        super(context, textViewResourceId, Collections.singletonList(model));
        this.myModel = model;
    }

    public SpinnerAdapter(Context applicationContext, int kik, String name) {
        super(applicationContext,kik, Integer.parseInt(name));
        this.name=name;

    }


    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, parent);
    }

    @Nullable
    @Override
    public SpinnerModel getItem(int position) {
        return myarrayList.get(position);
    }
    public ListAdapter getItem1(int position){return (ListAdapter) myarrayList.get(position);

    }
    @Override
    public int getCount() {
        int count = myarrayList.size();
        //return count > 0 ? count - 1 : count;
        return count;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {


        return getCustomView(position, parent);
    }

    private View getCustomView(int position, ViewGroup parent) {
        SpinnerModel model = getItem(position);

        View spinnerRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

         label = spinnerRow.findViewById(R.id.it);
        label.setText(String.format("%s", model != null ? model.getFirstName() : ""));
         label2 = spinnerRow.findViewById(R.id.ic);
        label2.setText(String.format("%s", model != null ? model.getLastName()+"-" : ""));

        return spinnerRow;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }





    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {

       return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }




}
