package com.gym.app.service.impl;

import com.gym.app.baseframework.exception.SystemException;
import com.gym.app.entity.Exercise;
import com.gym.app.entity.Workout;
import com.gym.app.repository.ExerciseRepository;
import com.gym.app.repository.WorkoutRepository;
import com.gym.app.service.ExerciseService;
import com.gym.app.service.UserService;
import com.gym.app.service.dto.ExsByWorkIdListRequest;
import com.gym.app.service.dto.ExsByWorkIdListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Override
    public List<ExsByWorkIdListResponse> getExercisesForWorkouts(ExsByWorkIdListRequest exsByWorkIdListRequest) throws SystemException {
        if (exsByWorkIdListRequest.getSelectedWorkouts() == null || exsByWorkIdListRequest.getSelectedWorkouts().isEmpty()) {
            throw new IllegalArgumentException("Workout selection cannot be empty.");
        }
        if (exsByWorkIdListRequest.getSelectedWorkouts().size() > 2) {
            throw new IllegalArgumentException("You can select up to 2 workouts only.");
        }
        List<Exercise> exercises = exerciseRepository.findByWorkoutIdList(exsByWorkIdListRequest.getSelectedWorkouts());

        Map<Long, String> workoutIdToNameMap = new HashMap<>();
        for (Long workoutId : exsByWorkIdListRequest.getSelectedWorkouts()) {
            Workout workout = workoutRepository.findById(workoutId).orElse(null);
            if (workout != null) {
                workoutIdToNameMap.put(workoutId, workout.getWorkout());
            } else {
                workoutIdToNameMap.put(workoutId, "Unknown Workout");
            }
        }
        Map<Long, List<Exercise>> exercisesByWorkout = new HashMap<>();
        for (Exercise exercise : exercises) {
            exercisesByWorkout
                    .computeIfAbsent(exercise.getWorkoutId(), k -> new ArrayList<>())
                    .add(exercise);
        }
        List<ExsByWorkIdListResponse> responseList = new ArrayList<>();
        for (Long workoutId : exsByWorkIdListRequest.getSelectedWorkouts()) {
            String workoutName = workoutIdToNameMap.get(workoutId);
            List<Exercise> workoutExercises = exercisesByWorkout.getOrDefault(workoutId, new ArrayList<>());
            ExsByWorkIdListResponse exsByWorkIdListResponse = new ExsByWorkIdListResponse();
            exsByWorkIdListResponse.setWorkoutId(workoutId);
            exsByWorkIdListResponse.setWorkoutName(workoutName);
            exsByWorkIdListResponse.setExercises(workoutExercises);
            responseList.add(exsByWorkIdListResponse);
        }

        return responseList;
    }
}
