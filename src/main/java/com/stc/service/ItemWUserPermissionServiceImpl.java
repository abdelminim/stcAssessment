package com.stc.service;

import com.stc.constant.ResponseCodes;
import com.stc.dto.request.AddPermissionForUserOnItemRequest;
import com.stc.dto.response.AddPermissionForUserOnItemResponse;
import com.stc.dto.response.Response;
import com.stc.entity.Item;
import com.stc.entity.ItemWUserPermission;
import com.stc.entity.PermissionLevel;
import com.stc.entity.ServiceUser;
import com.stc.repo.ItemRepo;
import com.stc.repo.ItemWUserPermissionRepo;
import com.stc.repo.ServiceUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemWUserPermissionServiceImpl implements ItemWUserPermissionService {
    private final ItemWUserPermissionRepo itemWUserPermissionRepo;
    private final ItemRepo itemRepo;
    private final ServiceUserRepo userRepo;


    @Override
    public Response addOperationForUserOnItem(AddPermissionForUserOnItemRequest permissionRequest) {

        ServiceUser user = userRepo.findByUserEmail(permissionRequest.getUserEmail());
        if (Objects.isNull(user)) {
            log.info("user not found in database");
            return new Response(ResponseCodes.USER_NOT_EXIST);
        }
        if (Objects.nonNull(permissionRequest.getFile())) {
            return addPermissionForFile(permissionRequest, user);

        } else if (Objects.nonNull(permissionRequest.getFolder())) {
            return addPermissionForFolder(permissionRequest, user);

        } else if (Objects.nonNull(permissionRequest.getSpace())) {
            return addPermissionForSpace(permissionRequest, user);
        }
        return new Response(ResponseCodes.PERMISSION_NOT_ASSIGN);
    }

    private Response addPermissionForFile(AddPermissionForUserOnItemRequest permissionRequest, ServiceUser user) {
        if (Objects.isNull(permissionRequest.getSpace()))
            return new Response(ResponseCodes.INVALID_LOCATION);
        long fileLocationId = -1;
        if (Objects.nonNull(permissionRequest.getFolder())) {
            fileLocationId = itemRepo.findLocationIdBySpaceAndFolder(permissionRequest.getSpace(),
                    permissionRequest.getFolder()).orElse(Long.valueOf(-1));
        } else {
            fileLocationId = itemRepo.findItemByLocationIdAndName(1,
                    permissionRequest.getSpace()).orElse(Item.builder().id(-1).build()).getId();
        }
        if (fileLocationId == -1) return new Response(ResponseCodes.INVALID_LOCATION);

        Item fileItem = itemRepo.findItemByLocationIdAndName(fileLocationId, permissionRequest.getFile()).orElse(new Item());
        if (Objects.isNull(fileItem.getName()))
            return new Response(ResponseCodes.FILE_NOT_EXIST);

        return getAddPermissionForUserOnItemResponse(permissionRequest, user, fileItem);
    }

    private Response addPermissionForFolder(AddPermissionForUserOnItemRequest permissionRequest, ServiceUser user) {
        long folderLocation = itemRepo.findItemByLocationIdAndName(1,
                permissionRequest.getSpace()).orElse(new Item()).getId();
        if (folderLocation == 0)
            return new Response(ResponseCodes.INVALID_LOCATION);
        Item folerItem = itemRepo.findItemByLocationIdAndName(folderLocation, permissionRequest.getFolder()).orElse(new Item());
        if (Objects.isNull(folerItem))
            return new Response(ResponseCodes.FOLDER_NOT_EXIST);

        return getAddPermissionForUserOnItemResponse(permissionRequest, user, folerItem);
    }

    private Response addPermissionForSpace(AddPermissionForUserOnItemRequest permissionRequest, ServiceUser user) {
        Item spaceItem = itemRepo.findItemByLocationIdAndName(1, permissionRequest.getSpace()).orElse(new Item());
        if (Objects.isNull(spaceItem))
            return new Response(ResponseCodes.SPACE_NOT_EXIST);

        return getAddPermissionForUserOnItemResponse(permissionRequest, user, spaceItem);
    }

    private Response getAddPermissionForUserOnItemResponse(AddPermissionForUserOnItemRequest permissionRequest,
                                                           ServiceUser user, Item item) {
        if (checkIfPermissionExistBefore(permissionRequest, user, item))
            return new Response(ResponseCodes.PERMISSION_LEVEL_EXIST_BEFORE);
        ItemWUserPermission itemWUserPermission = ItemWUserPermission.builder().
                item(item).operation(permissionRequest.getPermissionLevel()).
                user(user).build();

        itemWUserPermission = itemWUserPermissionRepo.save(itemWUserPermission);
        return new AddPermissionForUserOnItemResponse(ResponseCodes.PERMISSION_ASSIGN, itemWUserPermission);
    }

    private boolean checkIfPermissionExistBefore(AddPermissionForUserOnItemRequest permissionRequest,
                                                 ServiceUser user, Item item) {

        List<ItemWUserPermission> permissionList = itemWUserPermissionRepo.findItemWUserPermissionByUserAndItem(user, item).orElse(new ArrayList<>());
        if (permissionList.isEmpty()) {
            return false;
        }

        List<PermissionLevel> permissions = permissionList.stream().map(x -> x.getOperation()).collect(Collectors.toList());
        if (!permissions.contains(permissionRequest.getPermissionLevel()))
            return false;

        return true;
    }
}
