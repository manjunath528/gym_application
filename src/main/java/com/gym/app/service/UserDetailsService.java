package com.gym.app.service;

import com.gym.app.entity.*;
import com.gym.app.service.dto.*;

import com.gym.app.baseframework.exception.SystemException;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


public interface UserDetailsService {

    UserSignUpResponse signUp(UserSignUpRequest userSignUpRequest) throws SystemException;

    UserLogInResponse userLogin(UserLogInRequest userLogInRequest) throws SystemException;

    UserLogOutResponse userLogout(UserLogOutRequest userLogOutRequest) throws SystemException;

    UserAccountResponse saveOrUpdateUserAccountProfile(UserAccountRequest userAccountRequest, boolean statusUpdateFlag) throws SystemException;

    UserAccountProfileResponse retrieveUserAccountProfileByLoginId(String loginId) throws SystemException;

    UserAccountProfileResponse retrieveUserAccountProfile(RetrieveUserProfileRequest retrieveUserProfileRequest) throws SystemException;

    UserHealthResponse saveOrUpdateUserHealthProfile(UserHealthRequest userHealthRequest, boolean statusUpdateFlag) throws SystemException;

    UserDeleteResponse userAccountDetailsDelete(String loginId) throws SystemException;

    UserHealthProfileResponse retrieveUserHealthProfileByLoginId(String loginId) throws SystemException;

    UserHealthProfileResponse retrieveUserHealthProfile(RetrieveUserProfileRequest retrieveUserProfileRequest) throws SystemException;

    ForgotAccountResponse forgotPassword(ForgotAccountRequest forgotAccountRequest) throws SystemException;

    ForgotAccountResponse forgotLoginId(ForgotAccountRequest forgotAccountRequest) throws SystemException;

    UpdatePasswordResponse updatePassword(UpdatePasswordRequest updatePasswordRequest) throws SystemException;

    UserMembershipResponse chooseMembershipPlan(UserMembershipRequest userMembershipRequest) throws SystemException;

    List<Workout> getWorkoutsByLoginId(String loginId) throws SystemException;

    ExerciseResponse getExerciseById(Long id) throws SystemException;

    List<UserPersonalDetails> getAllUserPersonalDetails() throws SystemException;

    List<UserPersonalDetails> getAllUserPersonalDetailsAfterDate(String date) throws SystemException;

    List<UserAccount> getUserAccountsFromDate(String date) throws SystemException;

    List<UserHealthDetails> getUserHealthDetailsByDate(String date) throws SystemException;

}
