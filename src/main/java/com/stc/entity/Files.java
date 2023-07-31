package com.stc.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "files")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fileName;

    @Lob
    @Column(name = "file_Binary", length = 1000)
    private byte[] fileBinary;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Item item;

}
