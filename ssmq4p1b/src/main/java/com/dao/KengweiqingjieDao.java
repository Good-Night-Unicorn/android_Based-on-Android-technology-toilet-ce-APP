package com.dao;

import com.entity.KengweiqingjieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KengweiqingjieVO;
import com.entity.view.KengweiqingjieView;


/**
 * 坑位清洁
 * 
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface KengweiqingjieDao extends BaseMapper<KengweiqingjieEntity> {
	
	List<KengweiqingjieVO> selectListVO(@Param("ew") Wrapper<KengweiqingjieEntity> wrapper);
	
	KengweiqingjieVO selectVO(@Param("ew") Wrapper<KengweiqingjieEntity> wrapper);
	
	List<KengweiqingjieView> selectListView(@Param("ew") Wrapper<KengweiqingjieEntity> wrapper);

	List<KengweiqingjieView> selectListView(Pagination page,@Param("ew") Wrapper<KengweiqingjieEntity> wrapper);
	
	KengweiqingjieView selectView(@Param("ew") Wrapper<KengweiqingjieEntity> wrapper);
	

}
