package kr.or.dgit.bigdata.coffee.dto;

public class PdtCode {
	private String cfCode;
	private String cfName;
	
	public PdtCode() {
	
	}

	public PdtCode(String cfCode) {
		super();
		this.cfCode = cfCode;
	}

	public PdtCode(String cfCode, String cfName) {
		super();
		this.cfCode = cfCode;
		this.cfName = cfName;
	}

	public String getCfCode() {
		return cfCode;
	}

	public void setCfCode(String cfCode) {
		this.cfCode = cfCode;
	}

	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	@Override
	public String toString() {
		return String.format("%s", cfName);
	}
	
	
}
