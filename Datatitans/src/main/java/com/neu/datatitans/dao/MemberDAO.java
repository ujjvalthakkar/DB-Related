package com.neu.datatitans.dao;

import java.util.List;

import org.hibernate.HibernateException;
import com.neu.datatitans.pojo.Member;
import com.neu.datatitans.pojo.MemberAddress;
import com.neu.datatitans.pojo.MemberPhone;
import com.neu.datatitans.pojo.PersonalInfo;
import com.neu.datatitans.pojo.Subscriber;

public class MemberDAO extends DAO {
	public MemberDAO() {

	}

	public Member createMember(Member m) {
		try {
			begin();
			System.out.println("inside createMember");
			getSession().save(m);
			commit();
			close();
			return m;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}

	public Member getMember(String memberId) {
		try {
			begin();
			System.out.println("inside getMember");
			Member m = (Member) getSession().createQuery("from Member where member_id=:memberId")
					.setParameter("memberId", memberId).uniqueResult();
			commit();
			close();
			return m;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public Subscriber getSubscriber(String subId) {
		try {
			begin();
			System.out.println("inside getMember");
			Subscriber s = (Subscriber) getSession().createQuery("from Subscriber where sub_id=:subId")
					.setParameter("subId", subId).uniqueResult();
			commit();
			close();
			return s;
		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}

	public void deleteMember(String memberId) {
		try {
			begin();
			System.out.println("inside deleteMember>>>>" + memberId);
			Member m = (Member) getSession().createQuery("from Member where member_id=:memberId")
					.setParameter("memberId", memberId).uniqueResult();
			MemberAddress ma = m.getMemberAddress();
			MemberPhone mp = m.getMemberPhone();
			PersonalInfo pi = m.getPersonalInfo();
			getSession().delete(ma);
			getSession().delete(mp);
			getSession().delete(pi);
			getSession().delete(m);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
		}
	}
	
	public void deleteSubscriber(String subId) {
		try {
			begin();
			System.out.println("inside deleteSubscriber>>>>" + subId);
			Subscriber s = (Subscriber) getSession().createQuery("from Subscriber where sub_id=:subid")
					.setParameter("subid", subId).uniqueResult();
			getSession().delete(s);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
		}
	}

	public Member updateMember(Member member) {
		try {
			begin();
			System.out.println("inside updateMember");
			getSession().saveOrUpdate(member);
			commit();
			close();
			return member;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public Subscriber updateSubscriber(Subscriber s) {
		try {
			begin();
			System.out.println("inside updateSubscriber");
			getSession().saveOrUpdate(s);
			commit();
			close();
			return s;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}

	public List<Member> getMemberList() {
		try {
			begin();
			System.out.println("inside MemberDAO");
			List<Member> memberList = getSession().createQuery("from Member").list();
			commit();
			close();
			return memberList;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	public List<Subscriber> getSubscriberList() {
		try {
			begin();
			List<Subscriber> subscriberList = getSession().createQuery("from Subscriber").list();
			commit();
			close();
			return subscriberList;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public MemberAddress createMemberAddress(MemberAddress ma) {
		try {
			begin();
			System.out.println("inside MemberDAO");
			getSession().save(ma);
			commit();
			close();
			return ma;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public MemberAddress updateMemberAddress(MemberAddress ma) {
		try {
			begin();
			System.out.println("inside MemberDAO");
			getSession().saveOrUpdate(ma);
			commit();
			close();
			return ma;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}

	public MemberPhone createMemberPhone(MemberPhone ma) {
		try {
			begin();
			System.out.println("inside MemberDAO");
			getSession().save(ma);
			commit();
			close();
			return ma;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public MemberPhone updateMemberPhone(MemberPhone ma) {
		try {
			begin();
			System.out.println("inside MemberDAO");
			getSession().saveOrUpdate(ma);
			commit();
			close();
			return ma;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}

	public PersonalInfo createPersonalInfo(PersonalInfo ma) {
		try {
			begin();
			System.out.println("inside MemberDAO");
			getSession().save(ma);
			commit();
			close();
			return ma;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public PersonalInfo updatePersonalInfo(PersonalInfo ma) {
		try {
			begin();
			System.out.println("inside MemberDAO");
			getSession().saveOrUpdate(ma);
			commit();
			close();
			return ma;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
}
