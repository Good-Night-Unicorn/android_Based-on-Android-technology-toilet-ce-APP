package com.dao;

import com.entity.KengweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KengweiVO;
import com.entity.view.KengweiView;


/**
 * 坑位
 * 
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface KengweiDao extends BaseMapper<KengweiEntity> {
	
	List<KengweiVO> selectListVO(@Param("ew") Wrapper<KengweiEntity> wrapper);
	
	KengweiVO selectVO(@Param("ew") Wrapper<KengweiEntity> wrapper);
	
	List<KengweiView> selectListView(@Param("ew") Wrapper<KengweiEntity> wrapper);

	List<KengweiView> selectListView(Pagination page,@Param("ew") Wrapper<KengweiEntity> wrapper);
	
	KengweiView selectView(@Param("ew") Wrapper<KengweiEntity> wrapper);
	

}
