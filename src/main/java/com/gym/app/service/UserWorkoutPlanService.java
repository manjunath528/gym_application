package com.gym.app.service;

import com.gym.app.service.dto.PlanSelectionRequest;

public interface UserWorkoutPlanService {
    void createWorkoutPlan(PlanSelectionRequest request);
}