package com.kangchengyu.service;

import java.util.List;

import com.kangchengyu.entity.Channel;

/**
*@author 康成玉
*@version 
*用于查询频道
*/
public interface ChannelService {
	
	/**
	 * 查询频道列表
	 * @return
	 */
	List<Channel> getChannels();
}
