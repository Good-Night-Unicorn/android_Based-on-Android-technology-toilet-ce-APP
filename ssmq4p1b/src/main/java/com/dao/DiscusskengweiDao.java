package com.dao;

import com.entity.DiscusskengweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusskengweiVO;
import com.entity.view.DiscusskengweiView;


/**
 * 坑位评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface DiscusskengweiDao extends BaseMapper<DiscusskengweiEntity> {
	
	List<DiscusskengweiVO> selectListVO(@Param("ew") Wrapper<DiscusskengweiEntity> wrapper);
	
	DiscusskengweiVO selectVO(@Param("ew") Wrapper<DiscusskengweiEntity> wrapper);
	
	List<DiscusskengweiView> selectListView(@Param("ew") Wrapper<DiscusskengweiEntity> wrapper);

	List<DiscusskengweiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusskengweiEntity> wrapper);
	
	DiscusskengweiView selectView(@Param("ew") Wrapper<DiscusskengweiEntity> wrapper);
	

}
