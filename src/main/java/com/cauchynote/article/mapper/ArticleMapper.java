package com.cauchynote.article.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cauchynote.article.entity.Article;

/**
 * 
 * @author Cauchy
 * @ClassName ArticleMapper.java
 * @Date 2019年12月12日
 * @Description 文章持久层
 * @Version V0.1
 *
 */
@Repository
public interface ArticleMapper {
	@Insert("insert into article(title,content,author_id,create_time,status) values(#{title},#{content},#{authorId},#{createTime},#{status})")
	@Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
	void addArticle(Article article);
	@Update("update article set status = 2 where id = #{id}")
	void deleteArticle(Long id);
	@Update("update article set title = #{title},content = {content}, modify_time = #{modify_time} where id = {id}")
	void modifyArticle(Article article);
	@Select("select id,title,content,author_id,create_time,status from article where id = #{id}")
	Article getArticle(Long id);
	@Select("select id,title,create_time,modify_time from article")
	List<Article> getArticleList();
	
}
