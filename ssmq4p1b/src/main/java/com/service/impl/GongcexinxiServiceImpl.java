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


import com.dao.GongcexinxiDao;
import com.entity.GongcexinxiEntity;
import com.service.GongcexinxiService;
import com.entity.vo.GongcexinxiVO;
import com.entity.view.GongcexinxiView;

@Service("gongcexinxiService")
public class GongcexinxiServiceImpl extends ServiceImpl<GongcexinxiDao, GongcexinxiEntity> implements GongcexinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongcexinxiEntity> page = this.selectPage(
                new Query<GongcexinxiEntity>(params).getPage(),
                new EntityWrapper<GongcexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongcexinxiEntity> wrapper) {
		  Page<GongcexinxiView> page =new Query<GongcexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongcexinxiVO> selectListVO(Wrapper<GongcexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongcexinxiVO selectVO(Wrapper<GongcexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongcexinxiView> selectListView(Wrapper<GongcexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongcexinxiView selectView(Wrapper<GongcexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
