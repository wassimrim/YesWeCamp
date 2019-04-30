package com.camping.YesWeCamp.Repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.camping.YesWeCamp.models.Role;
import com.camping.YesWeCamp.models.RoleName;

public interface RoleRestRepository extends PagingAndSortingRepository<Role, Long>{
	
	Optional<Role> findByName(RoleName roleName);

}
