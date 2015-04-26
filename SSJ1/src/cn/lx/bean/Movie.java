package cn.lx.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity(name = "movie")
public class Movie
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	//��Ӱ����
	@Column(name = "TITLE")
	private String title;
	
	//����ͼƬ·��
	@Column(name = "IMGPATH")
	private String imgpath;
	
	//��Ӱ����
	@Column(name = "TYPE")
	private String type;
	
	//�Ƽ��Ǽ�
	@Column(name = "STAR")
	private Integer star;
	
	//��Ӱ���
	@Column(name = "INFO")
	private String info;
	
	//�ҵ�����
	@Column(name = "MYTALK")
	private String mytalk;
	
	//���ص�ַ·��
	@Column(name = "DOWNLINK")
	private String downlink;
	
	//���ص�ַ˵������
	@Column(name = "DOWNINFO")
	private String downinfo;
	
	//��Ӱ���ͼƬ
	@OneToMany
	@JoinColumn(name="movie_id")
	@OrderBy(value="ordernum asc")
	private List<MovieImgs> movieimgs;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getImgpath()
	{
		return imgpath;
	}

	public void setImgpath(String imgpath)
	{
		this.imgpath = imgpath;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Integer getStar()
	{
		return star;
	}

	public void setStar(Integer star)
	{
		this.star = star;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public String getMytalk()
	{
		return mytalk;
	}

	public void setMytalk(String mytalk)
	{
		this.mytalk = mytalk;
	}

	public String getDownlink()
	{
		return downlink;
	}

	public void setDownlink(String downlink)
	{
		this.downlink = downlink;
	}

	public String getDowninfo()
	{
		return downinfo;
	}

	public void setDowninfo(String downinfo)
	{
		this.downinfo = downinfo;
	}

	public List<MovieImgs> getMovieimgs()
	{
		return movieimgs;
	}

	public void setMovieimgs(List<MovieImgs> movieimgs)
	{
		this.movieimgs = movieimgs;
	}
	
	
	
}
