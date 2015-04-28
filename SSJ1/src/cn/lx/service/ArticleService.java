package cn.lx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.lx.bean.Article;

import cn.lx.dao.ArticleDao;


/**
 * ���·�����
 * */
@Service
public class ArticleService{
	
	@Autowired
	private ArticleDao ad;

	/**
	 * ��ȡȫ�������б�
	 * */
	public List<Article> getArticleList()
	{
		List<Article> l = ad.getArticleList();
		List<Article> l2 = new ArrayList<Article>();
		
		for(int i=0;i<l.size();i++){
			Article g = new Article();
			g.setId(l.get(i).getId());
			g.setTitle(l.get(i).getTitle());
			g.setImgpath(l.get(i).getImgpath());
			g.setAuthor(l.get(i).getAuthor());
			l2.add(g);
		}
		return l2;
	}

	/**
	 * ��ȡ��ϸ������Ϣ
	 * */
	public List<Article> getOneArticle(String id) {
		return ad.getOneArticle(Integer.parseInt(id));
	}
}
