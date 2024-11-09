package com.gym.app.repository;



import org.springframework.stereotype.Repository;
import com.gym.app.entity.UserHealthDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Manjunath Reddy
 */
@Repository
public interface UserHealthDetailsRepository extends JpaRepository<UserHealthDetails, Long> {
    @Query("SELECT userHealthDetails from UserHealthDetails userHealthDetails where lower(userHealthDetails.loginId)=lower(:loginId)")
    UserHealthDetails findByLoginId(@Param("loginId") String loginId);
}
