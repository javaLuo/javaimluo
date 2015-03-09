package cn.lx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.lx.bean.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer>
{

}
