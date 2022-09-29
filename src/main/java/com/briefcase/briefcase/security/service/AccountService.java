
package com.briefcase.briefcase.security.service;

import com.briefcase.briefcase.security.dto.SignInRequest;
import com.briefcase.briefcase.security.entity.User;
import com.briefcase.briefcase.security.repository.RepoUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private RepoUser repository;
    
    @Override
    public User signUser(SignInRequest user){
        Optional<User> users = findEmail(repository.findAll(),user);
        return users.get();
    }
    Optional<User> findEmail(List<User> elem, SignInRequest user){
        return elem.stream()
                .filter(x -> x.getEmail().equals(user.getEmail()))
                .findFirst();
    }
}
