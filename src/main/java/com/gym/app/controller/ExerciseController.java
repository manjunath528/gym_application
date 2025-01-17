package com.gym.app.controller;

import com.gym.app.baseframework.controller.BaseController;
import com.gym.app.baseframework.exception.BaseException;
import com.gym.app.entity.MessageCenter;
import com.gym.app.service.ExerciseService;
import com.gym.app.service.dto.ExsByWorkIdListRequest;
import com.gym.app.service.dto.ExsByWorkIdListResponse;
import com.gym.app.service.dto.MessageCenterRetrieveRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(ApiRoute.BASE_MAPPING_API_V1)
@CrossOrigin(origins = "*")
public class ExerciseController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping(value = ApiRoute.EXERCISE_DETAILS_BY_ID_LIST)
    public ResponseEntity<List<ExsByWorkIdListResponse>> retriveExercisesByWorkOutIdList(@RequestBody ExsByWorkIdListRequest exsByWorkIdListRequest) throws BaseException {
        logger.info("retriveExercisesByWorkOutIdList: Received");
        return new ResponseEntity<>(exerciseService.getExercisesForWorkouts(exsByWorkIdListRequest), HttpStatus.OK);
    }

}
