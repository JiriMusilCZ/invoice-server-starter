package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceTDO;

import java.util.List;


public interface InvoiceService {

    InvoiceTDO addInvoice(InvoiceTDO invoiceTDO);

    List<InvoiceTDO> getInvoiceBuyer(String identificationNumber);


}
