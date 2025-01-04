package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongcexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongcexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongcexinxiView;


/**
 * 公厕信息
 *
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface GongcexinxiService extends IService<GongcexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongcexinxiVO> selectListVO(Wrapper<GongcexinxiEntity> wrapper);
   	
   	GongcexinxiVO selectVO(@Param("ew") Wrapper<GongcexinxiEntity> wrapper);
   	
   	List<GongcexinxiView> selectListView(Wrapper<GongcexinxiEntity> wrapper);
   	
   	GongcexinxiView selectView(@Param("ew") Wrapper<GongcexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongcexinxiEntity> wrapper);
   	

}

