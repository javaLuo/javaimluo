package cn.lx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lx.bean.MovieImgs;
import cn.lx.dao.MovieImgsDao;


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
