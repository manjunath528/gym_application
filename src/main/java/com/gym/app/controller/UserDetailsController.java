package com.gym.app.controller;


import com.gym.app.baseframework.controller.BaseController;
import com.gym.app.baseframework.exception.BaseException;
import com.gym.app.service.UserDetailsService;
import com.gym.app.service.UserService;
import com.gym.app.service.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiRoute.BASE_MAPPING_API_V1)
@CrossOrigin(origins = "*")
public class UserDetailsController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDetailsService userService;



    @PostMapping(value = ApiRoute.USER_SIGN_UP)
    public ResponseEntity<UserSignUpResponse> userSignUp(@RequestBody UserSignUpRequest userSignUpRequest) throws BaseException {
        logger.info("userSignUpRequest: Received");
        return new ResponseEntity<>(userService.signUp(userSignUpRequest), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_LOG_IN)
    public ResponseEntity<UserLogInResponse> userLogin(@RequestBody UserLogInRequest userLogInRequest) throws BaseException {
        logger.info("userLogin: Received");
        return new ResponseEntity<>(userService.userLogin(userLogInRequest), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_LOG_OUT)
    public ResponseEntity<UserLogOutResponse> userLogout(@RequestBody UserLogOutRequest userLogOutRequest) throws BaseException{
        logger.info("userLogout: Received");
        return new ResponseEntity<>(userService.userLogout(userLogOutRequest), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_ACCOUNT_PERSONAL_PROFILE)
    public ResponseEntity<UserAccountResponse> saveUserAccountProfile(@RequestBody UserAccountRequest userAccountRequest) throws BaseException {
        logger.info("saveUserAccountProfile: Received");
        return new ResponseEntity<>(userService.saveOrUpdateUserAccountProfile(userAccountRequest, true), HttpStatus.OK);
    }

    @PutMapping(value = ApiRoute.USER_ACCOUNT_PERSONAL_PROFILE)
    public ResponseEntity<UserAccountResponse> updateUserAccountProfile(@RequestBody UserAccountRequest userAccountRequest) throws BaseException {
        logger.info("updateUserAccountProfile: Received");
        return new ResponseEntity<>(userService.saveOrUpdateUserAccountProfile(userAccountRequest, false), HttpStatus.OK);
    }
    @GetMapping(value = ApiRoute.USER_ACCOUNT_PERSONAL_PROFILE)
    public ResponseEntity<UserAccountProfileResponse> retrieveUserAccountProfileByLoginId(@RequestParam(value = "loginId") String loginId) throws BaseException {
        logger.info("retrieveUserAccountProfileByLoginId: Received for loginId -> {}", loginId);
        return new ResponseEntity<>(userService.retrieveUserAccountProfileByLoginId(loginId), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_ACCOUNT_PERSONAL_PROFILE_RETRIEVE)
    public ResponseEntity<UserAccountProfileResponse> retrieveUserAccountProfile(@RequestBody RetrieveUserProfileRequest retrieveUserProfileRequest) throws BaseException {
        logger.info("retrieveUserAccountProfile: Received  -> {}", retrieveUserProfileRequest);
        return new ResponseEntity<>(userService.retrieveUserAccountProfile(retrieveUserProfileRequest), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_ACCOUNT_HEALTH_PROFILE)
    public ResponseEntity<UserHealthResponse> saveUserHealthProfile(@RequestBody UserHealthRequest userHealthRequest) throws BaseException {
        logger.info("saveOrUpdateUserHealthProfile: Received");
        return new ResponseEntity<>(userService.saveOrUpdateUserHealthProfile(userHealthRequest, true), HttpStatus.OK);
    }

    @PutMapping(value = ApiRoute.USER_ACCOUNT_HEALTH_PROFILE)
    public ResponseEntity<UserHealthResponse> updateUserHealthProfile(@RequestBody UserHealthRequest userHealthRequest) throws BaseException {
        logger.info("saveOrUpdateUserHealthProfile: Received");
        return new ResponseEntity<>(userService.saveOrUpdateUserHealthProfile(userHealthRequest, false), HttpStatus.OK);
    }
    @DeleteMapping(value = ApiRoute.USER_ACCOUNT_DETAILS_DELETE)
    public ResponseEntity<UserDeleteResponse> userAccountDetailsDelete(@RequestParam(value = "loginId") String loginId) throws BaseException {
        logger.info("userAccountDetailsDelete: Received");
        return new ResponseEntity<>(userService.userAccountDetailsDelete(loginId), HttpStatus.OK);
    }
    @GetMapping(value = ApiRoute.USER_ACCOUNT_HEALTH_PROFILE)
    public ResponseEntity<UserHealthProfileResponse> retrieveUserHealthProfileByLoginId(@RequestParam(value = "loginId") String loginId) throws BaseException {
        logger.info("retrieveUserHealthProfileByLoginId: Received for loginId -> {}", loginId);
        return new ResponseEntity<>(userService.retrieveUserHealthProfileByLoginId(loginId), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_HEALTH_PROFILE_RETRIEVE)
    public ResponseEntity<UserHealthProfileResponse> retrieveUserHealthProfile(@RequestBody RetrieveUserProfileRequest retrieveUserProfileRequest) throws BaseException {
        logger.info("retrieveUserHealthProfile: Received  -> {}", retrieveUserProfileRequest);
        return new ResponseEntity<>(userService.retrieveUserHealthProfile(retrieveUserProfileRequest), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_FORGOT_PASSWORD)
    public ResponseEntity<ForgotAccountResponse> forgotPassword(@RequestBody ForgotAccountRequest forgotAccountRequest) throws BaseException {
        logger.info("forgotPassword: Received");
        return new ResponseEntity<>(userService.forgotPassword(forgotAccountRequest), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_FORGOT_LOGINID)
    public ResponseEntity<ForgotAccountResponse> forgotLoginId(@RequestBody ForgotAccountRequest forgotAccountRequest) throws BaseException {
        logger.info("forgotLoginId: Received");
        return new ResponseEntity<>(userService.forgotLoginId(forgotAccountRequest), HttpStatus.OK);
    }

    @PostMapping(value = ApiRoute.USER_UPDATE_PASSWORD)
    public ResponseEntity<UpdatePasswordResponse> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) throws BaseException {
        logger.info("updatePassword: Received");
        return new ResponseEntity<>(userService.updatePassword(updatePasswordRequest), HttpStatus.OK);
    }




}
