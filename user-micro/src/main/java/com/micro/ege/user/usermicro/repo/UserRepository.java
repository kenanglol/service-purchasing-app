package com.micro.ege.user.usermicro.repo;

import com.micro.ege.user.usermicro.dto.CreateUserDto;
import com.micro.ege.user.usermicro.dto.UserDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<,Long> {

    UserDetailDto getUserWithId(String userId);

    UserDetailDto getUserWithMail(String mail);

    Boolean createUser(CreateUserDto createUserDto);

    Boolean updateUser(String userId, String name, String surname);
}
