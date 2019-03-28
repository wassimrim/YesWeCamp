package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.ArticleRestRepository;
import com.camping.YesWeCamp.models.Article;

@Component
public class ArticleService {

	private final ArticleRestRepository articleRepository;

	public ArticleService(ArticleRestRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}

	public Article addArticle(Article article) {
		return articleRepository.save(article);
	}

	public Optional<List<Article>> getAllArticle() {
		List<Article> articles = new ArrayList<Article>();

		for (Article article : articleRepository.findAll()) {
			articles.add(article);
		}
		return Optional.of(articles);
	}

	public Optional<Article> getArticleById(Long id) {
		return articleRepository.findById(id);
	}

	public void deleteArticle(Long id) {

		articleRepository.deleteById(id);

	}

	public Article updateArticle(Long id,Article article) {
		
		
		Article articleFound = articleRepository.findById(id).get();
		
		
		articleFound.setLabelle(article.getLabelle());
		articleFound.setDescription(article.getDescription());
		articleFound.setPrix(article.getPrix());
		articleFound.setQuantite(article.getQuantite());
		
		articleRepository.save(articleFound);
		
		return articleFound;
	}

}
