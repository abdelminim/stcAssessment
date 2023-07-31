package com.stc.repo;

import com.stc.entity.Item;
import com.stc.entity.ItemWUserPermission;
import com.stc.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemWUserPermissionRepo extends JpaRepository<ItemWUserPermission, Long> {
    Optional<List<ItemWUserPermission>> findItemWUserPermissionByUserAndItem(ServiceUser userService, Item item);
}
