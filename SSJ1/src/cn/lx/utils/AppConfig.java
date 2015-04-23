package cn.lx.utils;

/**
 *  app 常用配置信息
 * @author Jack.Zhou
 *
 */
public class AppConfig {

	/**
	 *  手机客户端名称
	 */
	public static final String APP_NAME = "newsapp";
	
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
	 *  注册时用户已经存在
	 */
	public static final int USER_EXIST = 10;
	
	/**
	 * 短信效验码发送失败
	 */
	public static final int SMS_FAILD = 11;
	
	/**
	 * 短信效验码过期
	 */
	public static final int SMS_TIMEOUT = 12;
	
	/**
	 * 用户不存在
	 */
	public static final int USER_NOTEXIST = 13;
	
	/**
	 * 该用户今日已签过到
	 * */
	public static final int USER_QDED = 14;
	/**
	 *  参数传入分隔符
	 */
	public static final String PAT = "@@";
	
	
	/**
	 *  省编码
	 */
	public static final String ROOT_AREA = "510000";
	
	/**
	 *  启动记录状态
	 */
	public static final int START_FLAG = 1;
	
	/**
	 *  登录记录状态
	 */
	public static final int LOGIN_FLAG = 2;
	
}
