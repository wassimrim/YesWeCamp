package com.camping.YesWeCamp.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camping.YesWeCamp.Repository.UserRestRepository;
import com.camping.YesWeCamp.models.User;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
  @Autowired
  UserRestRepository userRepository;
 
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
    User user = userRepository.findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
 
    return UserPrinciple.build(user);
  }
}
