package com.team6.internetPortal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String category_name;

	@Column
	private Date created_on;

	public Category(String category_name, Date date) {

		this.category_name = category_name;
		this.created_on = date;
	}

}
