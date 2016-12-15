package kr.or.dgit.bigdata.coffee.dto;

public class ViewTable {
	private int rank;
	private String cfCode;
	private String cfName;
	private int cfOne;
	private int cfSell;
	private int cfMargin;
	private int salePrice;
	private int addTax;
	private int supplyPrice;
	private int marginPrice;
	
	
	public ViewTable() {
		
	}


	public ViewTable(String cfCode) {
		super();
		this.cfCode = cfCode;
	}


	public ViewTable(int rank ,String cfCode, String cfName, int cfOne, int cfSell, int cfMargin, int salePrice, int addTax,
			int supplyPrice, int marginPrice) {
		super();
		this.rank = rank;
		this.cfCode = cfCode;
		this.cfName = cfName;
		this.cfOne = cfOne;
		this.cfSell = cfSell;
		this.cfMargin = cfMargin;
		this.salePrice = salePrice;
		this.addTax = addTax;
		this.supplyPrice = supplyPrice;
		this.marginPrice = marginPrice;
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


	public int getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}


	public int getAddTax() {
		return addTax;
	}


	public void setAddTax(int addTax) {
		this.addTax = addTax;
	}


	public int getSupplyPrice() {
		return supplyPrice;
	}


	public void setSupplyPrice(int supplyPrice) {
		this.supplyPrice = supplyPrice;
	}


	public int getMarginPrice() {
		return marginPrice;
	}


	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}
	
	
	public String cfNameToString(){
		
		return String.format("%s", cfName);
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"CoffeeList1 [cfCode=%s, cfName=%s, cfOne=%s, cfSell=%s, cfMargin=%s, salePrice=%s, addTax=%s, supplyPrice=%s, marginPrice=%s]",
				cfCode, cfName, cfOne, cfSell, cfMargin, salePrice, addTax, supplyPrice, marginPrice);
	}
	
	public String[] toArray(){
		return new String[]{rank+"", cfCode, cfName, cfOne+"", cfSell+"", cfMargin+"", salePrice+"", addTax+"", supplyPrice+"", marginPrice+""};
		
	}
	
	
	
	
}
