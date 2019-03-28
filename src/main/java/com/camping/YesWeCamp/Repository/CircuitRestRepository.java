package com.camping.YesWeCamp.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.Circuit;

@RepositoryRestResource(path="circuits",collectionResourceRel="circuits")
public interface CircuitRestRepository extends  PagingAndSortingRepository<Circuit, Long> {

}
