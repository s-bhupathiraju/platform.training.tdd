package com.ebsco.platform.training.tdd.begin.app.exception.detail;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class ErrorDetail {

	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String developerMessage;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("title", title);
		builder.append("status", status);
		builder.append("detail", detail);
		builder.append("timestamp", timestamp);
		builder.append("developerMessage", developerMessage);
		return builder.toString();
	}

}