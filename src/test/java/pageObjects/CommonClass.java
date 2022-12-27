package pageObjects;

public class CommonClass {
	
	
	private String cVar = "";	
	
	public String getcVar() {
		return cVar;
	}
	public void setcVar(String cVar) {
		this.cVar = cVar;
	}

	public void commonMethod() {
		System.out.println("Common Method");
	}

}
