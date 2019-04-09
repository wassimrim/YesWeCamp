package com.camping.YesWeCamp.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.User;

@RepositoryRestResource(path="users",collectionResourceRel="users")
public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {
	
	

}
