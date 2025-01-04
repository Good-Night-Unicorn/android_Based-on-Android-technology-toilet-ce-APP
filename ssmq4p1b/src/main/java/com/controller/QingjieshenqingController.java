package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QingjieshenqingEntity;
import com.entity.view.QingjieshenqingView;

import com.service.QingjieshenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 清洁申请
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
@RestController
@RequestMapping("/qingjieshenqing")
public class QingjieshenqingController {
    @Autowired
    private QingjieshenqingService qingjieshenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QingjieshenqingEntity qingjieshenqing, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			qingjieshenqing.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			qingjieshenqing.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QingjieshenqingEntity> ew = new EntityWrapper<QingjieshenqingEntity>();
		PageUtils page = qingjieshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingjieshenqing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QingjieshenqingEntity qingjieshenqing, 
		HttpServletRequest request){
        EntityWrapper<QingjieshenqingEntity> ew = new EntityWrapper<QingjieshenqingEntity>();
		PageUtils page = qingjieshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingjieshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QingjieshenqingEntity qingjieshenqing){
       	EntityWrapper<QingjieshenqingEntity> ew = new EntityWrapper<QingjieshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qingjieshenqing, "qingjieshenqing")); 
        return R.ok().put("data", qingjieshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QingjieshenqingEntity qingjieshenqing){
        EntityWrapper< QingjieshenqingEntity> ew = new EntityWrapper< QingjieshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qingjieshenqing, "qingjieshenqing")); 
		QingjieshenqingView qingjieshenqingView =  qingjieshenqingService.selectView(ew);
		return R.ok("查询清洁申请成功").put("data", qingjieshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QingjieshenqingEntity qingjieshenqing = qingjieshenqingService.selectById(id);
        return R.ok().put("data", qingjieshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QingjieshenqingEntity qingjieshenqing = qingjieshenqingService.selectById(id);
        return R.ok().put("data", qingjieshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QingjieshenqingEntity qingjieshenqing, HttpServletRequest request){
    	qingjieshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qingjieshenqing);

        qingjieshenqingService.insert(qingjieshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QingjieshenqingEntity qingjieshenqing, HttpServletRequest request){
    	qingjieshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qingjieshenqing);

        qingjieshenqingService.insert(qingjieshenqing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QingjieshenqingEntity qingjieshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qingjieshenqing);
        qingjieshenqingService.updateById(qingjieshenqing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qingjieshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<QingjieshenqingEntity> wrapper = new EntityWrapper<QingjieshenqingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			wrapper.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = qingjieshenqingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
