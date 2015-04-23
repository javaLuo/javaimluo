package cn.lx.utils;


/**
 *  请求方法定义
 * @author Jack
 *
 */
public enum MethodEnum {
	//发表留言
	putMessage,
	
	test;

	public static MethodEnum getMethod(String methodCode) {
		return valueOf(methodCode);
	}
}
