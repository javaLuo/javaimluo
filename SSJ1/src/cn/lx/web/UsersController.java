package cn.lx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lx.bean.Users;
import cn.lx.service.UsersService;

@Controller
@RequestMapping("/test")
public class UsersController
{
	@Autowired
	private UsersService us;
	
	@RequestMapping("/save")
	public String save(Users u)
	{
		us.save(u);
		return "welcome";
	}
}
