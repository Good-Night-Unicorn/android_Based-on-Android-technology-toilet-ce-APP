package com.entity.model;

import com.entity.KengweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 坑位
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public class KengweiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 坑位状态
	 */
	
	private String kengweizhuangtai;
		
	/**
	 * 公厕名称
	 */
	
	private String gongcemingcheng;
		
	/**
	 * 具体位置
	 */
	
	private String jutiweizhi;
		
	/**
	 * 员工工号
	 */
	
	private String yuangonggonghao;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：坑位状态
	 */
	 
	public void setKengweizhuangtai(String kengweizhuangtai) {
		this.kengweizhuangtai = kengweizhuangtai;
	}
	
	/**
	 * 获取：坑位状态
	 */
	public String getKengweizhuangtai() {
		return kengweizhuangtai;
	}
				
	
	/**
	 * 设置：公厕名称
	 */
	 
	public void setGongcemingcheng(String gongcemingcheng) {
		this.gongcemingcheng = gongcemingcheng;
	}
	
	/**
	 * 获取：公厕名称
	 */
	public String getGongcemingcheng() {
		return gongcemingcheng;
	}
				
	
	/**
	 * 设置：具体位置
	 */
	 
	public void setJutiweizhi(String jutiweizhi) {
		this.jutiweizhi = jutiweizhi;
	}
	
	/**
	 * 获取：具体位置
	 */
	public String getJutiweizhi() {
		return jutiweizhi;
	}
				
	
	/**
	 * 设置：员工工号
	 */
	 
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
				
	
	/**
	 * 设置：员工姓名
	 */
	 
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
			
}
