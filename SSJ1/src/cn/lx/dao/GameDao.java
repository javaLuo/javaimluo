package cn.lx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lx.bean.Game;
import cn.lx.bean.Movie;
import cn.lx.bean.MoviePojo1;

@Repository
public interface GameDao extends JpaRepository<Game, Integer>
{

	@Query(value="select * from game order by id asc",nativeQuery=true)
	List<Game> getGameList();


}