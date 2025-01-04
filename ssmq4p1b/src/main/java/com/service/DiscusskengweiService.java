package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusskengweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusskengweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusskengweiView;


/**
 * 坑位评论表
 *
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface DiscusskengweiService extends IService<DiscusskengweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusskengweiVO> selectListVO(Wrapper<DiscusskengweiEntity> wrapper);
   	
   	DiscusskengweiVO selectVO(@Param("ew") Wrapper<DiscusskengweiEntity> wrapper);
   	
   	List<DiscusskengweiView> selectListView(Wrapper<DiscusskengweiEntity> wrapper);
   	
   	DiscusskengweiView selectView(@Param("ew") Wrapper<DiscusskengweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusskengweiEntity> wrapper);
   	

}

