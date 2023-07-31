package com.stc.repo;

import com.stc.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<Files, Long> {


}
