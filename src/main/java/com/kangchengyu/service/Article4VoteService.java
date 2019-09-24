package com.kangchengyu.service;

import java.util.List;

import com.kangchengyu.entity.Article4Vote;
import com.kangchengyu.entity.VoteStatic;

/**
 * @author 康成玉
 * @version 
 *
 */
public interface Article4VoteService {

	/**
	 * 发布一个投票
	 * @param av
	 * @return
	 */
	int publish(Article4Vote av);

	/**
	 * 增加一条投票记录
	 * 
	 * @param userId
	 * @param articleId
	 * @param option
	 * @return
	 */
	int vote(Integer userId, Integer articleId, Character option);

	/**
	 * 查看已有投票信息
	 * @param id
	 * @return
	 */
	Article4Vote findById(Integer id);

	/**
	 * 查看最新十条投票信息
	 * @return
	 */
	List<Article4Vote> list();

	/**
	 * 统计每个人获票次数
	 * @param articleId
	 * @return
	 */
	List<VoteStatic> getVoteStatics(Integer articleId);
}
