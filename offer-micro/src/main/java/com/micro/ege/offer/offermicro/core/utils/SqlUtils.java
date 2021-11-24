package com.micro.ege.offer.offermicro.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
public class SqlUtils {

    private SqlUtils() {

    }

    public static String readSql(Resource sqlResource) {
        try {
            return StreamUtils.copyToString(sqlResource.getInputStream(), Charset.defaultCharset());
        } catch(IOException ioException) {
            log.error("SqlUtils-readSql gave the IOException error.");
        }
        return "";
    }
}
