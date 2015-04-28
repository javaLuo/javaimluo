package cn.lx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lx.bean.MyWorkBody;

@Repository
public interface MyWorkBodyDao extends JpaRepository<MyWorkBody, Integer>
{
	@Query(value="select * from myworkbody where mywork_id=?1 order by ordernum asc",nativeQuery=true)
	List<MyWorkBody> getOneMyWork(Integer id);
}