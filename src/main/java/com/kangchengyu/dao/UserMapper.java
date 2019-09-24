package com.kangchengyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kangchengyu.entity.User;

/**
*@author 康成玉
*@version 
*用户Mapper
*/
@Mapper
public interface UserMapper {
	
//------------------------------------------------## 增加 ##----------------------------------------------------------

	/**
	 * 增加一个新的用户（用于注册）
	 * @param user
	 * @return
	 */
	int add(User user);
	

//-------------------------------------------------## 修改 ##---------------------------------------------------------
	
	/**
	 * 修改一个用户信息
	 * @param user
	 * @return
	 */
	int update(User user);
	
	/**
	 * 修改用户的锁定状态
	 * @param userId
	 * @param locked
	 * @return
	 */
	int updateLocked(@Param("userId") Integer userId, @Param("locked") Integer locked);
	
//-----------------------------------------------## 查找 ##-----------------------------------------------------------

	/**
	 *  根据用户名查找  用于登录的时候和  注册用户名称唯一性校验
	 * @param userName
	 * @return
	 */
	User findByName(String userName);
	
	/**
	 * 根据用户id查找用户
	 * @param id
	 * @return
	 */
	User findById(Integer id);
	
	/**
	 *  获取用户的列表
	 * @param user
	 * @return
	 */
	List<User> select(User user);

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<User> queryList(@Param("name") String name);


	
	
}
