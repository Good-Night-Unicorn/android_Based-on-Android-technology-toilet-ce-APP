package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KengweiqingjieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KengweiqingjieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KengweiqingjieView;


/**
 * 坑位清洁
 *
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface KengweiqingjieService extends IService<KengweiqingjieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KengweiqingjieVO> selectListVO(Wrapper<KengweiqingjieEntity> wrapper);
   	
   	KengweiqingjieVO selectVO(@Param("ew") Wrapper<KengweiqingjieEntity> wrapper);
   	
   	List<KengweiqingjieView> selectListView(Wrapper<KengweiqingjieEntity> wrapper);
   	
   	KengweiqingjieView selectView(@Param("ew") Wrapper<KengweiqingjieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KengweiqingjieEntity> wrapper);
   	

}

