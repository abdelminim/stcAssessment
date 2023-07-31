package com.stc.dto.request;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CreateFileRequest implements Serializable {

    private byte[] fileBinary;

    private String space;

    private String folder;

    private String file;

}
