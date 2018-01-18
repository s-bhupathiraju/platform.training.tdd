package com.ebsco.platform.training.tdd.begin.dto;

public class GreetingDTO {
    private Integer userid;
    private String prefix;
    private String suffix;
    
    public GreetingDTO() {
        super();
    }
    
    public GreetingDTO(Integer userid) {
        super();
        this.userid = userid;
    }
    
    public GreetingDTO(String prefix, Integer userid) {
        super();
        this.prefix = prefix;
        this.userid = userid;
    }
    
    public GreetingDTO(String prefix, Integer userid, String suffix) {
        super();
        this.prefix = prefix;
        this.userid = userid;
        this.suffix = suffix;
    }

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
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
