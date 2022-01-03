/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.item;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jike
 */
public class Order implements Serializable{
    private int id;
    private List<Item> item;
    private double total;
    
    public Order() {
    }

    public Order(int id, List<Item> item) {
        this.id = id;
        this.item = item;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the item
     */
    public List<Item> getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(List<Item> item) {
        this.item = item;
    }

    public double getTotal() {
        for (Item item1 : item) {
            total += item1.getPrice();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
