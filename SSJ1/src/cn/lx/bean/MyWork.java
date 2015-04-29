package cn.lx.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
/**
 * 我的工作类
 * */
@Entity(name = "mywork")
public class MyWork
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	//工作标题
	@Column(name = "TITLE")
	private String title;
	//工作小标题
	@Column(name = "TITLEINFO")
	private String titleinfo;
	//封面图片路径
	@Column(name = "IMGPATH")
	private String imgpath;
	//工作内容
	@OneToMany
	@JoinColumn(name="mywork_id")
	@OrderBy(value="ordernum asc")
	private List<MyWorkBody> myworkbody;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleinfo() {
		return titleinfo;
	}
	public void setTitleinfo(String titleinfo) {
		this.titleinfo = titleinfo;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public List<MyWorkBody> getMyworkbody() {
		return myworkbody;
	}
	public void setMyworkbody(List<MyWorkBody> myworkbody) {
		this.myworkbody = myworkbody;
	}
}
