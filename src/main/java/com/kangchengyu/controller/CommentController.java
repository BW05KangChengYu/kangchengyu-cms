package com.kangchengyu.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.kangchengyu.entity.Comment;
import com.kangchengyu.entity.User;
import com.kangchengyu.service.CommentService;
import com.kangchengyu.utils.ConstantFinal;
import com.kangchengyu.utils.PageUtil;

/**
*@author 作者:康成玉
*@version
*类功能说明 评论
*/
@Controller
@RequestMapping("commnent")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	/**
	 * 删除一条评论
	 * @param request
	 * @param id
	 * @return
	 */
	@PostMapping("del")
	@ResponseBody
	public String del(HttpServletRequest request,Integer id){
		User user =(User) request.getSession().getAttribute(ConstantFinal.USER_SESSION_KEY);
		if(user==null){
			return "false";
		               }
		int result = commentService.del(user.getId(),id);
		if(result>0)
			return "success";
		else {
			return "Sorry, your post failed, please try later";
		}
	}
	
	/**
	 * 发表评论
	 * @param request
	 * @param comment
	 * @return
	 */
	@PostMapping("post")
	@ResponseBody
	public String post(HttpServletRequest request,Comment comment){
		User user =(User) request.getSession().getAttribute(ConstantFinal.USER_SESSION_KEY);
		if(user==null){
			return "You are not logged in and cannot comment";
		               }
		comment.setUserId(user.getId());
		int result = commentService.post(comment);
		if(result>0)
			return "success";
		else {
			return "Sorry, your post failed, please try later";
		}
	}
	
	/**
	 * 获取评论列表
	 * @param request
	 * @param articleId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("getlist")
	public String getlist(HttpServletRequest request,
			Integer articleId,@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="3") Integer pageSize){
		
		PageInfo<Comment> commentsByArticle = commentService.getCommentsByArticle(articleId, page, pageSize);
		System.out.println(commentsByArticle);
		String pagestr = PageUtil.page(commentsByArticle.getPageNum(),
				commentsByArticle.getPages(), "/commnent/getlist?articleId="+articleId, 
				commentsByArticle.getPageSize());
		request.setAttribute("commenPage", commentsByArticle);
		request.setAttribute("pagestr", pagestr);
		return "index/comment/list";
		
	}
	
	/**
	 * 获取我的评论列表
	 * @param request
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("getmylist")
	public String getmylist(HttpServletRequest request,
			@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="3") Integer pageSize){
		
		User loingUser = (User)request.getSession().getAttribute(ConstantFinal.USER_SESSION_KEY);
		if(loingUser==null)
			return "redirect:/user/login";
		
		PageInfo<Comment> commentsByArticle = commentService.getCommentsByUser(loingUser.getId(), page, pageSize);
		System.out.println(commentsByArticle);
		String pagestr = PageUtil.page(commentsByArticle.getPageNum(),
				commentsByArticle.getPages(), "/commnent/getmylist", 
				commentsByArticle.getPageSize());
		request.setAttribute("commenPage", commentsByArticle);
		request.setAttribute("pagestr", pagestr);
		return "my/comment/list";
	}
	
	
}
