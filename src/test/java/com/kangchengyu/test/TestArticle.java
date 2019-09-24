package com.kangchengyu.test;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bwie.kangchengyu.FileUtils;
import com.kangchengyu.entity.Article;
import com.kangchengyu.service.ArticleService;

/**
 * 
 * @author apple
 *
 */
public class TestArticle  extends TestBase{
	
	@Autowired
	ArticleService arServie;
	
	// D:\高级\复习\src\上传下载
	@Test
	public void Test(){
		List<String> fileList = FileUtils.getFileList("F:\\xjwjj");
		for (String string : fileList) {
			System.out.println(string);
		}
	}
	
	
	@Test
	public void TestImp(){
		
		int channelId[]={1,2,3,4,5,6,7,8};
		
		//读取这个文件夹内文章的名称
		List<String> fileList = FileUtils.getFileList("F:\\xjwjj");
		//随机数
		Random random = new Random();
		//遍历这个文件夹的内容
		for (String string : fileList) {
			
			try {
				//new一个文章
				Article article = new Article();
				String content;
				//获取这个文件的内容赋值给这个变量
				content = FileUtils.readFile(string);
				//设置内容
				article.setContent(content);
				//设置名称								截取后缀名
				article.setTitle(string.substring(string.lastIndexOf('\\')+1 , string.lastIndexOf('.')));
				article.setHits(10 + random.nextInt(90));//
				article.setHot(random.nextInt(2));
				article.setUserId(37);
				article.setChannelId(channelId[random.nextInt(8)]);
				arServie.add(article);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("string :" + string);
				e.printStackTrace();
			}
			
			
		}
	}
	

}
