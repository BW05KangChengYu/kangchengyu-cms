package com.kangchengyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kangchengyu.entity.Article;

/**
*@author 康成玉
*@version
*文章Mapper
*/
@Mapper
public interface ArticleMapper {
	
//------------------------------------------------## 增加 ##----------------------------------------------------------

	/**
	 * 添加一篇文章
	 * @param article
	 * @return
	 */
	int add(Article article);



//------------------------------------------------## 修改 ##----------------------------------------------------------

	/**
	 * 修改文章的状态
	 * @param id
	 * @param status 0 未审核 1 审核 通过 2审核不通过
	 * @return
	 */
	int updateStatus(@Param("id") Integer id, @Param("status") Integer status);
	
	/**
	 * 设置热门
	 * @param id
	 * @param status
	 * @return
	 */
	int updateHot(@Param("id") Integer id, @Param("hot") Integer hot);
	
	/**
	 * 增加评论量
	 * @param articleId
	 */
	void increaseCommentCnt(Integer articleId);
	
	/**
	 * 修改文章内容
	 * @param id
	 * @param title
	 * @param categoryId
	 * @param channelId
	 * @param content1
	 * @return
	 */
	int updatea(@Param("id")Integer id,@Param("title") String title,@Param("categoryId") Integer categoryId, @Param("channelId")Integer channelId,@Param("content1") String content1);
//-------------------------------------------------## 查询 ##---------------------------------------------------------

	/**
	 * 通过文章id寻找指定文章（可判断，回显）
	 * @param articleId
	 * @return
	 */
	Article findById(Integer articleId);
	
	/**
	 * 查询文章列表，可以指定频道id和分类id
	 * @param channelId
	 * @param cid
	 * @return
	 */
	List<Article> list(@Param("channelId") Integer channelId,
			@Param("catId") Integer cid);

	
	
	
	
	/**
	 * 查询指定用户的文章（通过用户id查找）
	 * @param userId
	 * @return
	 */
	List<Article> listByUser(@Param("userId") Integer userId);

	/**
	 * 获取指定审核状态的文章
	 * @param status
	 * @return
	 */
	List<Article> checkList(@Param("status")Integer status);

	

	/**
	 * 获取热门文章
	 * @return
	 */
	List<Article> hotList(@Param("title") String title);

	
	/** 
	 * 获取最新文章
	 * @return
	 */
	List<Article> lastArticles();
	
	
	
	
}
