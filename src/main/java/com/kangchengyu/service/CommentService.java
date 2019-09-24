package com.kangchengyu.service;

import com.github.pagehelper.PageInfo;
import com.kangchengyu.entity.Comment;

/**
*@author 康成玉
*@version 
*评论
*/
public interface CommentService {
	
	/**
	 * 发布一个评论
	 * @param commnet
	 * @return
	 */
	int post(Comment commnet);
	
	/**
	 * 删除一个评论
	 * @param userId
	 * @param id
	 * @return
	 */
	int del(Integer userId, Integer cid);
	
	/**
	 * 查询指定文章的评论
	 * @param articleId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Comment> getCommentsByArticle(Integer articleId,Integer pageNum,Integer pageSize);
	
	/**
	 * 查询指定用户的评论
	 * @param id
	 * @param page
	 * @param pageSize
	 * @return
	 */
	PageInfo<Comment> getCommentsByUser(Integer userId, Integer page,
			Integer pageSize);
	
	
}
