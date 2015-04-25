package cn.lx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lx.bean.Message;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer>
{

	@Query(value="select * from message order by time desc LIMIT ?1,?2",nativeQuery=true)
	List<Message> getMessage(int parseInt, int messagePage);

}