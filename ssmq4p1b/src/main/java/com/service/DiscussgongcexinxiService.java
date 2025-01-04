package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgongcexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgongcexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgongcexinxiView;


/**
 * 公厕信息评论表
 *
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface DiscussgongcexinxiService extends IService<DiscussgongcexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgongcexinxiVO> selectListVO(Wrapper<DiscussgongcexinxiEntity> wrapper);
   	
   	DiscussgongcexinxiVO selectVO(@Param("ew") Wrapper<DiscussgongcexinxiEntity> wrapper);
   	
   	List<DiscussgongcexinxiView> selectListView(Wrapper<DiscussgongcexinxiEntity> wrapper);
   	
   	DiscussgongcexinxiView selectView(@Param("ew") Wrapper<DiscussgongcexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgongcexinxiEntity> wrapper);
   	

}

