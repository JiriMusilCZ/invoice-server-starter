package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceStatisticTDO;
import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    @PostMapping("/invoices")
    public InvoiceTDO addInvoice(@RequestBody InvoiceTDO invoiceDTO) {
        return invoiceService.addInvoice(invoiceDTO);
    }


    @GetMapping("/invoices")
    public List<InvoiceTDO> getInvoices() {
        return invoiceService.getInvoices();
    }

    @DeleteMapping("/invoices/{invoiceId}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable long invoiceId) {
        return invoiceService.removeInvoiceById(invoiceId);
    }

    @GetMapping("/invoices/{invoiceId}")
    public InvoiceTDO getInvoice(@PathVariable Long invoiceId) {
        return invoiceService.getInvoiceById(invoiceId);
    }

    @PutMapping("/invoices/{invoiceId}")
    public InvoiceTDO updateInvoice(@PathVariable long invoiceId, @RequestBody InvoiceTDO sourceInvoiceTDO) {
        return invoiceService.updateInvoice(invoiceId, sourceInvoiceTDO);
    }

    @GetMapping("/statistics")
    public InvoiceStatisticTDO getStatistics() {
        return invoiceService.getInvoiceStatistics();
    }

}
