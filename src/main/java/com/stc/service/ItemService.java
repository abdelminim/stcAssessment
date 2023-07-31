package com.stc.service;

import com.stc.dto.request.CreateFileRequest;
import com.stc.dto.request.CreateFolderRequest;
import com.stc.dto.request.CreateSpaceRequest;
import com.stc.dto.response.Response;

public interface ItemService {
    Response createSpace(CreateSpaceRequest createSpaceRequest);

    Response createFolder(CreateFolderRequest createFolderRequest);

    Response createFile(CreateFileRequest createFileRequest);

    void prepareRoot();

}
