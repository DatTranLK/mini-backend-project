/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jike
 */
public class CartObject implements Serializable{
    private Map<String,Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    }
    public void addItemsToCart(String name){
        if(name == null){
            return;
        }
        if(name.trim().isEmpty()){
            return;
        }
        //1 checking items has existed
        if(this.items == null){
            this.items = new HashMap<>();
        }
        //1 checking item existed in items
        int amount = 1;
        if(this.items.containsKey(name)){
            amount = this.items.get(name) + 1;
        }
        //3 update items
        this.items.put(name, amount);
    }
    public void removeItemFromCart(String name){
        //1 checking items has existed
        if(this.items == null){
            return;
        }
        //2 checking item existed in cart
        if(this.items.containsKey(name)){
            this.items.remove(name);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
}
