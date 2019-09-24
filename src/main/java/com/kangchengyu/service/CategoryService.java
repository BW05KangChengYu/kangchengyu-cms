package com.kangchengyu.service;

import java.util.List;

import com.kangchengyu.entity.Category;

/**
*@author 康成玉
*@version 
*类功能说明
*/
public interface CategoryService {
	/**
	 * 通过频道id查询分类列表
	 * @param cid
	 * @return
	 */
	List<Category> getCategoryByChId(Integer cid);
}
