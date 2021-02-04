package com.team6.internetPortal.dto;

import java.util.Date;

import com.team6.internetPortal.constants.Constants.status;
import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.entity.Video;

public class VideoDTO {

    private long id;

    private String data;

    private String path;

    private String title;

    private String description;

    private boolean isArchived;

    private Date createdOn;

    private Date lastModifiedOn;

    private status status;

    private User creator;


    private Category category;

    public VideoDTO() {
    }

    public VideoDTO(Video video, String data) {
        this.category = video.getCategory();
        this.creator = video.getCreator();
        this.status = video.getStatus();
        this.lastModifiedOn = video.getLastModifiedOn();
        this.createdOn = video.getCreatedOn();
        this.isArchived = video.isArchived();
        this.description = video.getDescription();
        this.title = video.getTitle();
        this.path = video.getPath();
            this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public void setArchived(boolean archived) {
        isArchived = archived;
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
}
