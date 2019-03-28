package com.camping.YesWeCamp.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.Activite;

@RepositoryRestResource(path="activites",collectionResourceRel="activites")
public interface ActiviteRestRepository extends PagingAndSortingRepository<Activite, Long> {

}
