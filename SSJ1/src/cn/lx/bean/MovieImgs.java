package cn.lx.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * ��ӰͼƬ��
 * */
@Entity(name = "movie_imgs")
public class MovieImgs
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	//�����ĵ�Ӱ��ID
	@Column(name = "MOVIE_ID")
	private Integer movie_id;
	
	//ͼƬ·��
	@Column(name = "IMGPATH")
	private String imgpath;
	
	//������
	@Column(name = "ORDERNUM")
	private Integer ordernum;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getMovie_id()
	{
		return movie_id;
	}

	public void setMovie_id(Integer movieId)
	{
		movie_id = movieId;
	}

	public String getImgpath()
	{
		return imgpath;
	}

	public void setImgpath(String imgpath)
	{
		this.imgpath = imgpath;
	}

	public Integer getOrdernum()
	{
		return ordernum;
	}

	public void setOrdernum(Integer ordernum)
	{
		this.ordernum = ordernum;
	}

	

}
