package com.qa.TMTY.domain;

import java.util.Objects;

public class Login {
	
	private Long Id;
	private String assignerName;
	private String driversName;
	private boolean privilege = false;

	public Login(String assignerName, String driversName) {

		this.setAssignerName(assignerName);
		this.setDriversName(driversName);
	}

	public Login(String assignerName, String driversName, Long loginsId) {

		this.setAssignerName(assignerName);
		this.setDriversName(driversName);
		this.setId(loginsId);
	}

	public Long getId() {	return Id;}
	public void setId(Long loginsId) {this.Id = loginsId;}
	public String getAssignerName() {return assignerName;}
	public void setAssignerName(String assignerName) {this.assignerName = assignerName;}
	public String getDriversName() {return driversName;}
	public void setDriversName(String driversName) {this.driversName = driversName;}
	public boolean getPrivilege() {return this.privilege;}
	public void setPrivilege(boolean privilege) {this.privilege = privilege;}
	
	@Override
	public String toString() {
		return "Logins [loginsId=" + Id + ", assignerName=" + assignerName + ", driversName=" + driversName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignerName, driversName, Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(assignerName, other.assignerName) && Objects.equals(driversName, other.driversName)
				&& Objects.equals(Id, other.Id);
	}

}
