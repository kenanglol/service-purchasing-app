package com.micro.ege.advert.advertservice.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import static com.micro.ege.advert.advertservice.core.constant.AdvertMicroConstants.*;

@Getter
@Setter
public class ManipulationResponse extends BaseResponse {

    public static final ManipulationResponse SUCCESS_PROCESS =
            new ManipulationResponse(SUCCESS_CODE, SUCCESS_MSG, true);

    public ManipulationResponse(BaseResponse baseResponse) {
        super(baseResponse.getErrorCode(), baseResponse.getErrorMessage());
        this.isSucceeded = baseResponse.getErrorCode().equals(SUCCESS_CODE);
    }

    public ManipulationResponse(Long errCode, String errMsg, Boolean isSucceeded) {
        super(errCode, errMsg);
        this.isSucceeded = isSucceeded;
    }

    public ManipulationResponse() {
        super();
    }

    @Schema(description = "Is Succeeded", example = "true", required = true)
    private Boolean isSucceeded;
}
