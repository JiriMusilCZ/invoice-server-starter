package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceStatisticTDO;
import cz.itnetwork.dto.InvoiceTDO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface InvoiceService {

    InvoiceTDO addInvoice(InvoiceTDO invoiceTDO);

    List<InvoiceTDO> getInvoices();

    InvoiceTDO getInvoiceById(long id);

    ResponseEntity<Void> removeInvoiceById(long id);

    InvoiceTDO updateInvoice(long invoiceId, InvoiceTDO sourceInvoiceTDO);

    InvoiceStatisticTDO getInvoiceStatistics();
}
