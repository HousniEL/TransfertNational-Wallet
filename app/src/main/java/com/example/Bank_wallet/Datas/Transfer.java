package com.example.Bank_wallet.Datas;

import android.text.Editable;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public class Transfer {

    public Transfer(String transfer_reference, String receiver_lname, float transfer_amount) {
        this.transfer_reference=transfer_reference;
        this.receiver_lname=receiver_lname;
        this.transfer_amount=transfer_amount;
    }

    private float transfer_amount;
    private String transfer_reference ;
    private int transfer_status;
    private Date received_at;
    private String receiver_fname;
    private String receiver_lname;
    private String receiver_phnumber;
    private String id_multitransfer;
    private String motif="";
    private Integer id_transfer;




    public Transfer(float parseInt, int i, String firstName, String lastName, String phoneNumber) {
        this.transfer_amount=parseInt;
        this.transfer_status=i;
        this.receiver_fname=firstName;
        this.receiver_lname=lastName;
        this.receiver_phnumber=phoneNumber;
    }

    public float getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(float transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    public String getTransfer_reference() {
        return transfer_reference;
    }

    public void setTransfer_reference(String transfer_reference) {
        this.transfer_reference = transfer_reference;
    }

    public int getTransfer_status() {
        return transfer_status;
    }

    public void setTransfer_status(int transfer_status) {
        this.transfer_status = transfer_status;
    }

    public Date getReceived_at() {
        return received_at;
    }

    public void setReceived_at(Date received_at) {
        this.received_at = received_at;
    }

    public String getReceiver_fname() {
        return receiver_fname;
    }

    public void setReceiver_fname(String receiver_fname) {
        this.receiver_fname = receiver_fname;
    }

    public String getReceiver_lname() {
        return receiver_lname;
    }

    public void setReceiver_lname(String receiver_lname) {
        this.receiver_lname = receiver_lname;
    }

    public String getReceiver_phnumber() {
        return receiver_phnumber;
    }

    public void setReceiver_phnumber(String receiver_phnumber) {
        this.receiver_phnumber = receiver_phnumber;
    }

    public String getId_multitransfer() {
        return id_multitransfer;
    }

    public void setId_multitransfer(String id_multitransfer) {
        this.id_multitransfer = id_multitransfer;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Integer getId_transfer() {
        return id_transfer;
    }

    public void setId_transfer(Integer id_transfer) {
        this.id_transfer = id_transfer;
    }
}
