package com.dao;

import com.entity.QingjieshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QingjieshenqingVO;
import com.entity.view.QingjieshenqingView;


/**
 * 清洁申请
 * 
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface QingjieshenqingDao extends BaseMapper<QingjieshenqingEntity> {
	
	List<QingjieshenqingVO> selectListVO(@Param("ew") Wrapper<QingjieshenqingEntity> wrapper);
	
	QingjieshenqingVO selectVO(@Param("ew") Wrapper<QingjieshenqingEntity> wrapper);
	
	List<QingjieshenqingView> selectListView(@Param("ew") Wrapper<QingjieshenqingEntity> wrapper);

	List<QingjieshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<QingjieshenqingEntity> wrapper);
	
	QingjieshenqingView selectView(@Param("ew") Wrapper<QingjieshenqingEntity> wrapper);
	

}
