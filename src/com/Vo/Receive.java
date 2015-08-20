package com.Vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * 接收表
 *
 */
@Entity
@SequenceGenerator(name="ReceiveSEQ",allocationSize=1,sequenceName="ReceiveSEQDB")
public class Receive {

	private int m_recId;		//接收编号
	private int m_planId;		//活动编号
	private int m_secId;		//能收单的单位
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="ReceiveSEQ")
	public int getM_recId() {
		return m_recId;
	}
	public void setM_recId(int m_recId) {
		this.m_recId = m_recId;
	}
	public int getM_planId() {
		return m_planId;
	}
	public void setM_planId(int m_planId) {
		this.m_planId = m_planId;
	}
	public int getM_secId() {
		return m_secId;
	}
	public void setM_secId(int m_secId) {
		this.m_secId = m_secId;
	}
	
	
}
