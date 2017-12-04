package com.itqiwen.crm.utils;

import java.util.UUID;

/**
 * 文件上传的工具类
 */
public class UploadUtils {
	
	/**
	 * 传入文件的名称，返回的唯一的名称
	 * @param filename
	 * @return
	 */
	public static String getUniqueName(String filename) {
		int index = filename.lastIndexOf(".");
		String lastname = filename.substring(index, filename.length());
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + lastname;
	}
}
