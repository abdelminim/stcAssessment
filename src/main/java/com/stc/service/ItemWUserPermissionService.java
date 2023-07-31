package com.stc.service;

import com.stc.dto.request.AddPermissionForUserOnItemRequest;
import com.stc.dto.response.Response;


public interface ItemWUserPermissionService {
    Response addOperationForUserOnItem(AddPermissionForUserOnItemRequest permissionRequest);
}
