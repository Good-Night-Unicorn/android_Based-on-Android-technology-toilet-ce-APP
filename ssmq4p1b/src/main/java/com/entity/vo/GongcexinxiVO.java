package com.entity.vo;

import com.entity.GongcexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 公厕信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-04-23 16:39:51
 */
public class GongcexinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 公厕状态
	 */
	
	private String gongcezhuangtai;
		
	/**
	 * 坑位数量
	 */
	
	private Integer kengweishuliang;
		
	/**
	 * 具体位置
	 */
	
	private String jutiweizhi;
		
	/**
	 * 区域
	 */
	
	private String quyu;
		
	/**
	 * 消毒情况
	 */
	
	private String xiaoduqingkuang;
		
	/**
	 * 消毒时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date xiaodushijian;
		
	/**
	 * 员工工号
	 */
	
	private String yuangonggonghao;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
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
	 * 设置：公厕状态
	 */
	 
	public void setGongcezhuangtai(String gongcezhuangtai) {
		this.gongcezhuangtai = gongcezhuangtai;
	}
	
	/**
	 * 获取：公厕状态
	 */
	public String getGongcezhuangtai() {
		return gongcezhuangtai;
	}
				
	
	/**
	 * 设置：坑位数量
	 */
	 
	public void setKengweishuliang(Integer kengweishuliang) {
		this.kengweishuliang = kengweishuliang;
	}
	
	/**
	 * 获取：坑位数量
	 */
	public Integer getKengweishuliang() {
		return kengweishuliang;
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
	 * 设置：区域
	 */
	 
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	
	/**
	 * 获取：区域
	 */
	public String getQuyu() {
		return quyu;
	}
				
	
	/**
	 * 设置：消毒情况
	 */
	 
	public void setXiaoduqingkuang(String xiaoduqingkuang) {
		this.xiaoduqingkuang = xiaoduqingkuang;
	}
	
	/**
	 * 获取：消毒情况
	 */
	public String getXiaoduqingkuang() {
		return xiaoduqingkuang;
	}
				
	
	/**
	 * 设置：消毒时间
	 */
	 
	public void setXiaodushijian(Date xiaodushijian) {
		this.xiaodushijian = xiaodushijian;
	}
	
	/**
	 * 获取：消毒时间
	 */
	public Date getXiaodushijian() {
		return xiaodushijian;
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
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
