package cn.lx.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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

import cn.lx.bean.Article;
import cn.lx.bean.Game;
import cn.lx.bean.Message;
import cn.lx.bean.Movie;
import cn.lx.bean.MyWork;
import cn.lx.bean.MyWorkBody;
import cn.lx.service.ArticleService;
import cn.lx.service.GameService;
import cn.lx.service.MessageService;
import cn.lx.service.MovieService;
import cn.lx.service.MyWorkBodyService;
import cn.lx.service.MyWorkService;
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
	private GameService gameservice;
	@Autowired
	private ArticleService articleservice;
	@Autowired
	private MyWorkService myworkservice;
	@Autowired
	private MyWorkBodyService myworkbodyservice;

	
	@RequestMapping(value = { "/todo"})
	@ResponseBody
	public String todo(
			@RequestParam(value = "m", required = false) String m,
			@RequestParam(value = "p", required = false) String p,
			HttpSession session, HttpServletRequest request){
		try {
			System.out.println("methodCode:" + m + "     parameters :" + p);

			if("GET".equals(request.getMethod()))return null;
			String referer = request.getHeader("Referer");
			//System.out.println("host="+referer);
			if(!("http://www.isluo.com/index.html".equals(referer) || "http://isluo.com/index.html".equals(referer) || "http://120.24.86.115/index.html".equals(referer)))return null;
			
			switch (MethodEnum.getMethod(m)) {
				case putMessage://发表留言
					return putMessage(p);
				case getMessage://获取留言列表
					return getMessage(p);
				case getMovieList://获取电影列表
					return getMovieList(p);
				case getMovieInfo://获取电影详细信息
					return getMovieInfo(p);
				case getGameList://获取全部游戏列表
					return getGameList(p);
				case gameOpen://获取游戏详细信息
					return gameOpen(p);
				case getArticleList://获取全部文章列表
					return getArticleList(p);
				case getOneArticle://获取详细文章信息
					return getOneArticle(p);
				case getAllWorks://获取全部我的工作列表
					return getAllWorks(p);
				case getOneMyWork://获取我的工作详细信息
					return getOneMyWork(p);
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
		
		ReturnMsg<Message> msg = new ReturnMsg<Message>();
		Message m = messageservice.putMessage(s[0],s[1]);
		List<Message> l = new ArrayList<Message>();
		l.add(m);
		
		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(l);
		
		String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
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
		//System.out.println(json);
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
		//System.out.println(json);
		return json;
	}
	
	/**
	 * 获取电影详细信息
	 * */
	private String getMovieInfo(String p){
		String[] s = p.split(AppConfig.PAT);
		ReturnMsg<Movie> msg = new ReturnMsg<Movie>();
		
		List<Movie> m = movieservice.getMovieInfo(s[0]);

		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(m);

		String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
		return json;
	}
	
	/**
	 * 获取全部游戏列表
	 * */
	private String getGameList(String p){
		ReturnMsg<Game> msg = new ReturnMsg<Game>();
		List<Game> m = gameservice.getGameList();

		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(m);

		String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
		return json;
	}
	
	/**
	 * 获取详细游戏信息
	 * */
	private String gameOpen(String p){
		String[] s = p.split(AppConfig.PAT);
		ReturnMsg<Game> msg = new ReturnMsg<Game>();
		List<Game> m = gameservice.gameOpen(s[0]);

		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(m);

		String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
		return json;
	}
	
	/**
	 * 获取全部文章列表
	 * */
	private String getArticleList(String p){
		ReturnMsg<Article> msg = new ReturnMsg<Article>();
		List<Article> m = articleservice.getArticleList();

		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(m);

		String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
		return json;
	}
	
	/**
	 * 获取详细文章信息
	 * */
	private String getOneArticle(String p){
		String[] s = p.split(AppConfig.PAT);
		ReturnMsg<Article> msg = new ReturnMsg<Article>();
		List<Article> m = articleservice.getOneArticle(s[0]);

		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(m);

		String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
		return json;
	}
	
	/**
	 * 获取全部我的工作列表
	 * */
	private String getAllWorks(String p){
		ReturnMsg<MyWork> msg = new ReturnMsg<MyWork>();
		List<MyWork> m = myworkservice.getMyWorkList();

		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(m);

		String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
		return json;
	}
	
	/**
	 * 获取我的工作详细信息
	 * */
	private String getOneMyWork(String p){
		String[] s = p.split(AppConfig.PAT);
		ReturnMsg<MyWorkBody> msg = new ReturnMsg<MyWorkBody>();
		List<MyWorkBody> m = myworkbodyservice.getOneMyWork(s[0]);

		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(m);

		String json = Json.toJson(msg, JsonFormat.compact());
		//System.out.println(json);
		return json;
	}
}


