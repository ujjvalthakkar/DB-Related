package com.neu.datatitans.pojo;
// Generated Apr 27, 2017 9:50:32 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * MemberAddress generated by hbm2java
 */
@Entity
@Table(name = "member_address")
public class MemberAddress implements java.io.Serializable {

	private long memberId;
	private String city;
	private String zip;
	private Member member;
	private String addressType;
	private int buildingNo;
	private String streetName;

	public MemberAddress() {
	}

	public MemberAddress(String city, Member member, String addressType, int buildingNo, String streetName,String zip) {
		this.city = city;
		this.member = member;
		this.addressType = addressType;
		this.buildingNo = buildingNo;
		this.streetName = streetName;
		this.zip=zip;
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


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name = "address_type", nullable = false, length = 20)
	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Column(name = "building_no", nullable = false)
	public int getBuildingNo() {
		return this.buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	@Column(name = "street_name", nullable = false, length = 30)
	public String getStreetName() {
		return this.streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

}