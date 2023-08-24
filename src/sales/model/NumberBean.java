package sales.model;

import javax.servlet.ServletConfig;

public class NumberBean {
	
	private String name;
	private String code;
	private double sales;
	
	private double commission;
	private double gross;
	
	private ServletConfig config;
	
	public NumberBean(){
		
	}
	
	public NumberBean(String name, String code, double sales, ServletConfig config) {
		this.name = name;
		this.code = code;
		this.sales = sales;
		this.config = config;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}
	
	public double getComm() {
		return commission;
	}

	public void setComm(double commission) {
		this.commission = commission;
	}
	
	public double getGross() {
		return gross;
	}

	public void setGross(double gross) {
		this.gross = gross;
	}
	
	public void ComputeGross(){
		if(this.code.equals("A")){
			this.gross = (this.sales * Double.parseDouble(config.getInitParameter("codeAGrossPercentage"))) + 
					Double.parseDouble(config.getInitParameter("codeAGrossValue"));
		}
		else if(this.code.equals("B")){
			this.gross = (this.sales * Double.parseDouble(config.getInitParameter("codeBGrossPercentage"))) + 
					Double.parseDouble(config.getInitParameter("codeBGrossValue"));
		}
		else{
			this.gross = (this.sales * Double.parseDouble(config.getInitParameter("codeCGrossPercentage"))) + 
					Double.parseDouble(config.getInitParameter("codeCGrossValue"));
		}
	}
	
	public void ComputeComm(){
		if(this.sales > Double.parseDouble(config.getInitParameter("commissionStandard"))){
			this.commission = this.sales * Double.parseDouble(config.getInitParameter("commissionPercentage"));
		}
	}
}
