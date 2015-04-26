package cn.lx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lx.bean.Message;
import cn.lx.bean.Movie;
import cn.lx.bean.MovieImgs;
import cn.lx.bean.MoviePojo1;
import cn.lx.dao.MessageDao;
import cn.lx.dao.MovieDao;
import cn.lx.dao.MovieImgsDao;
import cn.lx.utils.AppConfig;

/**
 * ���� ������
 * */
@Service
public class MovieImgsService{
	
	@Autowired
	private MovieImgsDao md;


	/**
	 * ��ȡ��Ӱ��ϸ��Ϣ
	 * */
	public List<MovieImgs> getMovieImgs(String movieid)
	{
		return md.getMovieImgs(Integer.parseInt(movieid));
	}
}
