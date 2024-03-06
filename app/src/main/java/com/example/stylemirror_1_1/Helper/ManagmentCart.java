package com.example.stylemirror_1_1.Helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.stylemirror_1_1.databinding.ViewholderCartBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;

import java.util.ArrayList;


public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;
    private ViewholderCartBinding binding;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertFood(PopularDomain item) {
        ArrayList<PopularDomain> listpop = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listpop.size(); i++) {
            if (listpop.get(i).getId()==(item.getId())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if(existAlready){
            listpop.get(n).setNumberInCart(item.getNumberInCart()+1);
        }else{
            listpop.add(item);
        }
        tinyDB.putListObject("CartList",listpop);
        Toast.makeText(context, listpop.get(n).getTitle()+" Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PopularDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public Double getTotalFee(){
        ArrayList<PopularDomain> listItem=getListCart();
        double fee=0;
        for (int i = 0; i < listItem.size(); i++) {
            fee=fee+(listItem.get(i).getPrice()*listItem.get(i).getNumberInCart());
        }
        return fee;
    }

//    public void minusNumberItem(ArrayList<PopularDomain> listItem,int position,ChangeNumberItemsListener changeNumberItemsListener){
//        if(listItem.get(position).getNumberInCart()==1){
//            listItem.remove(position);
//        }else{
//            listItem.get(position).setNumberInCart(listItem.get(position).getNumberInCart()-1);
//        }
//        tinyDB.putListObject("CartList",listItem);
//        changeNumberItemsListener.change();
//    }

//    public  void plusNumberItem(ArrayList<PopularDomain> listItem,int position,ChangeNumberItemsListener changeNumberItemsListener){
//        listItem.get(position).setNumberInCart(listItem.get(position).getNumberInCart()+1);
//        tinyDB.putListObject("CartList",listItem);
//        changeNumberItemsListener.change();
//    }

    public void removeItem(int position, Runnable callback) {
        ArrayList<PopularDomain> listItem = getListCart();
        if (listItem.size() == 1) {
            // If only one item is left in the cart, clear the cart
            listItem.clear();
        } else {
            // Remove the item at the specified position
            listItem.remove(position);
        }
        tinyDB.putListObject("CartList", listItem);
        callback.run();
    }

}

