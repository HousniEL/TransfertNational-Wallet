package com.example.Bank_wallet.Datas;

import java.util.List;

public class MultiTransfer {
    public MultiTransfer(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public MultiTransfer(int idName, String fn, String ln, String pn, float toString, float v, int i, String test_client, boolean b, List<Transfer> l1) {
        this.id_client=idName;
        this.sender_fname=fn;
        this.sender_lname=ln;
        this.sender_phnumber=pn;
        this.total_amount=toString;
        this.total_expense_amount=v;
        this.expense_id=i;
        this.motif=test_client;
        this.notify_transfer=b;
        this.transfers=l1;

    }

  /*  public MultiTransfer(int idName, String fn, String ln, String pn, int i, double v, int i1, String test_client, boolean b, Transfer transfer) {
        this.sender_fname=fn;
        this.sender_lname=ln;
        this.sender_phnumber=pn;

        this.transfers=transfer;
    }*/

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getEnded_at() {
        return ended_at;
    }

    public void setEnded_at(String ended_at) {
        this.ended_at = ended_at;
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public String getSender_fname() {
        return sender_fname;
    }

    public void setSender_fname(String sender_fname) {
        this.sender_fname = sender_fname;
    }

    public String getSender_lname() {
        return sender_lname;
    }

    public void setSender_lname(String sender_lname) {
        this.sender_lname = sender_lname;
    }

    public String getSender_phnumber() {
        return sender_phnumber;
    }

    public void setSender_phnumber(String sender_phnumber) {
        this.sender_phnumber = sender_phnumber;
    }

    public Float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Float total_amount) {
        this.total_amount = total_amount;
    }

    public Float getTotal_expense_amount() {
        return total_expense_amount;
    }

    public void setTotal_expense_amount(Float total_expense_amount) {
        this.total_expense_amount = total_expense_amount;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public boolean isTransfer_by_cash() {
        return transfer_by_cash;
    }

    public void setTransfer_by_cash(boolean transfer_by_cash) {
        this.transfer_by_cash = transfer_by_cash;
    }

    public boolean isNotify_transfer() {
        return notify_transfer;
    }

    public void setNotify_transfer(boolean notify_transfer) {
        this.notify_transfer = notify_transfer;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public boolean isRequest_by_prospect_client() {
        return request_by_prospect_client;
    }

    public void setRequest_by_prospect_client(boolean request_by_prospect_client) {
        this.request_by_prospect_client = request_by_prospect_client;
    }

    public int getSended_by_agent() {
        return sended_by_agent;
    }

    public void setSended_by_agent(int sended_by_agent) {
        this.sended_by_agent = sended_by_agent;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public int getId_multitransfer() {
        return id_multitransfer;
    }

    public void setId_multitransfer(int id_multitransfer) {
        this.id_multitransfer = id_multitransfer;
    }

    private String created_at;
    private String  ended_at;
    private Integer id_client;
    private String sender_fname;
    private String sender_lname;
    private String sender_phnumber;
    private Float total_amount;
    private Float total_expense_amount;
    private int expense_id;
    private boolean transfer_by_cash;
    private boolean notify_transfer;
    private int client_id;
    private boolean request_by_prospect_client;
    private int sended_by_agent;
    private String motif;
    private List<Transfer> transfers;

    private int id_multitransfer;
    }

