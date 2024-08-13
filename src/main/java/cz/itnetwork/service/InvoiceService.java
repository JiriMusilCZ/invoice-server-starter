package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.InvoiceStatisticDTO;
import cz.itnetwork.entity.filter.InvoiceFilter;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Service interface for managing invoices within the system.
 *
 * <p>This interface defines the contract for operations related to invoices, including CRUD operations and statistics retrieval.</p>
 *
 * @version 1.0
 * @since 2024
 */
public interface InvoiceService {

    /**
     * Adds a new invoice to the system.
     *
     * @param invoiceDTO The data transfer object containing the details of the invoice to be added.
     * @return The added invoice as a {@link InvoiceDTO} object.
     */
    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);

    /**
     * Retrieves a list of invoices based on the specified filter criteria.
     *
     * @param invoiceFilter The filter criteria for retrieving invoices, represented by an {@link InvoiceFilter} object.
     * @return A list of invoices matching the filter criteria, each represented as an {@link InvoiceDTO} object.
     */
    List<InvoiceDTO> getInvoices(InvoiceFilter invoiceFilter);

    /**
     * Retrieves a specific invoice by its unique identifier.
     *
     * @param id The unique identifier of the invoice to be retrieved.
     * @return The invoice as an {@link InvoiceDTO} object.
     */
    InvoiceDTO getInvoiceById(long id);

    /**
     * Removes an invoice from the system by its unique identifier.
     *
     * @param id The unique identifier of the invoice to be removed.
     * @return A {@link ResponseEntity} indicating the result of the deletion operation. A {@code 204 NO CONTENT} status is returned on successful deletion.
     */
    ResponseEntity<Void> removeInvoiceById(long id);

    /**
     * Updates an existing invoice with new details.
     *
     * @param invoiceId The unique identifier of the invoice to be updated.
     * @param sourceInvoiceDTO The data transfer object containing the updated details of the invoice.
     * @return The updated invoice as an {@link InvoiceDTO} object.
     */
    InvoiceDTO updateInvoice(long invoiceId, InvoiceDTO sourceInvoiceDTO);

    /**
     * Retrieves invoice statistics including the total amount for the current year, all-time total amount, and count of invoices.
     *
     * @return An {@link InvoiceStatisticDTO} object containing the invoice statistics.
     */
    InvoiceStatisticDTO getInvoiceStatistics();
}
