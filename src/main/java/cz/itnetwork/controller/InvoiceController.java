package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/identification/{identificationNumber}/purchases")
    public List<InvoiceTDO> getInvoiceBuyer(@PathVariable String identificationNumber) {
        return invoiceService.getInvoiceBuyer(identificationNumber);
    }

    @GetMapping("/invoices")
    public List<InvoiceTDO> getInvoices(){
        return invoiceService.getInvoices();
    }

}
