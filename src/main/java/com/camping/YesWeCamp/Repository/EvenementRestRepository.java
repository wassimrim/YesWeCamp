package com.camping.YesWeCamp.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.Evenement;

@RepositoryRestResource(path="evenements",collectionResourceRel="evenements")
public interface EvenementRestRepository extends PagingAndSortingRepository<Evenement, Long> {

}
