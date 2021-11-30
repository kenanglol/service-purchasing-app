package com.micro.ege.advert.advertservice.core.exception;

public class AdvertExceptions {

    public static ExceptionData ADVERT_UPDATE_ERROR = new ExceptionData(1L,
            "Hizmet ilanı güncellenirken hata oluştu.");

    public static ExceptionData ADVERT_NOT_FOUND = new ExceptionData(2L,
            "Hizmet ilanı kaydı bulunamadı.");

    public static ExceptionData BAD_LIST_ADVERT_REQUEST = new ExceptionData(3L,
            "Gönderilen istek listeleme işlemi için uygun değildir.");

    public static ExceptionData MIN_PRICE_IS_NOT_LOWER_THAN_ZERO = new ExceptionData(4L,
            "Gönderilen istek listeleme işlemi için uygun değildir.");

    public static ExceptionData ADVERT_DELETE_ERROR = new ExceptionData(5L,
            "Hizmet ilanı silinirken hata oluştu.");
}
