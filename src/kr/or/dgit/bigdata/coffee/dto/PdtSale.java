package kr.or.dgit.bigdata.coffee.dto;

public class PdtSale {
	private String cfCode;
	private int cfOne;
	private int cfSell;
	private int cfMargin;

	public PdtSale() {

	}

	public PdtSale(String cfCode) {
		super();
		this.cfCode = cfCode;
	}

	public PdtSale(String cfCode, int cfOne, int cfSell, int cfMargin) {
		super();
		this.cfCode = cfCode;
		this.cfOne = cfOne;
		this.cfSell = cfSell;
		this.cfMargin = cfMargin;
	}

	public String getCfCode() {
		return cfCode;
	}

	public void setCfCode(String cfCode) {
		this.cfCode = cfCode;
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

	public int getCfMargin() {
		return cfMargin;
	}

	public void setCfMargin(int cfMargin) {
		this.cfMargin = cfMargin;
	}

	@Override
	public String toString() {
		return String.format("PdtSale [cfCode=%s, cfOne=%s, cfSell=%s, cfMargin=%s]", cfCode, cfOne, cfSell, cfMargin);
	}

}
