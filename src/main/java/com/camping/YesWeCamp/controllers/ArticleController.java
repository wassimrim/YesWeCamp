package com.camping.YesWeCamp.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.camping.YesWeCamp.models.Article;
import com.camping.YesWeCamp.services.ArticleService;


@RestController
public class ArticleController {

	// private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;

	@GetMapping("/articles")
	public ResponseEntity<Optional<List<Article>>> retreiveArticles() {

		if (articleService.getAllArticle().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(articleService.getAllArticle(), HttpStatus.OK);

	}

	@GetMapping("/articles/{articleId}")
	public ResponseEntity<Optional<Article>> retreiveArticleById(@PathVariable String articleId) {

		/*
		 * log.info("information:" + ArticleService.getArticleById(Long.parseLong(ArticleId)));
		 * log.info("///////////////////");
		 */
		if (!articleService.getArticleById(Long.parseLong(articleId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(articleService.getArticleById(Long.parseLong(articleId)), HttpStatus.OK);
		}
	}

	@PostMapping("/articles")
	public ResponseEntity<Article> addArticle(@RequestBody Article article) {
		if (article.getId() != null) {
			if (articleService.getArticleById(article.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		Article articleLocal = articleService.addArticle(article);

		if (articleLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(articleLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/articles/{articleId}")
	public ResponseEntity<Article> updateArticle(@PathVariable String articleId, @RequestBody Article article) {

		if (articleService.getArticleById(article.getId()).isPresent()) {

			Article articleLocal = articleService.updateArticle(Long.parseLong(articleId), article);

			if (articleLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(articleLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/articles/{articleId}")
	public ResponseEntity<Article> deleteArticle(@PathVariable String articleId) {

		if (articleService.getArticleById(Long.parseLong(articleId)).isPresent()) {

			articleService.deleteArticle(Long.parseLong(articleId));

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ArticleId)
					.toUri();*/

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
