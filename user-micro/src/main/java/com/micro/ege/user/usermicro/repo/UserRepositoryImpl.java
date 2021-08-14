package com.micro.ege.user.usermicro.repo;

import com.micro.ege.user.usermicro.core.util.SqlUtils;
import com.micro.ege.user.usermicro.core.util.UserUtils;
import com.micro.ege.user.usermicro.dto.CreateUserDto;
import com.micro.ege.user.usermicro.dto.UserDetailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Objects;

@Slf4j
@Repository
public class UserRepositoryImpl extends NamedParameterJdbcDaoSupport implements UserRepository {

    @Value("classpath:sql/create_user.sql")
    private Resource createUserSqlResource;
    @Value("classpath:sql/get_user_with_id.sql")
    private Resource getUserWithIdSqlResource;
    @Value("classpath:sql/get_user_with_mail.sql")
    private Resource getUserWithMailSqlResource;

    private final BeanPropertyRowMapper<UserDetailDto> userDetailRowMapper =
            new BeanPropertyRowMapper<>(UserDetailDto.class);

    public UserRepositoryImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public UserDetailDto getUserWithId(String userId) {
        String getUserWithIdSql = SqlUtils.readSql(getUserWithIdSqlResource);
        try{
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("userId", userId, Types.VARCHAR);

            return Objects.requireNonNull(getNamedParameterJdbcTemplate()).
                    queryForObject(getUserWithIdSql, parameterSource, userDetailRowMapper);

        }catch (Exception e) {
            log.error("getUserWithId throws an error"+e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public UserDetailDto getUserWithMail(String mail) {

        String getUserWithMailSql = SqlUtils.readSql(getUserWithMailSqlResource);
        try{
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("mail", mail, Types.VARCHAR);

            return Objects.requireNonNull(getNamedParameterJdbcTemplate()).
                    queryForObject(getUserWithMailSql, parameterSource, userDetailRowMapper);

        }catch (Exception e) {
            log.error("getUserWithMail throws an error"+e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Boolean createUser(CreateUserDto createUserDto) {
        String createUserSql = SqlUtils.readSql(createUserSqlResource);
        try{
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("userId", UserUtils.generateUserID(), Types.VARCHAR)
                    .addValue("name", createUserDto.getName(), Types.VARCHAR)
                    .addValue("surname", createUserDto.getSurname(), Types.VARCHAR)
                    .addValue("mail", createUserDto.getMail(), Types.VARCHAR)
                    .addValue("pass", createUserDto.getCipher(), Types.VARCHAR);

            int affectedRows = Objects.requireNonNull(getNamedParameterJdbcTemplate()).
                    update(createUserSql, parameterSource);
            return affectedRows != 0 ;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateUser(String userId, String name, String surname) {
        String createUserSql = SqlUtils.readSql(createUserSqlResource);
        try{
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("userId", UserUtils.generateUserID(), Types.VARCHAR)
                    .addValue("name", name, Types.VARCHAR)
                    .addValue("surname", surname, Types.VARCHAR);

            int affectedRows = Objects.requireNonNull(getNamedParameterJdbcTemplate()).
                    update(createUserSql, parameterSource);
            return affectedRows != 0 ;
        }catch (Exception e) {
            return false;
        }
    }

}
