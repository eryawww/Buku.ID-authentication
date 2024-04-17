package id.ac.ui.cs.advprog.authentication.repository;

import id.ac.ui.cs.advprog.authentication.model.User;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@org.springframework.stereotype.Repository
public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<Integer, Boolean> userExists = new HashMap<>();

    /**
     * @param user instance
     * add a user instance to the repository
     * 1. assign its id if it doesn't have one
     * 2. Doing validation on user parameter
     * @return  user instance if success, else null and print the exception
     */
    public User create(User user){
        try {
            validateUser(user);
        }catch (InvalidParameterException e){
            System.out.println("[ERROR] "+e);
            return null;
        }
        users.add(user);
        userExists.put(user.getIdUser(), true);
        return user;
    }

    private void validateUser(User user) throws InvalidParameterException {
        try {
            checkIdUser(user);
            checkGender(user);
            checkNull(user);
        }catch (InvalidParameterException e){
            throw e;
        }
    }

    private void checkNull(User user) throws InvalidParameterException {
        if(user.getFullname() == null) throw new InvalidParameterException("Fullname is Null");
        if(user.getEmail() == null) throw new InvalidParameterException("Email is Null");
        if(user.getPhone() == null) throw new InvalidParameterException("Phone is Null");
        if(user.getPassword() == null) throw new InvalidParameterException("Password is Null");
        if(user.getBio() == null) throw new InvalidParameterException("Bio is Null");
        if(user.getGender() == null) throw new InvalidParameterException("Gender is Null");
        if(user.getIdUser() == null) throw new InvalidParameterException("idUser is Null");

    }
    private void checkIdUser(User user) throws InvalidParameterException {
//        TODO: Fix collision probability
        if(user.getIdUser() == null){
            user.setIdUser((int) (Math.random()*1000_000));
        }
        if(userExists.containsKey(user.getIdUser())) throw new InvalidParameterException("User Id collision occur");
    }
    private void checkGender(User user) throws InvalidParameterException {
        if(user.getGender() == null) throw new InvalidParameterException("Gender is null");
        if(user.getGender() > 2) throw new InvalidParameterException("Gender is not a valid value");
    }
}