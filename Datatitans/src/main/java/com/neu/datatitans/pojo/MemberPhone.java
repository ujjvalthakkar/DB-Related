package com.neu.datatitans.pojo;
// Generated Apr 27, 2017 9:50:32 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * MemberPhone generated by hbm2java
 */
@Entity
@Table(name = "member_phone")
public class MemberPhone implements java.io.Serializable {

	private long memberId;
	private Member member;
	private String phoneType;
	private String phone;

	public MemberPhone() {
	}

	public MemberPhone(Member member, String phoneType, String phone) {
		this.member = member;
		this.phoneType = phoneType;
		this.phone = phone;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "member"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "member_id", unique = true, nullable = false, length = 6)
	public long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name = "phone_type", nullable = false, length = 10)
	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	@Column(name = "phone", nullable = false, length = 14)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
