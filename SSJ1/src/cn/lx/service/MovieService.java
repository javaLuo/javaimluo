package cn.lx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lx.bean.Message;
import cn.lx.bean.Movie;
import cn.lx.bean.MoviePojo1;
import cn.lx.dao.MessageDao;
import cn.lx.dao.MovieDao;
import cn.lx.utils.AppConfig;

/**
 * ���� ������
 * */
@Service
public class MovieService{
	
	@Autowired
	private MovieDao md;

	/**
	 * ��ҳ��ȡ�����б�
	 * */
	public List<Movie> getMovieList(String rownow, int max)
	{
		List<Movie> l = md.getMovieList(Integer.parseInt(rownow),max);
		List<Movie> l2 = new ArrayList<Movie>();
		for(int i=0;i<l.size();i++){
			Movie m = new Movie();
			m.setId(l.get(i).getId());
			m.setImgpath(AppConfig.BASEPATH+l.get(0).getImgpath());
			l2.add(m);
		}
		return l2;
	}

	/**
	 * ��ȡ��Ӱ��ϸ��Ϣ
	 * */
	public List<Movie> getMovieInfo(String id)
	{
		return md.getOneMovie(Integer.parseInt(id));
	}
}
