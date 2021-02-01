package com.team6.internetPortal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private boolean is_archived;

	@Column
	private Date created_on;

	@Column
	private Date last_modified_on;

//@OneToMany(mapping="video")
//private List<Comment> comments;

	@ManyToOne
	private User creator;

	@ManyToOne
	private Category category;

	public Video(String title, String description, boolean is_archived, Date created_on, Date last_modified_on,
			User creator, Category category) {

		this.title = title;
		this.description = description;
		this.is_archived = is_archived;
		this.created_on = created_on;
		this.last_modified_on = last_modified_on;
		this.creator = creator;
		this.category = category;
	}

	public Video() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isIs_archived() {
		return is_archived;
	}

	public void setIs_archived(boolean is_archived) {
		this.is_archived = is_archived;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getLast_modified_on() {
		return last_modified_on;
	}

	public void setLast_modified_on(Date last_modified_on) {
		this.last_modified_on = last_modified_on;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

}
