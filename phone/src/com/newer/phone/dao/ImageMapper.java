package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * ��Ƭdao��
 * @author Kiven
 *
 */

import com.newer.phone.pojo.Image;
@Repository
public interface ImageMapper {
	
	//������Ʒid��ѯ��Ʒ��ͼƬ
	List<Image> getImage(@Param("p_id") Integer p_id);
}
