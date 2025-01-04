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


import com.dao.KengweiDao;
import com.entity.KengweiEntity;
import com.service.KengweiService;
import com.entity.vo.KengweiVO;
import com.entity.view.KengweiView;

@Service("kengweiService")
public class KengweiServiceImpl extends ServiceImpl<KengweiDao, KengweiEntity> implements KengweiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KengweiEntity> page = this.selectPage(
                new Query<KengweiEntity>(params).getPage(),
                new EntityWrapper<KengweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KengweiEntity> wrapper) {
		  Page<KengweiView> page =new Query<KengweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KengweiVO> selectListVO(Wrapper<KengweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KengweiVO selectVO(Wrapper<KengweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KengweiView> selectListView(Wrapper<KengweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KengweiView selectView(Wrapper<KengweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
