package com.chzyplus.member.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * * 程序名 : SmsDao
 * 建立日期: 2018-07-09
 * 作者 : someday
 * 模块 : 短信中心
 * 描述 : 短信model
 * 备注 : version20180709001
 * <p>
 * 修改历史
 * 序号 	       日期 		        修改人 		         修改原因
 */
@Data
public class Sms implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4648169168575518593L;
	private Long id;
	private String phone;
	private String signName;
	private String templateCode;
	private String params;
	private String bizId;
	private String code;
	private String message;
	private Date day;
	private Date createTime;
	private Date updateTime;
}
