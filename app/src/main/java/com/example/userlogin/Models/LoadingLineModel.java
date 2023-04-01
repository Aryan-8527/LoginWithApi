package com.example.userlogin.Models;

public class LoadingLineModel {
    private String Description_2, Length, Quantity, Loading_Quantity, Remarks , Peices ,  Pieces ;


    public LoadingLineModel(String description_2, String length, String quantity, String loading_Quantity, String remarks, String peices, String pieces ) {
        Description_2 = description_2;
        Length = length;
        Quantity = quantity;
        Loading_Quantity = loading_Quantity;
        Remarks = remarks;
        Peices = peices;
        Pieces = pieces;
    }

    public void setDescription_2(String description_2) {
        Description_2 = description_2;
    }

    public void setLength(String length) {
        Length = length;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public void setLoading_Quantity(String loading_Quantity) {
        Loading_Quantity = loading_Quantity;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public void setPeices(String peices) {
        Peices = peices;
    }

    public void setPieces(String pieces) {
        Pieces = pieces;
    }

    public String getDescription_2() {
        return Description_2;
    }



    public String getLength() {
        return Length;
    }



    public String getQuantity() {
        return Quantity;
    }


    public String getLoading_Quantity() {
        return Loading_Quantity;
    }


    public String getRemarks() {
        return Remarks;
    }


    public String getPeices() {
        return Peices;
    }


    public String getPieces() {
        return Pieces;
    }

}