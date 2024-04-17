package id.ac.ui.cs.advprog.authentication.model;

import lombok.Setter;
import lombok.Getter;

@Getter @Setter
public class User {
    private String fullname;
    private String email;
    private String phone;
    private String password;
    private String bio;
    private String gender;
    private Integer idUser;
}
