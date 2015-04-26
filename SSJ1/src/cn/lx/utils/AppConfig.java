package cn.lx.utils;

/**
 *  app 常用配置信息
 * @author Jack.Zhou
 *
 */
public class AppConfig {
	
	/**
	 *  请求正常的状态码
	 */
	public static final int OK_STATUS = 7;
	
	/**
	 *  请求失败的状态码
	 */
	public static final int FAILD_STATUS = 8;
	
	/**
	 *  非法请求状态码
	 */
	public static final int ERROR_STATUS = 9;
	
	
	/**
	 *  参数传入分隔符
	 */
	public static final String PAT = "@@";
	
	/**
	 * 留言列表每次加载几条
	 * */
	public static final int MESSAGE_PAGE = 5;
	
	/**
	 * 基础访问路径
	 * */
	public static final String BASEPATH = "http://localhost:8080/SSJ1";
	
}
