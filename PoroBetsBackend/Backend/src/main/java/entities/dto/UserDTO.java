package entities.dto;

import entities.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreas
 */
public class UserDTO {
    private String userName;
    private String userPass;
    private List<String> roleList = new ArrayList();
    private int balance;
    
    public UserDTO(String userName, List<String> roleList) {
        this.userName = userName;
        this.roleList = roleList;
    }
    
    public UserDTO(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    
}
