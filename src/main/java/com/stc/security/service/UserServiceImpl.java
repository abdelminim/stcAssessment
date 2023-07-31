package com.stc.security.service;

import com.stc.entity.AppRole;
import com.stc.entity.ServiceUser;
import com.stc.repo.RoleRepo;
import com.stc.repo.ServiceUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService/*, UserDetailsService*/ {

    final private RoleRepo roleRepo;
    final private ServiceUserRepo userRepo;
//    final private PasswordEncoder passwordEncoder;


    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ServiceUser appUser = userRepo.findByUserEmail(username);
        if (Objects.isNull(appUser)) {
            log.info("user not found in database");
            throw new UsernameNotFoundException("user not found in database");
        } else {
            log.info("user found in database {}", username);
        }
        Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
        appUser.getRoles().forEach(role -> authority.add(new SimpleGrantedAuthority(role.getName())));

        return new User(appUser.getUserEmail(), appUser.getPassword(), authority);
    }*/

    /*@Override
    public ServiceUser saveUser(ServiceUser user) {
        log.info("save user name to database ");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }*/

    @Override
    public ServiceUser saveUser(ServiceUser user) {
        return null;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        log.info("save Role  {} name to database ", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        ServiceUser user = userRepo.findByUserEmail(userName);
        AppRole role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public ServiceUser getUser(String userName) {
        return userRepo.findByUserEmail(userName);
    }

    @Override
    public List<ServiceUser> getUsers() {
        return userRepo.findAll();
    }

}
