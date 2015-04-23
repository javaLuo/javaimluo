package cn.lx.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lx.bean.Message;
import cn.lx.dao.MessageDao;

@Service
public class MessageService{
	
	@Autowired
	private MessageDao md;
	
	@Transactional
	public void putMessage(String username,String info){
		Message m = new Message();
		m.setUsername(username);
		m.setInfo(info);
		m.setTime(new Date());
		md.save(m);
	}

}
