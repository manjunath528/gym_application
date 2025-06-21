package com.gym.app.service;

import com.gym.app.baseframework.exception.BaseException;
import com.gym.app.baseframework.exception.SystemException;
import com.gym.app.service.dto.PlanSelectionRequest;

import java.io.IOException;

public interface UserWorkoutPlanService {
    void createWorkoutPlan(PlanSelectionRequest request) throws BaseException;
}