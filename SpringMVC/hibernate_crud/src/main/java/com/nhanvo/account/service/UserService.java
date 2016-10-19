package com.nhanvo.account.service;

import com.nhanvo.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
