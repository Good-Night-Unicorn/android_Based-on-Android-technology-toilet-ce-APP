package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QingjieshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QingjieshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QingjieshenqingView;


/**
 * 清洁申请
 *
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface QingjieshenqingService extends IService<QingjieshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QingjieshenqingVO> selectListVO(Wrapper<QingjieshenqingEntity> wrapper);
   	
   	QingjieshenqingVO selectVO(@Param("ew") Wrapper<QingjieshenqingEntity> wrapper);
   	
   	List<QingjieshenqingView> selectListView(Wrapper<QingjieshenqingEntity> wrapper);
   	
   	QingjieshenqingView selectView(@Param("ew") Wrapper<QingjieshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QingjieshenqingEntity> wrapper);
   	

}

