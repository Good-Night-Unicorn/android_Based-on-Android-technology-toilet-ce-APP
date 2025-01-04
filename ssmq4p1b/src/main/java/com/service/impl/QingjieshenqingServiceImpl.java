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


import com.dao.QingjieshenqingDao;
import com.entity.QingjieshenqingEntity;
import com.service.QingjieshenqingService;
import com.entity.vo.QingjieshenqingVO;
import com.entity.view.QingjieshenqingView;

@Service("qingjieshenqingService")
public class QingjieshenqingServiceImpl extends ServiceImpl<QingjieshenqingDao, QingjieshenqingEntity> implements QingjieshenqingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QingjieshenqingEntity> page = this.selectPage(
                new Query<QingjieshenqingEntity>(params).getPage(),
                new EntityWrapper<QingjieshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QingjieshenqingEntity> wrapper) {
		  Page<QingjieshenqingView> page =new Query<QingjieshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QingjieshenqingVO> selectListVO(Wrapper<QingjieshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QingjieshenqingVO selectVO(Wrapper<QingjieshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QingjieshenqingView> selectListView(Wrapper<QingjieshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QingjieshenqingView selectView(Wrapper<QingjieshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
