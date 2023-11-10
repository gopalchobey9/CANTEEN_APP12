package com.example.canteen_app12;

public class orderd_details {

    // string variable for
    // storing employee name.
    private String foodname;

    // string variable for storing
    // employee contact number
    private String quantity;

    // string variable for storing
    // employee address.
    private String table;
    boolean flag=false;
    private  String tablen;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public orderd_details() {

    }
    public orderd_details(String foodname,String  quantity,Boolean flag,String tablen){
        this.foodname=foodname;
        this.quantity=quantity;
        this.flag=flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getTablen() {
        return tablen;
    }

    public void setTablen(String tablen) {
        this.tablen = tablen;
    }

    // created getter and setter methods
    // for all our variables.
    public String getFoodName() {
        return foodname;
    }

    public void setFoodName(String foodName) {
        this.foodname = foodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String tablenumber) {
        this.table = tablenumber;
    }
}
