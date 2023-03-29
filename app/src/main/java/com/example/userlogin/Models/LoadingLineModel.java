package com.example.userlogin.Models;

public class LoadingLineModel {
    private  String Description_2 , Length , Quantity , Free_Stock , UOM , Diameter , Loaded_Pieces , Pieces;

    public LoadingLineModel(String description_2, String length, String quantity, String free_Stock, String UOM, String diameter, String loaded_Pieces, String pieces) {
        Description_2 = description_2;
        Length = length;
        Quantity = quantity;
        Free_Stock = free_Stock;
        this.UOM = UOM;
        Diameter = diameter;
        Loaded_Pieces = loaded_Pieces;
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

    public String getFree_Stock() {
        return Free_Stock;
    }

    public void setFree_Stock(String free_Stock) {
        Free_Stock = free_Stock;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public String getDiameter() {
        return Diameter;
    }

    public void setDiameter(String diameter) {
        Diameter = diameter;
    }

    public String getLoaded_Pieces() {
        return Loaded_Pieces;
    }

    public void setLoaded_Pieces(String loaded_Pieces) {
        Loaded_Pieces = loaded_Pieces;
    }

    public String getPieces() {
        return Pieces;
    }

    public void setPieces(String pieces) {
        Pieces = pieces;
    }
}
