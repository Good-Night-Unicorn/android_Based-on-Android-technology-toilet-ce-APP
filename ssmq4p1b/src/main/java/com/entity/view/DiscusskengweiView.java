package com.entity.view;

import com.entity.DiscusskengweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 坑位评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
@TableName("discusskengwei")
public class DiscusskengweiView  extends DiscusskengweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusskengweiView(){
	}
 
 	public DiscusskengweiView(DiscusskengweiEntity discusskengweiEntity){
 	try {
			BeanUtils.copyProperties(this, discusskengweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
