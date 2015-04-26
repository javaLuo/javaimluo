package cn.lx.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
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
import cn.lx.bean.Movie;
import cn.lx.bean.MovieImgs;
import cn.lx.bean.MoviePojo1;
import cn.lx.service.MessageService;
import cn.lx.service.MovieImgsService;
import cn.lx.service.MovieService;
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
	@Autowired
	private MovieService movieservice;
	@Autowired
	private MovieImgsService movieimgsservice;
	
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
				case putMessage://发表留言
					return putMessage(p);
				case getMessage://获取留言列表
					return getMessage(p);
				case getMovieList://获取电影列表
					return getMovieList(p);
				case getMovieInfo://获取电影详细信息
					return getMovieInfo(p);
				default:
					return Json.toJson(AppUtils.getErrorJson(),JsonFormat.compact());
			}
			
		} catch (Exception e) {
			System.out.println("访问出错");
			e.printStackTrace();
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
		Message m = messageservice.putMessage(s[0],s[1]);
		List<Message> l = new ArrayList<Message>();
		l.add(m);
		
		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(l);
		
		String json = Json.toJson(msg, JsonFormat.compact());
		System.out.println(json);
		return json;
	}
	
	/**
	 * 分页获取留言列表
	 * @param parameters
	 * @return
	 */
	private String getMessage(String parameters){
		String[] s = parameters.split(AppConfig.PAT);
		ReturnMsg<Message> msg = new ReturnMsg<Message>();
		List<Message> l = messageservice.getMessage(s[0],AppConfig.MESSAGE_PAGE);
		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(l);
		String json = Json.toJson(msg, JsonFormat.compact());
		System.out.println(json);
		return json;
	}
	
	/**
	 * 分页获取电影列表
	 * */
	private String getMovieList(String p){
		String[] s = p.split(AppConfig.PAT);
		ReturnMsg<Movie> msg = new ReturnMsg<Movie>();
		List<Movie> l = movieservice.getMovieList(s[0],15);
		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(l);
		String json = Json.toJson(msg, JsonFormat.compact());
		System.out.println(json);
		return json;
	}
	
	/**
	 * 获取电影详细信息
	 * */
	private String getMovieInfo(String p){
		String[] s = p.split(AppConfig.PAT);
		ReturnMsg<Movie> msg = new ReturnMsg<Movie>();
		
		//Movie m = movieservice.getMovieInfo(s[0]);
		
		List<MovieImgs> mi = movieimgsservice.getMovieImgs(s[0]);
		//m.setMovieimgs(mi);
		System.out.println(Json.toJson(mi,JsonFormat.compact()));
		//List<Movie> l = new ArrayList<Movie>();
		//l.add(m);
		
		//msg.setCode(AppConfig.OK_STATUS);
		//msg.setList(l);

		//String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
		//return json;
		return null;
	}
}


