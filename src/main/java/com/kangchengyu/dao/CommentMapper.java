package com.kangchengyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kangchengyu.entity.Comment;

/**
*@author 康成玉
*@version 
*评论mapper
*/
public interface CommentMapper {
//--------------------------------------------------## 增加 ##--------------------------------------------------------
	/**
	 * 添加一条评论
	 * @param commnet
	 * @return
	 */
	int add(Comment commnet);
//--------------------------------------------------## 删除 ##--------------------------------------------------------
	/**
	 * 删除一条评论
	 * @param userId
	 * @param cid
	 * @return
	 */
	int delete(@Param("userId") Integer userId,@Param("cid")  Integer cid);

//--------------------------------------------------## 查找 ##--------------------------------------------------------
	/**
	 * 通过文章id查询评论
	 * @param articleId
	 * @return
	 */
	List<Comment> listByArticle(Integer articleId);
	
	/**
	 * 通过用户查询评论
	 * @param userId
	 * @return
	 */
	List<Comment> listByUser(Integer userId);
}
