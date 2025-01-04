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

import com.entity.GongcexinxiEntity;
import com.entity.view.GongcexinxiView;

import com.service.GongcexinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 公厕信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
@RestController
@RequestMapping("/gongcexinxi")
public class GongcexinxiController {
    @Autowired
    private GongcexinxiService gongcexinxiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongcexinxiEntity gongcexinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			gongcexinxi.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongcexinxiEntity> ew = new EntityWrapper<GongcexinxiEntity>();
		PageUtils page = gongcexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongcexinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongcexinxiEntity gongcexinxi, 
		HttpServletRequest request){
        EntityWrapper<GongcexinxiEntity> ew = new EntityWrapper<GongcexinxiEntity>();
		PageUtils page = gongcexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongcexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongcexinxiEntity gongcexinxi){
       	EntityWrapper<GongcexinxiEntity> ew = new EntityWrapper<GongcexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongcexinxi, "gongcexinxi")); 
        return R.ok().put("data", gongcexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongcexinxiEntity gongcexinxi){
        EntityWrapper< GongcexinxiEntity> ew = new EntityWrapper< GongcexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongcexinxi, "gongcexinxi")); 
		GongcexinxiView gongcexinxiView =  gongcexinxiService.selectView(ew);
		return R.ok("查询公厕信息成功").put("data", gongcexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongcexinxiEntity gongcexinxi = gongcexinxiService.selectById(id);
		gongcexinxi.setClicknum(gongcexinxi.getClicknum()+1);
		gongcexinxi.setClicktime(new Date());
		gongcexinxiService.updateById(gongcexinxi);
        return R.ok().put("data", gongcexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongcexinxiEntity gongcexinxi = gongcexinxiService.selectById(id);
		gongcexinxi.setClicknum(gongcexinxi.getClicknum()+1);
		gongcexinxi.setClicktime(new Date());
		gongcexinxiService.updateById(gongcexinxi);
        return R.ok().put("data", gongcexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongcexinxiEntity gongcexinxi, HttpServletRequest request){
    	gongcexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongcexinxi);

        gongcexinxiService.insert(gongcexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongcexinxiEntity gongcexinxi, HttpServletRequest request){
    	gongcexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongcexinxi);

        gongcexinxiService.insert(gongcexinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongcexinxiEntity gongcexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongcexinxi);
        gongcexinxiService.updateById(gongcexinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongcexinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GongcexinxiEntity> wrapper = new EntityWrapper<GongcexinxiEntity>();
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

		int count = gongcexinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GongcexinxiEntity gongcexinxi, HttpServletRequest request,String pre){
        EntityWrapper<GongcexinxiEntity> ew = new EntityWrapper<GongcexinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = gongcexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongcexinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,GongcexinxiEntity gongcexinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "quyu";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "gongcexinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<GongcexinxiEntity> gongcexinxiList = new ArrayList<GongcexinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                gongcexinxiList.addAll(gongcexinxiService.selectList(new EntityWrapper<GongcexinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<GongcexinxiEntity> ew = new EntityWrapper<GongcexinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = gongcexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongcexinxi), params), params));
        List<GongcexinxiEntity> pageList = (List<GongcexinxiEntity>)page.getList();
        if(gongcexinxiList.size()<limit) {
            int toAddNum = (limit-gongcexinxiList.size())<=pageList.size()?(limit-gongcexinxiList.size()):pageList.size();
            for(GongcexinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(GongcexinxiEntity o2 : gongcexinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    gongcexinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(gongcexinxiList.size()>limit) {
            gongcexinxiList = gongcexinxiList.subList(0, limit);
        }
        page.setList(gongcexinxiList);
        return R.ok().put("data", page);
    }





}
