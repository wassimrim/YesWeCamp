package com.camping.YesWeCamp.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camping.YesWeCamp.models.Article;

@RepositoryRestResource(path="articles",collectionResourceRel="articles")
public interface ArticleRestRepository extends PagingAndSortingRepository<Article, Long> {

}
