package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * 照片dao层
 * @author Kiven
 *
 */

import com.newer.phone.pojo.Image;
@Repository
public interface ImageMapper {
	
	//根据商品id查询商品的图片
	List<Image> getImage(@Param("p_id") Integer p_id);
}
