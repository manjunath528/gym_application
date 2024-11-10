package com.gym.app.controller;


/**
 * Created by Manjunath Reddy
 **/
public class ApiRoute {
    public static final String BASE_MAPPING_API_V1 = "/app/services/api/v1";
    public static final String METADATA = "/metadata";
    public static final String CONFIGURATION = "/config";
    // All Other
    public static final String CONTACT_US = "/contactUs";
    public static final String CONTACT_US_RETRIEVE_BY_CATEGORY_NAME = "/contactUs/retrieveByCategoryName";
    public static final String LOCATION_COUNTRY = "/location/country";
    public static final String LOCATION_STATE_BY_COUNTRY_ID = "/location/state";
    public static final String LOCATION_CITY_BY_STATE_ID = "/location/city";
    public static final String USER_SIGN_UP = "/user/signUp";
    public static final String USER_LOG_IN = "/user/login";
    public static final String USER_LOG_OUT = "/user/logout";
    public static final String USER_FORGOT_PASSWORD = "/user/forgotPassword";
    public static final String USER_FORGOT_LOGINID = "/user/forgotLoginId";
    public static final String USER_UPDATE_PASSWORD = "/user/updatePassword";
    public static final String USER_ACCOUNT_PERSONAL_PROFILE = "/user/account/personalProfile";
    public static final String USER_ACCOUNT_PERSONAL_PROFILE_RETRIEVE = "/user/account/retrievePersonalProfile";
    public static final String USER_HEALTH_PROFILE_RETRIEVE = "/user/account/retrieveHealthProfile";
    public static final String USER_ACCOUNT_HEALTH_PROFILE = "/user/account/healthProfile";
    public static final String USER_ACCOUNT_HEALTH_PROFILE_RETRIEVE = "/user/account/retrievehealthProfile";
    public static final String USER_ACCOUNT_DETAILS_DELETE = "/user/loginId/delete";
    public static final String USER_THANKS = "/user/thanks";
    private ApiRoute() {
    }


}
