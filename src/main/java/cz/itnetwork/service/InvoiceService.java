package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.InvoiceStatisticDTO;
import cz.itnetwork.entity.filter.InvoiceFilter;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface InvoiceService {

    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);

    List<InvoiceDTO> getInvoices(InvoiceFilter invoiceFilter);

    InvoiceDTO getInvoiceById(long id);

    ResponseEntity<Void> removeInvoiceById(long id);

    InvoiceDTO updateInvoice(long invoiceId, InvoiceDTO sourceInvoiceDTO);

    InvoiceStatisticDTO getInvoiceStatistics();
}
