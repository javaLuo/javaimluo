package cn.lx.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lx.bean.Message;
import cn.lx.service.MessageService;
import cn.lx.utils.AppConfig;
import cn.lx.utils.AppUtils;
import cn.lx.utils.ReturnMsg;
import cn.lx.utils.MethodEnum;

@Controller
@RequestMapping("/main")
public class MainController
{
	@Autowired
	private MessageService messageservice;
	
	@RequestMapping(value = { "todo"})
	@ResponseBody
	public ReturnMsg<?> todo(
			@RequestParam(value = "m", required = false) String m,
			@RequestParam(value = "p", required = false) String p,
			HttpSession session, HttpServletRequest request){
		try {
				System.out.println("------------------------------------------------------------");
				System.out.println("methodCode:" + m + "     parameters :" + p);
				System.out.println("------------------------------------------------------------");

			switch (MethodEnum.getMethod(m)) {
				case putMessage:
					return putMessage(p);
				default:
					return AppUtils.getErrorJson();
			}
			
		} catch (Exception e) {
			System.out.println("访问出错......" + e.getMessage());
		}
		return AppUtils.getFieldJson();
	}
	
	/**
	 * 增加留言的方法
	 * @param parameters
	 * @return
	 */
	private ReturnMsg<Message> putMessage(String parameters) {
		//s[0]名字、s[1]内容
		String[] s = parameters.split(AppConfig.PAT);
		ReturnMsg<Message> msg = new ReturnMsg<Message>();
		messageservice.putMessage(s[0],s[1]);
		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(null);
		return msg;
	}
}


