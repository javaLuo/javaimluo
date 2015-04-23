package cn.lx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.lx.bean.Message;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer>
{

}