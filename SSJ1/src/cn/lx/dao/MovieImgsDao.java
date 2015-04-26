package cn.lx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lx.bean.Movie;
import cn.lx.bean.MovieImgs;
import cn.lx.bean.MoviePojo1;

@Repository
public interface MovieImgsDao extends JpaRepository<MovieImgs, Integer>
{

	@Query(value="select * from movie_imgs where movie_id=?1 order by ordernum asc",nativeQuery=true)
	List<MovieImgs> getMovieImgs(Integer movieid);

}