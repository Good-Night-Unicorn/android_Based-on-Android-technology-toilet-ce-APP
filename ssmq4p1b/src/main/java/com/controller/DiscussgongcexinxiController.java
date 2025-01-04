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

import com.entity.DiscussgongcexinxiEntity;
import com.entity.view.DiscussgongcexinxiView;

import com.service.DiscussgongcexinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 公厕信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
@RestController
@RequestMapping("/discussgongcexinxi")
public class DiscussgongcexinxiController {
    @Autowired
    private DiscussgongcexinxiService discussgongcexinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussgongcexinxiEntity discussgongcexinxi, 
		HttpServletRequest request){

        EntityWrapper<DiscussgongcexinxiEntity> ew = new EntityWrapper<DiscussgongcexinxiEntity>();
		PageUtils page = discussgongcexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgongcexinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussgongcexinxiEntity discussgongcexinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussgongcexinxiEntity> ew = new EntityWrapper<DiscussgongcexinxiEntity>();
		PageUtils page = discussgongcexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgongcexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussgongcexinxiEntity discussgongcexinxi){
       	EntityWrapper<DiscussgongcexinxiEntity> ew = new EntityWrapper<DiscussgongcexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussgongcexinxi, "discussgongcexinxi")); 
        return R.ok().put("data", discussgongcexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussgongcexinxiEntity discussgongcexinxi){
        EntityWrapper< DiscussgongcexinxiEntity> ew = new EntityWrapper< DiscussgongcexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussgongcexinxi, "discussgongcexinxi")); 
		DiscussgongcexinxiView discussgongcexinxiView =  discussgongcexinxiService.selectView(ew);
		return R.ok("查询公厕信息评论表成功").put("data", discussgongcexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussgongcexinxiEntity discussgongcexinxi = discussgongcexinxiService.selectById(id);
        return R.ok().put("data", discussgongcexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussgongcexinxiEntity discussgongcexinxi = discussgongcexinxiService.selectById(id);
        return R.ok().put("data", discussgongcexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussgongcexinxiEntity discussgongcexinxi, HttpServletRequest request){
    	discussgongcexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussgongcexinxi);

        discussgongcexinxiService.insert(discussgongcexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussgongcexinxiEntity discussgongcexinxi, HttpServletRequest request){
    	discussgongcexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussgongcexinxi);

        discussgongcexinxiService.insert(discussgongcexinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussgongcexinxiEntity discussgongcexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussgongcexinxi);
        discussgongcexinxiService.updateById(discussgongcexinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussgongcexinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussgongcexinxiEntity> wrapper = new EntityWrapper<DiscussgongcexinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussgongcexinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
