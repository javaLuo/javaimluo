package cn.lx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lx.bean.Game;
import cn.lx.bean.Movie;

@Repository
public interface GameDao extends JpaRepository<Game, Integer>
{

	@Query(value="select * from game order by id asc",nativeQuery=true)
	List<Game> getGameList();

	@Query(value="select * from game where id=?1",nativeQuery=true)
	List<Game> getOneGame(Integer id);


}