package cn.lx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lx.bean.MyWork;
import cn.lx.dao.MyWorkDao;


/**
 * �ҵĹ��� ������
 * */
@Service
public class MyWorkService{
	
	@Autowired
	private MyWorkDao md;

	/**
	 * ��ȡȫ���ҵĹ����б�
	 * */
	public List<MyWork> getMyWorkList()
	{
		List<MyWork> l = md.getMyWorkList();
		List<MyWork> l2 = new ArrayList<MyWork>();
		
		for(int i=0;i<l.size();i++){
			MyWork g = new MyWork();
			g.setId(l.get(i).getId());
			g.setTitle(l.get(i).getTitle());
			g.setTitleinfo(l.get(i).getTitleinfo());
			g.setImgpath(l.get(i).getImgpath());
			l2.add(g);
		}
		return l2;
	}
}
