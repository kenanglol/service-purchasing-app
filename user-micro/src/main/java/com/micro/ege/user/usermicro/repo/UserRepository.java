package com.micro.ege.user.usermicro.repo;

import com.micro.ege.user.usermicro.dto.CreateUserDto;
import com.micro.ege.user.usermicro.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto,Long> {

    UserDto findByMail(String mail);

}
