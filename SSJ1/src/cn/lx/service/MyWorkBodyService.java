package cn.lx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lx.bean.MyWorkBody;
import cn.lx.dao.MyWorkBodyDao;


/**
 * �ҵĹ��� ������
 * */
@Service
public class MyWorkBodyService{
	
	@Autowired
	private MyWorkBodyDao md;


	/**
	 * ��ȡ��ϸ�ҵĹ�����Ϣ
	 * */
	public List<MyWorkBody> getOneMyWork(String id) {
		return md.getOneMyWork(Integer.parseInt(id));
	}
}
