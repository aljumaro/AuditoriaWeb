package com.aljumaro.auditoria.service.user;

import com.aljumaro.auditoria.domain.user.User;
import com.aljumaro.auditoria.exception.InvalidMethodParameter;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Date 24/06/2016
 * @Time 18:25
 * @Author Juanma
 */
@Component
public class UserServiceImpl implements UserService {
    @Override
    public User findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidMethodParameter("User name is mandatory");
        }

        return new User("test");
    }
}
