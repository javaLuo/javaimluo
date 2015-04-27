package cn.lx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lx.bean.Game;
import cn.lx.bean.Message;
import cn.lx.bean.Movie;
import cn.lx.bean.MoviePojo1;
import cn.lx.dao.GameDao;
import cn.lx.dao.MessageDao;
import cn.lx.dao.MovieDao;
import cn.lx.utils.AppConfig;

/**
 * ���� ������
 * */
@Service
public class GameService{
	
	@Autowired
	private GameDao gd;

	/**
	 * ��ȡȫ����Ϸ�б�
	 * */
	public List<Game> getGameList()
	{
		return gd.getGameList();
	}
}
