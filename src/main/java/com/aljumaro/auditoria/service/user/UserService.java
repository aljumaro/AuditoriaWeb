package com.aljumaro.auditoria.service.user;

import com.aljumaro.auditoria.domain.user.User;

/**
 * @Date 24/06/2016
 * @Time 17:35
 * @Author Juanma
 */
public interface UserService {

    User findByName(String name);
}
