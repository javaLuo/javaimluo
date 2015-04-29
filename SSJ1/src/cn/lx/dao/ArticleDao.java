package cn.lx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lx.bean.Article;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer>
{

	@Query(value="select * from article order by id asc",nativeQuery=true)
	List<Article> getArticleList();

	@Query(value="select * from article where id=?1",nativeQuery=true)
	List<Article> getOneArticle(Integer id);


}