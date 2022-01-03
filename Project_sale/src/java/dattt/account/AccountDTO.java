/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.account;

import java.io.Serializable;

/**
 *
 * @author jike
 */
public class AccountDTO implements Serializable{
    private int uID;
    private String user;
    private String pass;
    private int isSell;
    private int isAdmin;

    public AccountDTO() {
    }

    public AccountDTO(int uID, String user, String pass, int isSell, int isAdmin) {
        this.uID = uID;
        this.user = user;
        this.pass = pass;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
    }
    
    
    /**
     * @return the uID
     */
    public int getuID() {
        return uID;
    }

    /**
     * @param uID the uID to set
     */
    public void setuID(int uID) {
        this.uID = uID;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the isSell
     */
    public int getIsSell() {
        return isSell;
    }

    /**
     * @param isSell the isSell to set
     */
    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    /**
     * @return the isAdmin
     */
    public int getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
}
