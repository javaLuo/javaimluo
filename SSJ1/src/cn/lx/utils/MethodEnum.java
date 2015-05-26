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
	//获取全部游戏列表
	getGameList,
	//获取详细游戏信息
	gameOpen,
	//获取全部文章列表
	getArticleList,
	//获取文章详细信息
	getOneArticle,
	//获取全部我的工作列表
	getAllWorks,
	//获取我的工作详细信息
	getOneMyWork,

	test;

	public static MethodEnum getMethod(String methodCode) {
		return valueOf(methodCode);
	}
}
