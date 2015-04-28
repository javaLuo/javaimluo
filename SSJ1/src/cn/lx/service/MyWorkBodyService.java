package cn.lx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lx.bean.MyWorkBody;
import cn.lx.dao.MyWorkBodyDao;


/**
 * 我的工作 服务类
 * */
@Service
public class MyWorkBodyService{
	
	@Autowired
	private MyWorkBodyDao md;


	/**
	 * 获取详细我的工作信息
	 * */
	public List<MyWorkBody> getOneMyWork(String id) {
		return md.getOneMyWork(Integer.parseInt(id));
	}
}
