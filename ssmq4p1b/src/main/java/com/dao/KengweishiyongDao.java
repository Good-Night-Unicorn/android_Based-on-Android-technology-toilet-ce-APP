package com.dao;

import com.entity.KengweishiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KengweishiyongVO;
import com.entity.view.KengweishiyongView;


/**
 * 坑位使用
 * 
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public interface KengweishiyongDao extends BaseMapper<KengweishiyongEntity> {
	
	List<KengweishiyongVO> selectListVO(@Param("ew") Wrapper<KengweishiyongEntity> wrapper);
	
	KengweishiyongVO selectVO(@Param("ew") Wrapper<KengweishiyongEntity> wrapper);
	
	List<KengweishiyongView> selectListView(@Param("ew") Wrapper<KengweishiyongEntity> wrapper);

	List<KengweishiyongView> selectListView(Pagination page,@Param("ew") Wrapper<KengweishiyongEntity> wrapper);
	
	KengweishiyongView selectView(@Param("ew") Wrapper<KengweishiyongEntity> wrapper);
	

}
