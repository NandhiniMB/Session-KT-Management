package com.team6.internetPortal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "subscription")
public class Subscription {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User subscriber;

	public Subscription(long id, Category category, User subscriber) {
		super();
		this.id = id;
		this.category = category;
		this.subscriber = subscriber;
	}
	
	
	
}
