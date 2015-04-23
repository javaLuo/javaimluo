package cn.lx.utils;

import java.util.List;

/**
 * 返回数据列表
 * 
 * @author Jack.Zhou
 * @param <T>
 * 
 */
public class ReturnMsg<T> {
	/**
	 * 返回的状态
	 */
	private int code;

	/**
	 *  具体的内容信息
	 */
	private List<T> list;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
