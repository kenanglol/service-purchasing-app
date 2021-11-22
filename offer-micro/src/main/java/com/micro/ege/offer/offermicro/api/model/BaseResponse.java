package com.micro.ege.offer.offermicro.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    @Schema(description = "Error Code", example = "11545L", required = true)
    private Long errorCode;

    @Schema(description = "Error Message", example = "This time range can not select", required = true)
    private String errorMessage;
}
