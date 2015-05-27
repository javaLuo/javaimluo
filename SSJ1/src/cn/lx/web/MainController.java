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
				case putMessage://��������
					return putMessage(p);
				case getMessage://��ȡ�����б�
					return getMessage(p);
				case getMovieList://��ȡ��Ӱ�б�
					return getMovieList(p);
				case getMovieInfo://��ȡ��Ӱ��ϸ��Ϣ
					return getMovieInfo(p);
				case getGameList://��ȡȫ����Ϸ�б�
					return getGameList(p);
				case gameOpen://��ȡ��Ϸ��ϸ��Ϣ
					return gameOpen(p);
				case getArticleList://��ȡȫ�������б�
					return getArticleList(p);
				case getOneArticle://��ȡ��ϸ������Ϣ
					return getOneArticle(p);
				case getAllWorks://��ȡȫ���ҵĹ����б�
					return getAllWorks(p);
				case getOneMyWork://��ȡ�ҵĹ�����ϸ��Ϣ
					return getOneMyWork(p);
				default:
					return Json.toJson(AppUtils.getErrorJson(),JsonFormat.compact());
			}
			
		} catch (Exception e) {
			System.out.println("���ʳ���");
			e.printStackTrace();
		}
		return Json.toJson(AppUtils.getFieldJson(),JsonFormat.compact());
	}
	
	/**
	 * �������Եķ���
	 * @param parameters
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private String putMessage(String parameters) throws UnsupportedEncodingException {
		//s[0]���֡�s[1]����

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
	 * ��ҳ��ȡ�����б�
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
	 * ��ҳ��ȡ��Ӱ�б�
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
	 * ��ȡ��Ӱ��ϸ��Ϣ
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
	 * ��ȡȫ����Ϸ�б�
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
	 * ��ȡ��ϸ��Ϸ��Ϣ
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
	 * ��ȡȫ�������б�
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
	 * ��ȡ��ϸ������Ϣ
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
	 * ��ȡȫ���ҵĹ����б�
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
	 * ��ȡ�ҵĹ�����ϸ��Ϣ
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


