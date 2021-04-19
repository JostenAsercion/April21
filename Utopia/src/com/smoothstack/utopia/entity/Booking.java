/**
 * 
 */
package com.smoothstack.utopia.entity;

/**
 * The booking entity
 * 
 * @author Joa
 *
 */
public class Booking {
	private Integer id;
	private byte isActive;
	private String confirmationCode;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the isActive
	 */
	public byte getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the confirmationCode
	 */
	public String getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * @param confirmationCode the confirmationCode to set
	 */
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

}
