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


import com.dao.DiscussgongcexinxiDao;
import com.entity.DiscussgongcexinxiEntity;
import com.service.DiscussgongcexinxiService;
import com.entity.vo.DiscussgongcexinxiVO;
import com.entity.view.DiscussgongcexinxiView;

@Service("discussgongcexinxiService")
public class DiscussgongcexinxiServiceImpl extends ServiceImpl<DiscussgongcexinxiDao, DiscussgongcexinxiEntity> implements DiscussgongcexinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgongcexinxiEntity> page = this.selectPage(
                new Query<DiscussgongcexinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussgongcexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgongcexinxiEntity> wrapper) {
		  Page<DiscussgongcexinxiView> page =new Query<DiscussgongcexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussgongcexinxiVO> selectListVO(Wrapper<DiscussgongcexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgongcexinxiVO selectVO(Wrapper<DiscussgongcexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgongcexinxiView> selectListView(Wrapper<DiscussgongcexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgongcexinxiView selectView(Wrapper<DiscussgongcexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
