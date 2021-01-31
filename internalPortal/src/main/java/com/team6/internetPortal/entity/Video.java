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
@Table(name = "video_table")
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

}
