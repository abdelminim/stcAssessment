package com.stc.dto.response;

import com.stc.constant.ResponseCodes;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Response {
    private int responseCode;
    private String responseMessage;

    public Response(int responseCode) {
        this.responseCode = responseCode;
        this.responseMessage = ResponseCodes.getDesc(responseCode);
    }
}
