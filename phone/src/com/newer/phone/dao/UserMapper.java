package com.newer.phone.dao;

import org.springframework.stereotype.Repository;
/**
 * �û�dao��
 * @author Kiven
 *
 */

import com.newer.phone.pojo.User;
@Repository
public interface UserMapper {

	User get();
}
