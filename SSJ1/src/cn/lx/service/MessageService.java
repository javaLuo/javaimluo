package cn.lx.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lx.bean.Message;
import cn.lx.dao.MessageDao;

/**
 * 留言 服务类
 * */
@Service
public class MessageService{
	
	@Autowired
	private MessageDao md;
	
	/**
	 * 增加留言
	 * */
	@Transactional
	public Message putMessage(String username,String info){
		Message m = new Message();
		m.setUsername(username);
		m.setInfo(info);
		m.setTime(new Date());
		md.save(m);
		return m;
	}

	/**
	 * 获取留言列表
	 * */
	public List<Message> getMessage(String rownow, int messagePage) {
		return md.getMessage(Integer.parseInt(rownow),messagePage);
	}

}
