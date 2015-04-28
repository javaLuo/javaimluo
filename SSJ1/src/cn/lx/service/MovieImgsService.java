package cn.lx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lx.bean.MovieImgs;
import cn.lx.dao.MovieImgsDao;


/**
 * 留言 服务类
 * */
@Service
public class MovieImgsService{
	
	@Autowired
	private MovieImgsDao md;


	/**
	 * 获取电影详细信息
	 * */
	public List<MovieImgs> getMovieImgs(String movieid)
	{
		return md.getMovieImgs(Integer.parseInt(movieid));
	}
}
