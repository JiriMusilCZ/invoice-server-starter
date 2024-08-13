package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.InvoiceStatisticDTO;
import cz.itnetwork.entity.filter.InvoiceFilter;
import cz.itnetwork.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing invoices. Provides REST API endpoints for operations related to invoices.
 *
 * <p>Provides the following services:</p>
 * <ul>
 *     <li>Creating a new invoice</li>
 *     <li>Listing all invoices or filtered invoices</li>
 *     <li>Deleting an invoice by ID</li>
 *     <li>Retrieving an invoice by ID</li>
 *     <li>Updating an invoice by ID</li>
 *     <li>Retrieving invoice statistics</li>
 * </ul>
 *
 * @version 1.0
 * @since 2024
 */
@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    /**
     * Adds a new invoice.
     *
     * <p>Creates a new invoice based on the provided data. The input data should be in JSON format corresponding to {@link InvoiceDTO}.</p>
     *
     * @param invoiceDTO object containing the invoice details to be added
     * @return the added invoice as {@link InvoiceDTO}
     */
    @PostMapping("/invoices")
    public InvoiceDTO addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.addInvoice(invoiceDTO);
    }

    /**
     * Retrieves a list of invoices based on the provided filter.
     *
     * <p>Returns a list of invoices that match the filters specified in {@link InvoiceFilter}. The filter may contain various search criteria.</p>
     *
     * @param invoiceFilter object for filtering invoices
     * @return a list of invoices as {@link List}<{@link InvoiceDTO}>
     */
    @GetMapping("/invoices")
    public List<InvoiceDTO> getInvoices(InvoiceFilter invoiceFilter) {
        return invoiceService.getInvoices(invoiceFilter);
    }

    /**
     * Deletes an invoice by its ID.
     *
     * <p>Deletes the invoice with the specified ID. If no invoice with this ID exists, it returns an HTTP status code 404 (Not Found).</p>
     *
     * @param invoiceId ID of the invoice to be deleted
     * @return response with HTTP status code
     */
    @DeleteMapping("/invoices/{invoiceId}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable long invoiceId) {
        return invoiceService.removeInvoiceById(invoiceId);
    }

    /**
     * Retrieves an invoice by its ID.
     *
     * <p>Returns detailed information about the invoice with the specified ID. If no invoice with this ID exists, it returns an HTTP status code 404 (Not Found).</p>
     *
     * @param invoiceId ID of the invoice to be retrieved
     * @return the invoice as {@link InvoiceDTO}
     */
    @GetMapping("/invoices/{invoiceId}")
    public InvoiceDTO getInvoice(@PathVariable Long invoiceId) {
        return invoiceService.getInvoiceById(invoiceId);
    }

    /**
     * Updates an invoice by its ID.
     *
     * <p>Updates the existing invoice with the specified ID based on the new data provided in {@link InvoiceDTO}. If no invoice with this ID exists, it returns an HTTP status code 404 (Not Found).</p>
     *
     * @param invoiceId ID of the invoice to be updated
     * @param sourceInvoiceDTO object containing the new invoice details
     * @return the updated invoice as {@link InvoiceDTO}
     */
    @PutMapping("/invoices/{invoiceId}")
    public InvoiceDTO updateInvoice(@PathVariable long invoiceId, @RequestBody InvoiceDTO sourceInvoiceDTO) {
        return invoiceService.updateInvoice(invoiceId, sourceInvoiceDTO);
    }

    /**
     * Retrieves statistics about invoices.
     *
     * <p>Returns statistics about invoices, such as the total number of invoices, total amounts, etc., processed in the format of {@link InvoiceStatisticDTO}.</p>
     *
     * @return invoice statistics as {@link InvoiceStatisticDTO}
     */
    @GetMapping("/invoices/statistics")
    public InvoiceStatisticDTO getStatistics() {
        return invoiceService.getInvoiceStatistics();
    }

}
