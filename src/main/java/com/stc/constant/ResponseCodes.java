package com.stc.constant;

import com.stc.util.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ResponseCodes {
    @Value(Value = "success")
    public static final int SUCCESS = 200;
    @Value(Value = "CREATED")
    public static final int CREATED = 201;
    @Value(Value = "permission assign to the user successfully")
    public static final int PERMISSION_ASSIGN = 202;
    @Value(Value = "File Already Exist")
    public static final int ALREADY_EXIST = 300;
    @Value(Value = "invalid Location or location Not exist")
    public static final int INVALID_LOCATION = 301;
    @Value(Value = "space already Exist ")
    public static final int SPACE_ALREADY_EXIST = 302;
    @Value(Value = "space Not Exist")
    public static final int SPACE_NOT_EXIST = 303;
    @Value(Value = "space can't be null")
    public static final String SPACE_NULL = "304";
    @Value(Value = "you should specify user")
    public static final String USER_NULL = "305";
    @Value(Value = "invalid permession")
    public static final String INVALID_PERMISSION = "306";
    @Value(Value = "file not Exist")
    public static final int FILE_NOT_EXIST = 307;
    @Value(Value = "user not exist")
    public static final int USER_NOT_EXIST = 308;
    @Value(Value = "user not exist")
    public static final int FOLDER_NOT_EXIST = 309;
    @Value(Value = " error permission not assign to any item ")
    public static final int PERMISSION_NOT_ASSIGN = 310;
    @Value(Value = "permission level exist before for that user and item ")
    public static final int PERMISSION_LEVEL_EXIST_BEFORE = 311;


    public static String getDesc(int constantValue) {
        String Desc = "";
        Field[] interfaceFields = ResponseCodes.class.getFields();
        for (Field f : interfaceFields) {
            try {
                if (Integer.valueOf(f.get(null).toString()) == constantValue) {
                    Annotation annotation = f.getAnnotation(Value.class);
                    if (annotation instanceof Value) {
                        Value objValue = (Value) annotation;
                        Desc = objValue.Value();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Desc;

    }
}
