package com.team6.internetPortal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.team6.internetPortal.constants.Constants.status;

@Entity
@Table(name = "video")
public class Video  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String path;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private boolean isArchived;

	@Column
	private Date createdOn;

	@Column
	private Date lastModifiedOn;
	
	@Enumerated(EnumType.STRING)
	private status status;

	@ManyToOne
	private User creator;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;

	@OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
	private List<Like> likes;

	@OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	private long views;

	public long getViews() {
		return views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public Video(String path, String title, String description, boolean isArchived, Date createdOn, Date lastModifiedOn,
			status status, User creator, Category category) {
		super();
		this.path = path;
		this.title = title;
		this.description = description;
		this.isArchived = isArchived;
		this.createdOn = createdOn;
		this.lastModifiedOn = lastModifiedOn;
		this.status = status;
		this.creator = creator;
		this.category = category;
	}

	public Video() {
	}
	
	public Video(String path) {
		this.path=path;
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

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(com.team6.internetPortal.constants.Constants.status status) {
		this.status = status;
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


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
