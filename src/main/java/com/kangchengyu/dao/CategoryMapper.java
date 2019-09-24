package com.kangchengyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kangchengyu.entity.Category;

/**
*@author 康成玉
*@version 
*分类Mapper
*/
@Mapper
public interface CategoryMapper {
	

//----------------------------------------------## 查找 ##------------------------------------------------------------

	/**
	 * 查询分类列表(通过频道id，用于二级联动)
	 * @param cid
	 * @return
	 */
	List<Category> getCategoryByChId(Integer cid);
	
}
