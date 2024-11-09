package com.gym.app.repository;

import com.gym.app.entity.UserPersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by Manjunath Reddy
 */

public interface UserPersonalDetailsRepository extends JpaRepository<UserPersonalDetails, Long> {
    @Query("SELECT userPersonalDetails from UserPersonalDetails userPersonalDetails where lower(userPersonalDetails.loginId)=lower(:loginId)")
    UserPersonalDetails findByLoginId(@Param("loginId") String loginId);
}
