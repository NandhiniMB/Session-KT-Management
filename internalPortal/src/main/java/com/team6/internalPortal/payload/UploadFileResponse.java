package com.team6.internalPortal.payload;

public class UploadFileResponse {
	private String title;
	private String description;
	private long id;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UploadFileResponse(String title, String description, long id) {
		super();
		this.title = title;
		this.description = description;
		this.id = id;
	}
	
}
