package cn.lx.utils;


/**
 *  请求方法定义
 * @author Jack
 *
 */
public enum MethodEnum {
	//发表留言
	putMessage,
	//获取留言列表
	getMessage,
	//获取电影列表
	getMovieList,
	//获取电影详细信息
	getMovieInfo,
	
	test;

	public static MethodEnum getMethod(String methodCode) {
		return valueOf(methodCode);
	}
}
