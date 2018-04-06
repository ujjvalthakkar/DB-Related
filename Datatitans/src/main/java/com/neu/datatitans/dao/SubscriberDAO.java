package com.neu.datatitans.dao;

import org.hibernate.HibernateException;

import com.neu.datatitans.pojo.Member;
import com.neu.datatitans.pojo.Subscriber;

public class SubscriberDAO extends DAO{

	public SubscriberDAO(){
		
	}
	public Subscriber createSubscriber(Subscriber s) {
		try {
			begin();
			System.out.println("inside createSubscriber");
			getSession().save(s);
			commit();
			close();
			return s;

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
}
