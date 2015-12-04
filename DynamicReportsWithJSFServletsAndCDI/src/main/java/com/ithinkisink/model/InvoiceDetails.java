package com.ithinkisink.model;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Belal
 *
 */
public class InvoiceDetails {
	
	private String invoiceNo;
	private String billingCompanyName;
	private String billingCompanyAddress;
	private String billingCompanyFirstState;
	private String billingCompanySecondState;
	private String shippingName;
	private String shippingAddress;
	private String shippingFirstState;
	private String shippingSecondState;
	
	private double invoiceAmount;

	public InvoiceDetails(String invoiceNo, String billingCompanyName,
			String billingCompanyAddress, String billingCompanyFirstState,
			String billingCompanySecondState, String shippingName,
			String shippingAddress, String shippingFirstState,
			String shippingSecondState, double invoiceAmount) {
		super();
		this.invoiceNo = invoiceNo;
		this.billingCompanyName = billingCompanyName;
		this.billingCompanyAddress = billingCompanyAddress;
		this.billingCompanyFirstState = billingCompanyFirstState;
		this.billingCompanySecondState = billingCompanySecondState;
		this.shippingName = shippingName;
		this.shippingAddress = shippingAddress;
		this.shippingFirstState = shippingFirstState;
		this.shippingSecondState = shippingSecondState;
		this.invoiceAmount = invoiceAmount;
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getBillingCompanyName() {
		return billingCompanyName;
	}

	public void setBillingCompanyName(String billingCompanyName) {
		this.billingCompanyName = billingCompanyName;
	}

	public String getBillingCompanyAddress() {
		return billingCompanyAddress;
	}

	public void setBillingCompanyAddress(String billingCompanyAddress) {
		this.billingCompanyAddress = billingCompanyAddress;
	}

	public String getBillingCompanyFirstState() {
		return billingCompanyFirstState;
	}

	public void setBillingCompanyFirstState(String billingCompanyFirstState) {
		this.billingCompanyFirstState = billingCompanyFirstState;
	}

	public String getBillingCompanySecondState() {
		return billingCompanySecondState;
	}

	public void setBillingCompanySecondState(String billingCompanySecondState) {
		this.billingCompanySecondState = billingCompanySecondState;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingFirstState() {
		return shippingFirstState;
	}

	public void setShippingFirstState(String shippingFirstState) {
		this.shippingFirstState = shippingFirstState;
	}

	public String getShippingSecondState() {
		return shippingSecondState;
	}

	public void setShippingSecondState(String shippingSecondState) {
		this.shippingSecondState = shippingSecondState;
	}
	
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	
	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> objectAsMap = new HashMap<String, Object>();
		try {
		    BeanInfo info = Introspector.getBeanInfo(this.getClass());
		    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
		        Method reader = pd.getReadMethod();
		        if (reader != null)
		            objectAsMap.put(pd.getName(),reader.invoke(this));
		    }
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			//when opps happens
			e.printStackTrace();
		}
	    return objectAsMap;
	}
}
