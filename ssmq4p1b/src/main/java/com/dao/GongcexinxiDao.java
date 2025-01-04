package com.dao;

import com.entity.GongcexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongcexinxiVO;
import com.entity.view.GongcexinxiView;


/**
 * 公厕信息
 * 
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface GongcexinxiDao extends BaseMapper<GongcexinxiEntity> {
	
	List<GongcexinxiVO> selectListVO(@Param("ew") Wrapper<GongcexinxiEntity> wrapper);
	
	GongcexinxiVO selectVO(@Param("ew") Wrapper<GongcexinxiEntity> wrapper);
	
	List<GongcexinxiView> selectListView(@Param("ew") Wrapper<GongcexinxiEntity> wrapper);

	List<GongcexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GongcexinxiEntity> wrapper);
	
	GongcexinxiView selectView(@Param("ew") Wrapper<GongcexinxiEntity> wrapper);
	

}
