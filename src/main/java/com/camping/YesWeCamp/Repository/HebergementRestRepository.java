package com.camping.YesWeCamp.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.Hebergement;

@RepositoryRestResource(path="hebergements",collectionResourceRel="hebergements")
public interface HebergementRestRepository extends PagingAndSortingRepository<Hebergement, Long> {

}
