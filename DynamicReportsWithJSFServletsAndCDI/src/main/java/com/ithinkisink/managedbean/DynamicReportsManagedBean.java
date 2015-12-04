package com.ithinkisink.managedbean;

import static net.sf.dynamicreports.report.builder.DynamicReports.report;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;

import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.ithinkisink.model.InvoiceDetails;
import com.ithinkisink.model.Item;

/**
 * 
 * @author Belal
 *
 */
@Named
@SessionScoped
public class DynamicReportsManagedBean implements Serializable {

	private static final long serialVersionUID = -1;

	private String invoiceName;
	private JRBeanCollectionDataSource beanCollectionDataSource;
	private Map<String, Object> parameters;

	@PostConstruct
	public void init() {
		invoiceName="Invoice.jrxml";
		
		List<Item> itemList = new ArrayList<>(Arrays.asList(
				new Item("01", "Item 01 description", 1.1, 1), 
				new Item("02", "Item 02 description", 2.2, 2),
				new Item("03", "Item 03 description", 3.3, 3)));
		beanCollectionDataSource = new JRBeanCollectionDataSource(itemList);
		
		parameters = (new InvoiceDetails("INV#01", "Billing Company", "Billing Company Add", 
				"Billing Company State 1", "Billing Company State 2", 
				"Shipping Name", "Shipping Address", "Shipping State 1", "Shipping State 2", 1000)).toMap();
	}
	
	/**
	 * Preparing an output stream of the generated PDF invoice.
	 * 
	 * @return
	 */
	public OutputStream getOS(ServletContext context, OutputStream outputStream) {

		parameters.put("IMAGE_PATH", context.getRealPath("/jasper/invoices"));

		InputStream is = context.getResourceAsStream("/jasper/invoices/" + invoiceName);

		try {
			report().setTemplateDesign(is)
					.setDataSource(beanCollectionDataSource)
					.setParameters(parameters).toPdf(outputStream);
		} catch (DRException e) {
			e.printStackTrace();
		}

		return outputStream;
	}

	// setters and getters
	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public JRBeanCollectionDataSource getBeanCollectionDataSource() {
		return beanCollectionDataSource;
	}

	public void setBeanCollectionDataSource(
			JRBeanCollectionDataSource beanCollectionDataSource) {
		this.beanCollectionDataSource = beanCollectionDataSource;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}
}
