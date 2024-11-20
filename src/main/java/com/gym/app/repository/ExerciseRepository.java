package com.gym.app.repository;

import com.gym.app.entity.Country;
import com.gym.app.entity.Exercise;
import com.gym.app.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT exercise FROM Exercise exercise WHERE exercise.workoutId=:workoutId ORDER BY exercise.exerciseName ASC, exercise.id ASC")
    List<State> exerciseDetailsByWorkoutId(@Param("workoutId") Long workoutId);
}
