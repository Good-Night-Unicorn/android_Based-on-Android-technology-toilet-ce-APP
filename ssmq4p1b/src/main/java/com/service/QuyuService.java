package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuyuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuyuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuyuView;


/**
 * 区域
 *
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface QuyuService extends IService<QuyuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuyuVO> selectListVO(Wrapper<QuyuEntity> wrapper);
   	
   	QuyuVO selectVO(@Param("ew") Wrapper<QuyuEntity> wrapper);
   	
   	List<QuyuView> selectListView(Wrapper<QuyuEntity> wrapper);
   	
   	QuyuView selectView(@Param("ew") Wrapper<QuyuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuyuEntity> wrapper);
   	

}

