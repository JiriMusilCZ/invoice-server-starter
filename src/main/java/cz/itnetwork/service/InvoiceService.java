package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.InvoiceStatisticDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface InvoiceService {

    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);

    List<InvoiceDTO> getInvoices();

    InvoiceDTO getInvoiceById(long id);

    ResponseEntity<Void> removeInvoiceById(long id);

    InvoiceDTO updateInvoice(long invoiceId, InvoiceDTO sourceInvoiceDTO);

    InvoiceStatisticDTO getInvoiceStatistics();
}
