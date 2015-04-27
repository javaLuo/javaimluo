package cn.lx.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * ��ϷͼƬ��
 * */
@Entity(name = "game_imgs")
public class GameImg
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	//�����ĵ�Ӱ��ID
	@Column(name = "GAME_ID")
	private Integer game_id;
	
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
