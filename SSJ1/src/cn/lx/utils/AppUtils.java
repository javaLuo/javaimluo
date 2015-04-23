package cn.lx.utils;

import java.net.URLDecoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *  定义工具
 * @author Jack
 *
 */
public class AppUtils {
	
	private static Log logger = LogFactory.getLog(AppUtils.class);

	private static ReturnMsg<String> msg = new ReturnMsg<String>();
	
	/**
	 *  请求发生错误，返回错误状态
	 * @return
	 */
	public static ReturnMsg<String> getFieldJson(){
		msg.setCode(AppConfig.FAILD_STATUS);
		msg.setList(null);
		return msg;
	}
	
	/**
	 *  非法的请求返回信息
	 * @return
	 */
	public static ReturnMsg<String> getErrorJson(){
		msg.setCode(AppConfig.ERROR_STATUS);
		msg.setList(null);
		return msg;
	}
	
	/**
	 *  非法的请求返回信息
	 * @return
	 */
	public static ReturnMsg<String> getOKJson(){
		msg.setCode(AppConfig.OK_STATUS);
		msg.setList(null);
		return msg;
	}
	
	/**
	 *   上传文件之后返回的json数据
	 * @param fileName  文件名
	 * @param type   类型：application/octet-stream
	 * @param tmpName  文件存放的路径
	 * @param error   错误    0为正确
	 * @param size   文件大小
	 * @return
	 */
	public static String getUploadMsg(String fileName,String type,String tmpName,String error,String size){
		StringBuffer sb = new StringBuffer();
		sb.append(tmpName);
		return sb.toString();
	}
	
	
	/**
	 *   上传文件错误返回的json数据
	 * @param fileName  文件名
	 * @param type   类型：application/octet-stream
	 * @param tmpName  文件存放的路径
	 * @param error   错误    0为正确
	 * @param size   文件大小
	 * @return
	 */
	public static String getUploadErrorMsg(){
		StringBuffer sb = new StringBuffer();
		sb.append("error.jpg");
		return sb.toString();
	}
	
	/**
	 *  根据当前页码和每一页的大小计算出开始位置
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public static int getStartNum(int pageSize,int pageNo){
		return (pageNo-1)*pageSize;
	}
	
	/**
	 *  获取当前页的最大值
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public static int getMaxNum(int pageSize,int pageNo){
		return getStartNum(pageSize, pageNo) + pageSize;
	}
	
	
	/**
	 *  将客户端查询的数据进行解码操作
	 * @param target
	 * @return
	 */
	public static String convertStr(String target){
		try {
			target = URLDecoder.decode(target, "UTF-8");
		} catch (Exception e1) {
			logger.warn("数据转好失败:" + target,e1);
		}
		return target;
	}
}
