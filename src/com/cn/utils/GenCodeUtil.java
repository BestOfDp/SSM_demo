package com.cn.utils;

import java.util.UUID;

public class GenCodeUtil {

	public static String GenCode() {
		return UUID.randomUUID().toString();
	}
}
