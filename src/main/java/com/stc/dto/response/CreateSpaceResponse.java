package com.stc.dto.response;

import com.stc.entity.Item;
import com.stc.entity.ItemType;
import com.stc.entity.ItemWUserPermission;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateSpaceResponse extends Response {

    List<ItemWUserPermission> ItemUserPermission = new ArrayList<>();
    private long id;
    private ItemType type;
    private String name;
    private Item locationId;

    public CreateSpaceResponse(int responseCode, long id, ItemType type, String name, Item locationId, List<ItemWUserPermission> itemUserPermission) {
        super(responseCode);
        this.id = id;
        this.type = type;
        this.name = name;
        this.locationId = locationId;
        ItemUserPermission = itemUserPermission;
    }
}
