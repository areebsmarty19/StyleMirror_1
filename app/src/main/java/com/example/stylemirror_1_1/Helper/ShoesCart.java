package com.example.stylemirror_1_1.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.stylemirror_1_1.domain.ShoesDomain;
import java.util.ArrayList;

public class ShoesCart {
    private Context context;
    private TinyDB tinyDB;

    public ShoesCart(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertShoes(ShoesDomain item) {
        ArrayList<ShoesDomain> listpop1 = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listpop1.size(); i++) {
            if (listpop1.get(i).getShoesTitle().equals(item.getShoesTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if(existAlready){
            listpop1.get(n).setShoesNumberInCart(item.getShoesNumberInCart()+1);
        }else{
            listpop1.add(item);
        }
        tinyDB.putShoesListObject("CartList",listpop1);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ShoesDomain> getListCart() {
        return tinyDB.getShoesListObject("CartList");
    }

    public Double getTotalFee(){
        ArrayList<ShoesDomain> listItem=getListCart();
        double fee=0;
        for (int i = 0; i < listItem.size(); i++) {
            fee=fee+(listItem.get(i).getShoesPrice()*listItem.get(i).getShoesNumberInCart());
        }
        return fee;
    }
    public void minusNumberItem(ArrayList<ShoesDomain> listItem,int position,ChangeNumberItemsListener changeNumberItemsListener){
        if(listItem.get(position).getShoesNumberInCart()==1){
            listItem.remove(position);

        }else{
            listItem.get(position).setShoesNumberInCart(listItem.get(position).getShoesNumberInCart()-1);
        }
        tinyDB.putShoesListObject("CartList",listItem);
        changeNumberItemsListener.change();
    }
    public  void plusNumberItem(ArrayList<ShoesDomain> listItem,int position,ChangeNumberItemsListener changeNumberItemsListener){
        listItem.get(position).setShoesNumberInCart(listItem.get(position).getShoesNumberInCart()+1);
        tinyDB.putShoesListObject("CartList",listItem);
        changeNumberItemsListener.change();
    }
}

