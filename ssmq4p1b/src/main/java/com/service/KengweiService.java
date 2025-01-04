package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KengweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KengweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KengweiView;


/**
 * 坑位
 *
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface KengweiService extends IService<KengweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KengweiVO> selectListVO(Wrapper<KengweiEntity> wrapper);
   	
   	KengweiVO selectVO(@Param("ew") Wrapper<KengweiEntity> wrapper);
   	
   	List<KengweiView> selectListView(Wrapper<KengweiEntity> wrapper);
   	
   	KengweiView selectView(@Param("ew") Wrapper<KengweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KengweiEntity> wrapper);
   	

}

