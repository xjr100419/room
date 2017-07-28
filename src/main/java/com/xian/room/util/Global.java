package com.xian.room.util;

public interface Global {
	public interface Auth{
		public String UserCookieName = "auth";
		public int UserCookiemaxAge = 30 * 60;// 设置为30min
	}
}
