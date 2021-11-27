package com.micro.ege.user.usermicro.core.exception;

public class UserExceptions {
    public static ExceptionData GET_REQ_EMPTY = new ExceptionData(1L,
            "Kullanıcı aramak için mail ya da user ID alanlarından en az birisi dolu olmalıdır.");

    public static ExceptionData USER_NOT_FOUND = new ExceptionData(2L,
            "Kullanıcı bulunamadı.");

    public static ExceptionData USER_UPDATE_ERROR = new ExceptionData(3L,
            "Kullanıcı bilgileri güncellenirken hata oluştu.");

    public static ExceptionData USER_CREATE_ERROR = new ExceptionData(3L,
            "Kullanıcı bilgileri kaydedilirken hata oluştu.");

    public static ExceptionData USER_ALREADY_EXIST = new ExceptionData(3L,
            "Mail adresi zaten kayıtlı.");
}
