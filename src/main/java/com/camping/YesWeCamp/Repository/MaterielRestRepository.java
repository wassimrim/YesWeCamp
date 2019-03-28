package com.camping.YesWeCamp.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.Materiel;

@RepositoryRestResource(path="materiels",collectionResourceRel="materiels")
public interface MaterielRestRepository extends PagingAndSortingRepository<Materiel, Long> {

}
