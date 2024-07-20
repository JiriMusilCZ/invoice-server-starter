package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InvoiceContoller {

    @Autowired
    private InvoiceService invoiceService;


    @PostMapping("/invoices")
    public InvoiceTDO addInvoice(@RequestBody InvoiceTDO invoiceDTO) {
        return invoiceService.addInvoice(invoiceDTO);
    }


}
