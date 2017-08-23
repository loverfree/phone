package com.newer.phone.dao;

import org.apache.ibatis.annotations.Param;

import com.newer.phone.pojo.Brand;

public interface BrandMapper {

	/**
	 * �����Ʒ�����
	 * @param brand  ��Ʒ���ʵ�����
	 * @return
	 * @author samluby
	 */
	int addBrand(Brand brand);
	
	/**
	 * ��Ʒ����ɾ�����������ݿ����ɾ�� ��ֻ�ǽ�״̬����Ϊ0(�¼�)
	 * @param b_id
	 * @return
	 * @author samluby
	 */
	int removeBrand(@Param("b_id")Integer b_id);

}
