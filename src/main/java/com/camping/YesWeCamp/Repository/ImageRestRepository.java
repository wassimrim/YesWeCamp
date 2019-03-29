package com.camping.YesWeCamp.Repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.Image;


@RepositoryRestResource(path="images",collectionResourceRel="images")
public interface ImageRestRepository extends    PagingAndSortingRepository<Image, Long>{
	
	List<Image> findByUser(String user);

}
