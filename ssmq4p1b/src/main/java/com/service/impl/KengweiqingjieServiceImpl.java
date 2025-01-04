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


import com.dao.KengweiqingjieDao;
import com.entity.KengweiqingjieEntity;
import com.service.KengweiqingjieService;
import com.entity.vo.KengweiqingjieVO;
import com.entity.view.KengweiqingjieView;

@Service("kengweiqingjieService")
public class KengweiqingjieServiceImpl extends ServiceImpl<KengweiqingjieDao, KengweiqingjieEntity> implements KengweiqingjieService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KengweiqingjieEntity> page = this.selectPage(
                new Query<KengweiqingjieEntity>(params).getPage(),
                new EntityWrapper<KengweiqingjieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KengweiqingjieEntity> wrapper) {
		  Page<KengweiqingjieView> page =new Query<KengweiqingjieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KengweiqingjieVO> selectListVO(Wrapper<KengweiqingjieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KengweiqingjieVO selectVO(Wrapper<KengweiqingjieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KengweiqingjieView> selectListView(Wrapper<KengweiqingjieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KengweiqingjieView selectView(Wrapper<KengweiqingjieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
