package cn.lx.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * ������
 * */
@Entity(name = "article")
public class Article
{
	//ID
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	//��������
	@Column(name = "TITLE")
	private String title;
	//��������
	@Column(name = "AUTHOR")
	private String author;
	//������Ƭ
	@Column(name = "PHOTO")
	private String photo;
	//���߼��
	@Column(name = "INTR")
	private String intr;
	//���·���ͼƬ·��
	@Column(name = "IMGPATH")
	private String imgpath;
	//��������
	@Column(name = "ARTICLEBODY")
	private String articlebody;
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIntr() {
		return intr;
	}
	public void setIntr(String intr) {
		this.intr = intr;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getArticlebody() {
		return articlebody;
	}
	public void setArticlebody(String articlebody) {
		this.articlebody = articlebody;
	}
	
	
	
}
