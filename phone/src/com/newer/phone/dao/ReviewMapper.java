package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Review;
/**
 * �ظ�dao��
 * @author Kiven
 *
 */
@Repository
public interface ReviewMapper {
	//������ƷId��ѯ����
	List<Review> getReview(@Param("p_id") Integer p_id);
}
