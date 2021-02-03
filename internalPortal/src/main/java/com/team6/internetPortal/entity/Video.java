package com.team6.internetPortal.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@Lob
//    private byte[] data;

	@Column
	private String path;

//	public byte[] getData() {
//		return data;
//	}
//
//	public void setData(byte[] data) {
//		this.data = data;
//	}

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
	
	@Column
	private String status;

	@ManyToOne
	private User creator;

	@ManyToOne
	private Category category;

	public Video(String path, String title, String description, boolean isArchived, Date createdOn, Date lastModifiedOn,
			String status, User creator, Category category) {
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
		// TODO Auto-generated constructor stub
	}
	
	public Video(String path) {
		// TODO Auto-generated constructor stub
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
