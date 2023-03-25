package com.example.userlogin.Models;

public class LoadingInvoiceModel {

    private String No , Customer_No , Customer_Name , Transporter_Name ;

    public LoadingInvoiceModel(String no, String customer_No, String customer_Name, String transporter_Name) {
        No = no;
        Customer_No = customer_No;
        Customer_Name = customer_Name;
        Transporter_Name = transporter_Name;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getCustomer_No() {
        return Customer_No;
    }

    public void setCustomer_No(String customer_No) {
        Customer_No = customer_No;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getTransporter_Name() {
        return Transporter_Name;
    }

    public void setTransporter_Name(String transporter_Name) {
        Transporter_Name = transporter_Name;
    }
}
