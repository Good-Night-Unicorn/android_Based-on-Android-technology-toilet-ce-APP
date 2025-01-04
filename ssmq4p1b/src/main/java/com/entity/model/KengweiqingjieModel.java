package com.entity.model;

import com.entity.KengweiqingjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 坑位清洁
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public class KengweiqingjieModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 公厕名称
	 */
	
	private String gongcemingcheng;
		
	/**
	 * 坑位状态
	 */
	
	private String kengweizhuangtai;
		
	/**
	 * 清洁时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date qingjieshijian;
		
	/**
	 * 员工工号
	 */
	
	private String yuangonggonghao;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
				
	
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
	 * 设置：清洁时间
	 */
	 
	public void setQingjieshijian(Date qingjieshijian) {
		this.qingjieshijian = qingjieshijian;
	}
	
	/**
	 * 获取：清洁时间
	 */
	public Date getQingjieshijian() {
		return qingjieshijian;
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
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
			
}
