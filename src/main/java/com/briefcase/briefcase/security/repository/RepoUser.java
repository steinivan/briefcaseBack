
package com.briefcase.briefcase.security.repository;

import com.briefcase.briefcase.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
public interface RepoUser extends JpaRepository<User,Long> {

}
