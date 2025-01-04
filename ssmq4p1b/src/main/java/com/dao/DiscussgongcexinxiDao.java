package com.dao;

import com.entity.DiscussgongcexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgongcexinxiVO;
import com.entity.view.DiscussgongcexinxiView;


/**
 * 公厕信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface DiscussgongcexinxiDao extends BaseMapper<DiscussgongcexinxiEntity> {
	
	List<DiscussgongcexinxiVO> selectListVO(@Param("ew") Wrapper<DiscussgongcexinxiEntity> wrapper);
	
	DiscussgongcexinxiVO selectVO(@Param("ew") Wrapper<DiscussgongcexinxiEntity> wrapper);
	
	List<DiscussgongcexinxiView> selectListView(@Param("ew") Wrapper<DiscussgongcexinxiEntity> wrapper);

	List<DiscussgongcexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgongcexinxiEntity> wrapper);
	
	DiscussgongcexinxiView selectView(@Param("ew") Wrapper<DiscussgongcexinxiEntity> wrapper);
	

}
