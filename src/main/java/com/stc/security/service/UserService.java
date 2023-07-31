package com.stc.security.service;

import com.stc.entity.AppRole;
import com.stc.entity.ServiceUser;

import java.util.List;

public interface UserService {
    ServiceUser saveUser(ServiceUser user);

    AppRole saveRole(AppRole permission);

    void addRoleToUser(String userName, String role);

    ServiceUser getUser(String userName);

    List<ServiceUser> getUsers();
}
