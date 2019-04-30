package com.camping.YesWeCamp.Repository;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.User;

@RepositoryRestResource(path="users",collectionResourceRel="users")
public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
