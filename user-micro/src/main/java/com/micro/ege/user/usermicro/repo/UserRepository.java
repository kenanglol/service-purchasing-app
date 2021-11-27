package com.micro.ege.user.usermicro.repo;

import com.micro.ege.user.usermicro.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDto,Long> {

    Optional<UserDto> findByMail(String mail);

}
