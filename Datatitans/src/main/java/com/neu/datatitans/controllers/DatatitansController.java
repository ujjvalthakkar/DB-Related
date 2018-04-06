package com.neu.datatitans.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.datatitans.dao.MemberDAO;
import com.neu.datatitans.dao.SubscriberDAO;
import com.neu.datatitans.pojo.Member;
import com.neu.datatitans.pojo.MemberAddress;
import com.neu.datatitans.pojo.MemberPhone;
import com.neu.datatitans.pojo.PersonalInfo;
import com.neu.datatitans.pojo.Subscriber;


@Controller
public class DatatitansController {
	
	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	SubscriberDAO subscriberDao;
	
	@Autowired
	ServletContext servletContext;

	
	@RequestMapping(value = "/addMember.htm", method = RequestMethod.GET)
	public String addMemberFormShow(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		return "addMember";
	}
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String showHome(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		return "home";
	}
	@RequestMapping(value = "/displayMembers.htm", method = RequestMethod.GET)
	public String searchMember(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		List<Member> memberList=new ArrayList<Member>();
		memberList=memberDao.getMemberList();
		request.getSession().setAttribute("memberList", memberList); 
		return "displayMembers";
	}
	@RequestMapping(value = "/createSubscriber.htm", method = RequestMethod.GET)
	public String createSubscriber(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		return "createSubscriber";
	}
	@RequestMapping(value = "/displaySubscriber.htm", method = RequestMethod.GET)
	public String searchSubscriber(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		List<Subscriber> subscriberList=new ArrayList<Subscriber>();
		subscriberList=memberDao.getSubscriberList();
		request.getSession().setAttribute("subscriberList", subscriberList); 
		return "displaySubscriber";
	}
	
	@RequestMapping(value = "/editMember.htm", method = RequestMethod.POST)
	public String editMember(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		String memberId=request.getParameter("memberId");
		Member member=memberDao.getMember(memberId);
		request.getSession().setAttribute("member", member);
		return "editMember";
	}
	
	@RequestMapping(value = "/editSubscriber.htm", method = RequestMethod.POST)
	public String editSubscriber(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		String subId=request.getParameter("subscriberId");
		Subscriber subscriber=memberDao.getSubscriber(subId);
		request.getSession().setAttribute("subscriber", subscriber);
		return "editSubscriber";
	}
	
	@RequestMapping(value = "/updateMember.htm", method = RequestMethod.POST)
	public String updateMember(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		String memberId=request.getParameter("memberId");
		Member member=memberDao.getMember(memberId);
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		String profession=request.getParameter("profession");
		String ssn=request.getParameter("ssn");
		String addresstype=request.getParameter("addresstype");
		String buildingnumber=request.getParameter("buildingnumber");
		String streetname=request.getParameter("streetname");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String phonetype=request.getParameter("phonetype");
		String phonenumber=request.getParameter("phonenumber");
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
		Date d=new Date();
		try {
			d = formatter1.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">>>"+fname+">>>"+lname+">>>"+">>>"+dob+">>>"+profession+">>>"+ssn+">>>"+addresstype+">>>"+buildingnumber+">>>"+streetname);
		System.out.println(">>>"+city+">>>"+zip+">>>"+phonetype+">>>"+phonenumber);
		
		MemberAddress memberAddress=member.getMemberAddress();
		MemberPhone memberPhone=member.getMemberPhone();
		PersonalInfo personalInfo=member.getPersonalInfo();
		
		
		member.setMemberFname(fname);
		member.setMemberLname(lname);
		personalInfo.setDob(d);
		personalInfo.setMemberProfession(profession);
		personalInfo.setSsn(ssn);
		personalInfo.setMember(member);
		memberPhone.setMember(member);
		memberPhone.setPhone(phonenumber);
		memberPhone.setPhoneType(phonetype);
		memberAddress.setAddressType(addresstype);
		memberAddress.setBuildingNo(Integer.parseInt(buildingnumber));
		memberAddress.setStreetName(streetname);
		memberAddress.setMember(member);
		memberAddress.setCity(city);
		memberAddress.setZip(zip);
		member.setMemberPhone(memberPhone);
		member.setPersonalInfo(personalInfo);
		member.setMemberAddress(memberAddress);
		memberDao.updateMember(member);
		memberDao.updateMemberAddress(memberAddress);
		memberDao.updateMemberPhone(memberPhone);
		memberDao.updatePersonalInfo(personalInfo);
		
		List<Member> memberList=new ArrayList<Member>();
		memberList=memberDao.getMemberList();
		request.getSession().setAttribute("memberList", memberList);
		return "displayMembers";
	}
	
	
	@RequestMapping(value = "/updateSubscriber.htm", method = RequestMethod.POST)
	public String updateSubscriber(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		String subId=request.getParameter("subId");
		Subscriber s=memberDao.getSubscriber(subId);
		
		String addType=request.getParameter("addresstype");
		if(addType.equals("Ogranization")){
			String fullname=request.getParameter("fullname");
			s.setSubFullname(fullname);
			s.setSubFname("");
			s.setSubLname("");
		}
		
		if(addType.equals("Individual")){
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String fullname=fname+" "+lname;
			s.setSubFullname(fullname);
			s.setSubFname(fname);
			s.setSubLname(lname);
		}
		
		memberDao.updateSubscriber(s);

		List<Subscriber> subscriberList=new ArrayList<Subscriber>();
		subscriberList=memberDao.getSubscriberList();
		request.getSession().setAttribute("subscriberList", subscriberList); 
		return "displaySubscriber";
	}
	
	
	@RequestMapping(value = "/deleteMember.htm", method = RequestMethod.POST)
	public String deleteMember(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		String memberId=request.getParameter("memberId");
		memberDao.deleteMember(memberId);
		List<Member> memberList=new ArrayList<Member>();
		memberList=memberDao.getMemberList();
		request.getSession().setAttribute("memberList", memberList);
		return "displayMembers";
	}
	
	@RequestMapping(value = "/deleteSubscriber.htm", method = RequestMethod.POST)
	public String deleteSubscriber(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg","");
		String subscriberId=request.getParameter("subscriberId");
		memberDao.deleteSubscriber(subscriberId);
		List<Subscriber> memberList=new ArrayList<Subscriber>();
		memberList=memberDao.getSubscriberList();
		request.getSession().setAttribute("subscriberList", memberList);
		return "displaySubscriber";
	}
	
	@RequestMapping(value = "/addMember.htm", method = RequestMethod.POST)
	public String addMember(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside addMember");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String profession=request.getParameter("profession");
		String ssn=request.getParameter("ssn");
		String addresstype=request.getParameter("addresstype");
		String buildingnumber=request.getParameter("buildingnumber");
		String streetname=request.getParameter("streetname");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String phonetype=request.getParameter("phonetype");
		String phonenumber=request.getParameter("phonenumber");
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
		Date d=new Date();
		try {
			d = formatter1.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">>>"+fname+">>>"+lname+">>>"+gender+">>>"+dob+">>>"+profession+">>>"+ssn+">>>"+addresstype+">>>"+buildingnumber+">>>"+streetname);
		System.out.println(">>>"+city+">>>"+zip+">>>"+phonetype+">>>"+phonenumber);
		
		Member member=new Member();
		MemberAddress memberAddress=new MemberAddress();
		MemberPhone memberPhone=new MemberPhone();
		PersonalInfo personalInfo=new PersonalInfo();
		
		
		member.setMemberFname(fname);
		member.setMemberInsuranceStatus(false);
		member.setMemberLname(lname);
		personalInfo.setGender(gender.charAt(0));
		personalInfo.setDob(d);
		personalInfo.setMemberProfession(profession);
		personalInfo.setSsn(ssn);
		personalInfo.setMember(member);
		memberPhone.setMember(member);
		memberPhone.setPhone(phonenumber);
		memberPhone.setPhoneType(phonetype);
		memberAddress.setAddressType(addresstype);
		memberAddress.setBuildingNo(Integer.parseInt(buildingnumber));
		memberAddress.setStreetName(streetname);
		memberAddress.setMember(member);
		memberAddress.setCity(city);
		memberAddress.setZip(zip);
		member.setMemberPhone(memberPhone);
		member.setPersonalInfo(personalInfo);
		member.setMemberAddress(memberAddress);
		memberDao.createMember(member);
		//memberDao.createCity(cityy);
		memberDao.createMemberAddress(memberAddress);
		memberDao.createMemberPhone(memberPhone);
		memberDao.createPersonalInfo(personalInfo);
		request.setAttribute("msg","Member Created Successfully!!");
		return "home";
	}
	@RequestMapping(value = "/addSubscriber.htm", method = RequestMethod.POST)
	public String addSubscriber(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside addSubscriber");
		String addType=request.getParameter("addresstype");
		Subscriber s=new Subscriber();
		if(addType.equals("Ogranization")){
			String fullname=request.getParameter("fullname");
			s.setSubFullname(fullname);
			s.setSubFname("");
			s.setSubLname("");
		}
		
		if(addType.equals("Individual")){
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String fullname=fname+" "+lname;
			s.setSubFullname(fullname);
			s.setSubFname(fname);
			s.setSubLname(lname);
		}
		s=subscriberDao.createSubscriber(s);
		request.setAttribute("msg","Subscriber Created Successfully");
		return "home";
	}
}