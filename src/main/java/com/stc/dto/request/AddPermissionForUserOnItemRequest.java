package com.stc.dto.request;

import com.stc.constant.ResponseCodes;
import com.stc.entity.PermissionLevel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonPropertyOrder({"space", "folder", "file", "userEmail", "permissionLevel"})
public class AddPermissionForUserOnItemRequest {
    @NotNull(message = ResponseCodes.SPACE_NULL)
    private String space;
    private String folder;
    private String file;
    @NotNull(message = ResponseCodes.USER_NULL)
    private String userEmail;
    @NotNull(message = ResponseCodes.INVALID_PERMISSION)
    private PermissionLevel permissionLevel;

}
