package com.kangchengyu.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
*@author 康成玉
*@version 
*类功能说明
*/
public class Md5Utils {
	
	/**
	 * 加严
	 */
	private static String  saltString="asdgsfdfdfsdfgssggfddgfdfg";
	
	/**
	 * 对密码进行加密
	 * @param pwd
	 * @return
	 */
	public static String md5(String pwd) {
		//对密码进行加密
		return DigestUtils.md5Hex(pwd + saltString);
	}
}

