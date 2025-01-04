package com.entity.view;

import com.entity.QingjieshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 清洁申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
@TableName("qingjieshenqing")
public class QingjieshenqingView  extends QingjieshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QingjieshenqingView(){
	}
 
 	public QingjieshenqingView(QingjieshenqingEntity qingjieshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, qingjieshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
