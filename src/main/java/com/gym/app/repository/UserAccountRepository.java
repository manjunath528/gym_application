package com.gym.app.repository;


import com.gym.app.entity.UserAccount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Manjunath Reddy
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    @Query("SELECT userAccount FROM UserAccount userAccount WHERE lower(userAccount.emailId)=lower(:emailId)")
    UserAccount findByEmailId(@Param("emailId") String emailId);

    @Query("SELECT userAccount FROM UserAccount userAccount WHERE lower(userAccount.loginId)=lower(:loginId)")
    UserAccount findByLoginId(@Param("loginId") String loginId);

    @Query("SELECT userAccount FROM UserAccount userAccount WHERE userAccount.loginId=:loginId " +
            "AND userAccount.password=:password")
    UserAccount userAuthorizationCheck(@Param("loginId") String loginId, @Param("password") String password);

}