package com.ebsco.platform.training.tdd.begin.app.dto;

public class GreetingDTO {
    private Long userid;
    private String prefix;
    private String suffix;
    
    public GreetingDTO() {
        super();
    }
    
    public GreetingDTO(Long userid) {
        super();
        this.userid = userid;
    }
    
    public GreetingDTO(String prefix, Long userid) {
        super();
        this.prefix = prefix;
        this.userid = userid;
    }
    
    public GreetingDTO(Long userid, String prefix, String suffix) {
        super();
        this.prefix = prefix;
        this.userid = userid;
        this.suffix = suffix;
    }

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
    
}
