package com.stc.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(uniqueConstraints = {@UniqueConstraint
        (name = "UniqueItemInPlace", columnNames = {"location_id", "type", "name"})})
public class Item {
    @OneToMany(mappedBy = "item")
    List<ItemWUserPermission> ItemUserPermission = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "varchar(20)")
    private ItemType type;
    @Column(name = "name", columnDefinition = "varchar(50)")
    private String name;
    @ManyToOne
    @JoinColumn(name = "location_id ")
    @JsonBackReference
    private Item locationId;


}