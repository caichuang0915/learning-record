package com.tupelo.spring.service;

import com.tupelo.spring.doimport.ImportUser;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * @Author: caichuang
 * @Date: 2023/3/7 18:21
 */
@Service
@Import(ImportUser.class)
public class UserService {
}
