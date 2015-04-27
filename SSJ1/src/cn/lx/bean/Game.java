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

@Entity(name = "game")
public class Game
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	//游戏名字
	@Column(name = "NAME")
	private String name;
	
	//游戏类型
	@Column(name = "TYPE")
	private String type;
	
	//游戏封面图片路径
	@Column(name = "IMGPATH")
	private String imgpath;
	
	//游戏星级
	@Column(name = "STAR")
	private Integer star;
	
	//游戏简介
	@Column(name = "INFO")
	private String info;
	
	//我的评语
	@Column(name = "MYTALK")
	private String mytalk;
	
	//下载地址
	@Column(name = "DOWNLINK")
	private String downlink;
	
	//下载地址说明
	@Column(name = "DOWNINFO")
	private String downinfo;
	
	//游戏大小
	@Column(name = "HOWBIG")
	private String howbig;
	
	//游戏配置
	@Column(name = "DEPLOY")
	private String deploy;

	//游戏截图
	@OneToMany
	@JoinColumn(name="game_id")
	@OrderBy(value="ordernum asc")
	private List<GameImg> gameimg;
	
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getImgpath()
	{
		return imgpath;
	}

	public void setImgpath(String imgpath)
	{
		this.imgpath = imgpath;
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

	public String getHowbig()
	{
		return howbig;
	}

	public void setHowbig(String howbig)
	{
		this.howbig = howbig;
	}

	public String getDeploy()
	{
		return deploy;
	}

	public void setDeploy(String deploy)
	{
		this.deploy = deploy;
	}

	public List<GameImg> getGameimg()
	{
		return gameimg;
	}

	public void setGameimg(List<GameImg> gameimg)
	{
		this.gameimg = gameimg;
	}
	
	
}
