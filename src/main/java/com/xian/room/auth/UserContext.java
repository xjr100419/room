package com.xian.room.auth;

import com.xian.room.domain.User;

public class UserContext implements AutoCloseable {
	//public static final ThreadLocal<User> current = new ThreadLocal<User>();

	static final ThreadLocal<User> current = new ThreadLocal<User>();

    public UserContext(User user) {
        current.set(user);
    }

    public static User getCurrentUser() {
        return current.get();
    }

    public void close() {
        current.remove();
    }
    
    
    /*try (UserContext context = new UserContext(user)) {
        // 当前用户是user：
        processProfile(UserContext.getCurrentUser());
        // 需要更高权限的admin才能执行的操作怎么办？
        // 方法是获取一个admin用户：
        try (UserContext context = new UserContext(getAdmin())) {
            // 现在的当前用户是admin：
            processAdminJob(UserContext.getCurrentUser());
        }
        // 现在当前用户又自动变回了普通user：
        processProfile(UserContext.getCurrentUser());
    }*/
}
