package cn.lx.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

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
	
	@RequestMapping(value = { "/todo"})
	@ResponseBody
	public String todo(
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
					return Json.toJson(AppUtils.getErrorJson(),JsonFormat.compact());
			}
			
		} catch (Exception e) {
			System.out.println("访问出错" + e.getMessage());
		}
		return Json.toJson(AppUtils.getFieldJson(),JsonFormat.compact());
	}
	
	/**
	 * 增加留言的方法
	 * @param parameters
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private String putMessage(String parameters) throws UnsupportedEncodingException {
		//s[0]名字、s[1]内容
		String p = URLDecoder.decode(parameters,"UTF-8");
		String[] s = p.split(AppConfig.PAT);
		System.out.println(s[0]+","+s[1]);
		ReturnMsg<Message> msg = new ReturnMsg<Message>();
		messageservice.putMessage(s[0],s[1]);
		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(null);
		String json = Json.toJson(msg, JsonFormat.compact());
		System.out.println(json);
		return json;
	}
}


