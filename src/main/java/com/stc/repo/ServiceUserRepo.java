package com.stc.repo;

import com.stc.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceUserRepo extends JpaRepository<ServiceUser, Long> {
    ServiceUser findByUserEmail(String userName);

}