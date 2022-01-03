/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.category;

import java.io.Serializable;

/**
 *
 * @author jike
 */
public class CategoryDTO implements Serializable{
    private int cid;
    private String cname;

    public CategoryDTO() {
    }

    public CategoryDTO(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }
    
    
    /**
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    
}
