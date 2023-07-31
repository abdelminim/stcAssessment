package com.stc.service;

import com.stc.dto.request.CreateFileRequest;
import com.stc.dto.response.Response;
import com.stc.repo.FileRepo;
import com.stc.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {
    public final FileRepo fileRepo;
    public final ItemRepo itemRepo;

    public Response createFile(CreateFileRequest createFileRequest) {
        return null;
    }
}
