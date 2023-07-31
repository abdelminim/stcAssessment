package com.stc.repo;

import com.stc.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepo extends JpaRepository<Item, Long> {
    @Query(value = "SELECT i.id from item i where i.type = 'folder' and i.name =:folder and " +
            " i.location_id = (select d.id  from item d where d.type='space' and d.name =:space) ",
            nativeQuery = true)
    Optional<Long> findLocationIdBySpaceAndFolder(@Param("space") String space, @Param("folder") String folder);

    @Query(value = "select i.* from item i where i.type =:itemType and i.name=:name", nativeQuery = true)
    Optional<Item> findItemByNameAndItemType(@Param("name") String name, @Param("itemType") String itemType);

    Optional<Item> findItemById(long id);

    Optional<List<Item>> findItemByLocationId(long id);

    @Query(value = "select i.* from item i where i.location_id =:locationId and i.name=:name ", nativeQuery = true)
    Optional<Item> findItemByLocationIdAndName(long locationId, String name);

    @Query(value = "INSERT INTO `item`" +
            "(`id`, " +
            "`name`, " +
            "`type`, " +
            "`location_id`) " +
            "VALUES " +
            "(1,'root','root',1) ", nativeQuery = true)
    void createRootLocation();
}
