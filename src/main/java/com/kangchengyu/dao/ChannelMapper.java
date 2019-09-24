package com.kangchengyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.kangchengyu.entity.Channel;

/**
*@author 康成玉
*@version 
*频道Mapper
*/
public interface ChannelMapper {


//----------------------------------------------------## 查找 ##------------------------------------------------------

	/**
	 * 查询所有频道
	 * @return
	 */
	List<Channel> getChannels();
}
