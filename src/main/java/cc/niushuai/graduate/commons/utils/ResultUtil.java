package cc.niushuai.graduate.commons.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据工具类
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年10月27日 下午9:59:27
 */
public class ResultUtil extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public ResultUtil() {
		put("code", 0);
	}
	
	public static ResultUtil error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static ResultUtil error(String msg) {
		return error(500, msg);
	}
	
	public static ResultUtil error(int code, String msg) {
		ResultUtil result = new ResultUtil();
		result.put("code", code);
		result.put("msg", msg);
		return result;
	}

	public static ResultUtil ok(String msg) {
		ResultUtil result = new ResultUtil();
		result.put("msg", msg);
		return result;
	}
	
	public static ResultUtil ok(Map<String, Object> map) {
		ResultUtil result = new ResultUtil();
		result.putAll(map);
		return result;
	}
	
	public static ResultUtil ok() {
		return new ResultUtil();
	}

	public static ResultUtil correct() {
		return new ResultUtil().put("flag", true);
	}

	public static ResultUtil wrong() {
		return new ResultUtil().put("flag", false);
	}

	@Override
	public ResultUtil put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
