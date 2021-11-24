package com.micro.ege.user.usermicro.api.model;

import com.micro.ege.user.usermicro.core.constant.UserMicroConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManipulationResponse extends BaseResponse {

    public static final ManipulationResponse SUCCESS_PROCESS =
            new ManipulationResponse(UserMicroConstants.SUCCESS_CODE,
                    UserMicroConstants.SUCCESS_MSG,
                    true);

    public ManipulationResponse(BaseResponse baseResponse) {
        super(baseResponse.getErrorCode(), baseResponse.getErrorMessage());
        this.isSucceeded = baseResponse.getErrorCode().equals(UserMicroConstants.SUCCESS_CODE);
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
