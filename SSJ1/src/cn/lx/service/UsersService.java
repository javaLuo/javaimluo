package cn.lx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lx.bean.Users;
import cn.lx.dao.UsersDao;

@Service
public class UsersService
{
	@Autowired
	private UsersDao ud;
	
	public void save(Users u)
	{
		ud.save(u);
	}
}
