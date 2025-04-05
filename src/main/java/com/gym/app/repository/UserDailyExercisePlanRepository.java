package com.gym.app.repository;

import com.gym.app.entity.UserDailyDietPlan;
import com.gym.app.entity.UserDailyExercisePlan;
import com.gym.app.entity.UserHealthDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Manjunath Reddy
 */
@Repository
public interface UserDailyExercisePlanRepository extends JpaRepository<UserDailyExercisePlan, Long> {
}
