package cn.lx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lx.bean.Game;
import cn.lx.dao.GameDao;


/**
 * ��Ϸ ������
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
		List<Game> l = gd.getGameList();
		List<Game> l2 = new ArrayList<Game>();
		
		for(int i=0;i<l.size();i++){
			Game g = new Game();
			g.setId(l.get(i).getId());
			g.setName(l.get(i).getName());
			g.setImgpath(l.get(i).getImgpath());
			l2.add(g);
		}
		return l2;
	}

	/**
	 * ��ȡ��ϸ��Ϸ��Ϣ
	 * */
	public List<Game> gameOpen(String id) {
		return gd.getOneGame(Integer.parseInt(id));
	}
}
