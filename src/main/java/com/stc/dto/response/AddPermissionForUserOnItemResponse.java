package com.stc.dto.response;

import com.stc.entity.ItemWUserPermission;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddPermissionForUserOnItemResponse extends Response {
    ItemWUserPermission itemWUserPermission;

    public AddPermissionForUserOnItemResponse(int responseCode, ItemWUserPermission itemWUserPermission) {
        super(responseCode);
        this.itemWUserPermission = itemWUserPermission;
    }
}
