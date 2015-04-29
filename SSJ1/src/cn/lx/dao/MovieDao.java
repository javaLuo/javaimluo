package cn.lx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lx.bean.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer>
{

	@Query(value="select * from movie order by id asc LIMIT ?1,?2",nativeQuery=true)
	List<Movie> getMovieList(int pagenow, int messagePage);

	@Query(value="select * from movie where id=?1",nativeQuery=true)
	List<Movie> getOneMovie(int id);

}