package com.gym.app.service;

import com.gym.app.baseframework.exception.SystemException;
import com.gym.app.service.dto.ExsByWorkIdListRequest;
import com.gym.app.service.dto.ExsByWorkIdListResponse;
import java.util.List;

public interface ExerciseService {
    List<ExsByWorkIdListResponse> getExercisesForWorkouts(ExsByWorkIdListRequest exsByWorkIdListRequest) throws SystemException;
}
