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
 * �ҵĹ�����
 * */
@Entity(name = "mywork")
public class MyWork
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	//��������
	@Column(name = "TITLE")
	private String title;
	//����С����
	@Column(name = "TITLEINFO")
	private String titleinfo;
	//����ͼƬ·��
	@Column(name = "IMGPATH")
	private String imgpath;
	//��������
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
