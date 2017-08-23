package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Review;
/**
 * 回复dao层
 * @author Kiven
 *
 */
@Repository
public interface ReviewMapper {
	//根据商品Id查询评论
	List<Review> getReview(@Param("p_id") Integer p_id);
}
