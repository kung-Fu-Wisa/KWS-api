package com.school.security.services.contracts;

import com.school.security.dtos.requests.UserReqDto;
import com.school.security.dtos.responses.UserResDto;
import com.school.security.entities.User;
import com.school.security.enums.RoleType;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends Service<UserReqDto, UserResDto, Long>{

    UserResDto attachRole(String email, RoleType name);

    UserResDto detachRole(String email, RoleType name);

    UserDetailsService userDetailsService();

   User findByEmail(String email);
}
