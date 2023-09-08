package edu.satraining.lesson12.model;
import java.util.Date;

public class Parameter extends BaseModel {
	
	private String paramCode;
	private String paramName;
	private String description;
	
	public Parameter() {
		
	}
	
	public Parameter(String paramCode, String paramName, String description, String createdBy, Date createdTime) {
		super();
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.description = description;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
}
