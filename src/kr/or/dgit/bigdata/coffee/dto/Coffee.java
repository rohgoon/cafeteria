package kr.or.dgit.bigdata.coffee.dto;

public class Coffee {
	private String code;
	private String name;
	private int cfOne;
	private int cfSell;
	
	public Coffee() {
		super();
	}
	
	public Coffee(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Coffee(String code, String name, int cfOne, int cfSell) {
		super();
		this.code = code;
		this.name = name;
		this.cfOne = cfOne;
		this.cfSell = cfSell;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCfOne() {
		return cfOne;
	}

	public void setCfOne(int cfOne) {
		this.cfOne = cfOne;
	}

	public int getCfSell() {
		return cfSell;
	}

	public void setCfSell(int cfSell) {
		this.cfSell = cfSell;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", name, code);
	}
	
	
}
