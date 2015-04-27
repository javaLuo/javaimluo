package cn.lx.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 游戏图片表
 * */
@Entity(name = "game_imgs")
public class GameImg
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	//关联的电影表ID
	@Column(name = "GAME_ID")
	private Integer game_id;
	
	//图片路径
	@Column(name = "IMGPATH")
	private String imgpath;
	
	//排序编号
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

	public Integer getGame_id()
	{
		return game_id;
	}

	public void setGame_id(Integer gameId)
	{
		game_id = gameId;
	}

	

}
