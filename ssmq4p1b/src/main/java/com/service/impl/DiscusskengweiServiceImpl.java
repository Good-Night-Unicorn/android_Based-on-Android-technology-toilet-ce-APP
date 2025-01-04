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


import com.dao.DiscusskengweiDao;
import com.entity.DiscusskengweiEntity;
import com.service.DiscusskengweiService;
import com.entity.vo.DiscusskengweiVO;
import com.entity.view.DiscusskengweiView;

@Service("discusskengweiService")
public class DiscusskengweiServiceImpl extends ServiceImpl<DiscusskengweiDao, DiscusskengweiEntity> implements DiscusskengweiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusskengweiEntity> page = this.selectPage(
                new Query<DiscusskengweiEntity>(params).getPage(),
                new EntityWrapper<DiscusskengweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusskengweiEntity> wrapper) {
		  Page<DiscusskengweiView> page =new Query<DiscusskengweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusskengweiVO> selectListVO(Wrapper<DiscusskengweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusskengweiVO selectVO(Wrapper<DiscusskengweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusskengweiView> selectListView(Wrapper<DiscusskengweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusskengweiView selectView(Wrapper<DiscusskengweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
