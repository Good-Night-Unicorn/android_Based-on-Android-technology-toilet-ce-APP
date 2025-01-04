package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KengweishiyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KengweishiyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KengweishiyongView;


/**
 * 坑位使用
 *
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface KengweishiyongService extends IService<KengweishiyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KengweishiyongVO> selectListVO(Wrapper<KengweishiyongEntity> wrapper);
   	
   	KengweishiyongVO selectVO(@Param("ew") Wrapper<KengweishiyongEntity> wrapper);
   	
   	List<KengweishiyongView> selectListView(Wrapper<KengweishiyongEntity> wrapper);
   	
   	KengweishiyongView selectView(@Param("ew") Wrapper<KengweishiyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KengweishiyongEntity> wrapper);
   	

}

