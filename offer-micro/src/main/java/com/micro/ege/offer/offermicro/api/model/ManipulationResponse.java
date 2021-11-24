package com.micro.ege.offer.offermicro.api.model;

import com.micro.ege.offer.offermicro.core.constant.OfferMicroConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManipulationResponse extends BaseResponse {

    public static final ManipulationResponse SUCCESS_PROCESS =
            new ManipulationResponse(OfferMicroConstants.PROCESS_SUCCEED_CODE,
                    OfferMicroConstants.PROCESS_SUCCEED_MSG,
                    true);

    public ManipulationResponse(BaseResponse baseResponse) {
        super(baseResponse.getErrorCode(), baseResponse.getErrorMessage());
        this.isSucceeded = baseResponse.getErrorCode().equals(OfferMicroConstants.PROCESS_SUCCEED_CODE);
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
