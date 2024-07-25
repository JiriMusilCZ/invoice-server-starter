package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceTDO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface InvoiceService {

    InvoiceTDO addInvoice(InvoiceTDO invoiceTDO);

    List<InvoiceTDO> getInvoices();

    InvoiceTDO getInvoice(long id);

    ResponseEntity<Void> removeInvoiceById(long id);
}
