package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KengweishiyongDao;
import com.entity.KengweishiyongEntity;
import com.service.KengweishiyongService;
import com.entity.vo.KengweishiyongVO;
import com.entity.view.KengweishiyongView;

@Service("kengweishiyongService")
public class KengweishiyongServiceImpl extends ServiceImpl<KengweishiyongDao, KengweishiyongEntity> implements KengweishiyongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KengweishiyongEntity> page = this.selectPage(
                new Query<KengweishiyongEntity>(params).getPage(),
                new EntityWrapper<KengweishiyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KengweishiyongEntity> wrapper) {
		  Page<KengweishiyongView> page =new Query<KengweishiyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KengweishiyongVO> selectListVO(Wrapper<KengweishiyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KengweishiyongVO selectVO(Wrapper<KengweishiyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KengweishiyongView> selectListView(Wrapper<KengweishiyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KengweishiyongView selectView(Wrapper<KengweishiyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
