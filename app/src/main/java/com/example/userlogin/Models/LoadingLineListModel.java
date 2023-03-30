package com.example.userlogin.Models;

public class LoadingLineListModel {
    private String Description_2, Length, Quantity, Loading_Quantity, Remarks , Peices ,  Pieces ;


    public LoadingLineListModel(String description_2, String length, String quantity, String loading_Quantity, String remarks, String peices, String pieces ) {
        Description_2 = description_2;
        Length = length;
        Quantity = quantity;
        Loading_Quantity = loading_Quantity;
        Remarks = remarks;
        Peices = peices;
        Pieces = pieces;
    }


    public String getDescription_2() {
        return Description_2;
    }

    public void setDescription_2(String description_2) {
        Description_2 = description_2;
    }

    public String getLength() {
        return Length;
    }

    public void setLength(String length) {
        Length = length;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getLoading_Quantity() {
        return Loading_Quantity;
    }

    public void setLoading_Quantity(String loading_Quantity) {
        Loading_Quantity = loading_Quantity;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getPeices() {
        return Peices;
    }

    public void setPeices(String peices) {
        Peices = peices;
    }

    public String getPieces() {
        return Pieces;
    }

    public void setPieces(String pieces) {
        Pieces = pieces;
    }
}