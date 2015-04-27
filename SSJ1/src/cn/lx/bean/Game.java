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
	
	//��Ϸ����
	@Column(name = "NAME")
	private String name;
	
	//��Ϸ����
	@Column(name = "TYPE")
	private String type;
	
	//��Ϸ����ͼƬ·��
	@Column(name = "IMGPATH")
	private String imgpath;
	
	//��Ϸ�Ǽ�
	@Column(name = "STAR")
	private Integer star;
	
	//��Ϸ���
	@Column(name = "INFO")
	private String info;
	
	//�ҵ�����
	@Column(name = "MYTALK")
	private String mytalk;
	
	//���ص�ַ
	@Column(name = "DOWNLINK")
	private String downlink;
	
	//���ص�ַ˵��
	@Column(name = "DOWNINFO")
	private String downinfo;
	
	//��Ϸ��С
	@Column(name = "HOWBIG")
	private String howbig;
	
	//��Ϸ����
	@Column(name = "DEPLOY")
	private String deploy;

	//��Ϸ��ͼ
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
