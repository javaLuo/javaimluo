package cn.lx.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 我的工作内容类
 * */
@Entity(name = "myworkbody")
public class MyWorkBody
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	//文字说明
	@Column(name = "INFO")
	private String info;
	//图片路径
	@Column(name = "IMGPATH")
	private String imgpath;
	//关联的我的工作ID
	@Column(name = "MYWORK_ID")
	private Integer mywork_id;
	//排序编号
	@Column(name = "ORDERNUM")
	private Integer ordernum;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Integer getMywork_id() {
		return mywork_id;
	}
	public void setMywork_id(Integer myworkId) {
		mywork_id = myworkId;
	}
	public Integer getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	
	
}
