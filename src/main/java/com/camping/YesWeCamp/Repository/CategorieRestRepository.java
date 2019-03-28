package com.camping.YesWeCamp.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.Categorie;

@RepositoryRestResource(path="categories",collectionResourceRel="categories")
public interface CategorieRestRepository extends PagingAndSortingRepository<Categorie, Long> {
 
}
