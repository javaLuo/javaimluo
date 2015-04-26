package cn.lx.bean;

import java.util.Date;

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
	private String movie_id;
	
	//ͼƬ·��
	@Column(name = "IMGPATH")
	private String imgpath;
	
	//������
	@Column(name = "ORDERNUM")
	private Date ordernum;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getMovie_id()
	{
		return movie_id;
	}

	public void setMovie_id(String movieId)
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

	public Date getOrdernum()
	{
		return ordernum;
	}

	public void setOrdernum(Date ordernum)
	{
		this.ordernum = ordernum;
	}
	
	

}
