/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.item;

import dattt.product.ProductDTO;
import java.io.Serializable;

/**
 *
 * @author jike
 */
public class Item implements Serializable{
    private int id;
    private ProductDTO product;
    private int quantity;
    private double price;
    
    public Item() {
        super();
    }
    

    
    public Item(int id, ProductDTO product, int quantity, double price) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
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
     * @return the product
     */
    public ProductDTO getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price * getQuantity();
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
}
