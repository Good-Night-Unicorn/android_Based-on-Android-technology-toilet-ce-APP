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

import com.entity.KengweishiyongEntity;
import com.entity.view.KengweishiyongView;

import com.service.KengweishiyongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 坑位使用
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
@RestController
@RequestMapping("/kengweishiyong")
public class KengweishiyongController {
    @Autowired
    private KengweishiyongService kengweishiyongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KengweishiyongEntity kengweishiyong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			kengweishiyong.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			kengweishiyong.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KengweishiyongEntity> ew = new EntityWrapper<KengweishiyongEntity>();
		PageUtils page = kengweishiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kengweishiyong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KengweishiyongEntity kengweishiyong, 
		HttpServletRequest request){
        EntityWrapper<KengweishiyongEntity> ew = new EntityWrapper<KengweishiyongEntity>();
		PageUtils page = kengweishiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kengweishiyong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KengweishiyongEntity kengweishiyong){
       	EntityWrapper<KengweishiyongEntity> ew = new EntityWrapper<KengweishiyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kengweishiyong, "kengweishiyong")); 
        return R.ok().put("data", kengweishiyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KengweishiyongEntity kengweishiyong){
        EntityWrapper< KengweishiyongEntity> ew = new EntityWrapper< KengweishiyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kengweishiyong, "kengweishiyong")); 
		KengweishiyongView kengweishiyongView =  kengweishiyongService.selectView(ew);
		return R.ok("查询坑位使用成功").put("data", kengweishiyongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KengweishiyongEntity kengweishiyong = kengweishiyongService.selectById(id);
        return R.ok().put("data", kengweishiyong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KengweishiyongEntity kengweishiyong = kengweishiyongService.selectById(id);
        return R.ok().put("data", kengweishiyong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KengweishiyongEntity kengweishiyong, HttpServletRequest request){
    	kengweishiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kengweishiyong);

        kengweishiyongService.insert(kengweishiyong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KengweishiyongEntity kengweishiyong, HttpServletRequest request){
    	kengweishiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kengweishiyong);

        kengweishiyongService.insert(kengweishiyong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KengweishiyongEntity kengweishiyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kengweishiyong);
        kengweishiyongService.updateById(kengweishiyong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kengweishiyongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<KengweishiyongEntity> wrapper = new EntityWrapper<KengweishiyongEntity>();
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

		int count = kengweishiyongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
