
package com.briefcase.briefcase.security.service;

import com.briefcase.briefcase.security.dto.SignInRequest;
import com.briefcase.briefcase.security.entity.User;
import java.util.Optional;

public interface IAccountService {
    public User signUser(SignInRequest user);
}
