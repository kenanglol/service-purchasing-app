package com.micro.ege.user.usermicro.core.exception;

public class UserExceptions {
    public static ExceptionInfo GET_REQ_EMPTY = new ExceptionInfo(1L,
            "Kullanıcı aramak için mail ya da user ID alanlarından en az birisi dolu olmalıdır.");

    public static ExceptionInfo USER_NOT_FOUND = new ExceptionInfo(2L,
            "Kullanıcı bulunamadı.");

    public static ExceptionInfo USER_UPDATE_ERROR = new ExceptionInfo(3L,
            "Kullanıcı bilgileri güncellenirken hata oluştu.");

    public static ExceptionInfo USER_CREATE_ERROR = new ExceptionInfo(3L,
            "Kullanıcı bilgileri kaydedilirken hata oluştu.");
}
