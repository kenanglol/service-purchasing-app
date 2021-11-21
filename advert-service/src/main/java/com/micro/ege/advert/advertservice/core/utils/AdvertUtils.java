package com.micro.ege.advert.advertservice.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AdvertUtils {

    public static Boolean checkServiceStatusChange(Short before, Short after) {
        if(before.equals(after)) {
            return true;
        }
        else if(before.equals(AdvertStatus.SEND.getStatcode()) && after.equals(AdvertStatus.ACCEPTED.getStatcode())) {
            return true;
        }
        else if(before.equals(AdvertStatus.SEND.getStatcode()) && after.equals(AdvertStatus.CANCELED.getStatcode())) {
            return true;
        }
        else if(before.equals(AdvertStatus.SEND.getStatcode()) && after.equals(AdvertStatus.REJECTED.getStatcode())) {
            return true;
        }
        else if(before.equals(AdvertStatus.ACCEPTED.getStatcode()) && after.equals(AdvertStatus.DONE.getStatcode())) {
            return true;
        }
        else {
            return false;
        }
    }
}
