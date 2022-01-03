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
public class AccountCreateError implements Serializable{
    private String usernameIsExisted;
    private String usernameLengthViolent;
    private String passwordLengthViolent;
    private String confirmNoMatch;

    public AccountCreateError() {
    }

    public AccountCreateError(String usernameIsExisted, String usernameLengthViolent, String passwordLengthViolent, String confirmNoMatch) {
        this.usernameIsExisted = usernameIsExisted;
        this.usernameLengthViolent = usernameLengthViolent;
        this.passwordLengthViolent = passwordLengthViolent;
        this.confirmNoMatch = confirmNoMatch;
    }
    
    /**
     * @return the usernameIsExisted
     */
    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    /**
     * @param usernameIsExisted the usernameIsExisted to set
     */
    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }

    /**
     * @return the usernameLengthViolent
     */
    public String getUsernameLengthViolent() {
        return usernameLengthViolent;
    }

    /**
     * @param usernameLengthViolent the usernameLengthViolent to set
     */
    public void setUsernameLengthViolent(String usernameLengthViolent) {
        this.usernameLengthViolent = usernameLengthViolent;
    }

    /**
     * @return the passwordLengthViolent
     */
    public String getPasswordLengthViolent() {
        return passwordLengthViolent;
    }

    /**
     * @param passwordLengthViolent the passwordLengthViolent to set
     */
    public void setPasswordLengthViolent(String passwordLengthViolent) {
        this.passwordLengthViolent = passwordLengthViolent;
    }

    /**
     * @return the confirmNoMatch
     */
    public String getConfirmNoMatch() {
        return confirmNoMatch;
    }

    /**
     * @param confirmNoMatch the confirmNoMatch to set
     */
    public void setConfirmNoMatch(String confirmNoMatch) {
        this.confirmNoMatch = confirmNoMatch;
    }
    
    
}
