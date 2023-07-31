package com.stc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
public class ItemWUserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private ServiceUser user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_Id")
    @JsonBackReference
    private Item item;

    @Enumerated(EnumType.STRING)
    private PermissionLevel operation;


}
