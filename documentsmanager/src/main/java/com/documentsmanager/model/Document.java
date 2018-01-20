package com.documentsmanager.model;

import java.util.Date;
import java.util.List;

/**
 * @author Kaan
 *
 */
public class Document {

	private String summary;
	private List<Media> images;
	private int weight;
	private Source source;
	private List<Media> media;
	private Date updatedDate;
	private String title;
	private String url;
	private String content;
	private List<Tag> tags;
	private String seoLink;
	private Tag primaryTag;
	private long id;
	private Date publishedDate;
	private String presentationType;
	private String publishedDateFormatted;
	private String updatedDateFormatted;
	private int status;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getSeoLink() {
		return seoLink;
	}

	public void setSeoLink(String seoLink) {
		this.seoLink = seoLink;
	}

	public Tag getPrimaryTag() {
		return primaryTag;
	}

	public void setPrimaryTag(Tag primaryTag) {
		this.primaryTag = primaryTag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getPresentationType() {
		return presentationType;
	}

	public void setPresentationType(String presentationType) {
		this.presentationType = presentationType;
	}

	public String getPublishedDateFormatted() {
		return publishedDateFormatted;
	}

	public void setPublishedDateFormatted(String publishedDateFormatted) {
		this.publishedDateFormatted = publishedDateFormatted;
	}

	public String getUpdatedDateFormatted() {
		return updatedDateFormatted;
	}

	public void setUpdatedDateFormatted(String updatedDateFormatted) {
		this.updatedDateFormatted = updatedDateFormatted;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
