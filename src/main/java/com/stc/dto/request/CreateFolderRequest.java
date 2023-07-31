package com.stc.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonPropertyOrder({"space", "folder"})
public class CreateFolderRequest {
    @JsonProperty("space")
    private String space;
    @JsonProperty("folder")
    private String folder;

}
