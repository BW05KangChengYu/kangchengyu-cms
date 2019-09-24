package com.kangchengyu.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kangchengyu.entity.Comment;
import com.kangchengyu.service.CommentService;

/**
 * 用于评论测试
 * @author apple
 *
 */
public class TestComment   extends TestBase{
	
	@Autowired
	CommentService commentService;
	
	@Test
	public void testInsert(){
		
		Comment comment = new Comment();
		comment.setArticleId(20);
		comment.setContent("这是对我的单元测试");
		comment.setUserId(37);
		commentService.post(comment);
		
	}
	@Test
	public void test(){
		String s = "/admin/";
		System.out.println(	s.matches("^/admin/\\w*"));
	}
	
}
