package cz.itnetwork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) representing an invoice.
 *
 * <p>This class is used to transfer invoice data between different layers of the application. It includes
 * information about the invoice, such as its unique identifier, invoice number, issue and due dates,
 * product details, pricing, VAT, notes, and related persons (buyer and seller).</p>
 *
 * <p>The class uses Lombok annotations to automatically generate getters, setters, and constructors.</p>
 *
 * @version 1.0
 * @since 2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {

    /**
     * Unique identifier for the invoice.
     *
     * <p>This field is represented as a long integer and is used to uniquely identify the invoice.</p>
     */
    @JsonProperty("_id")
    private Long id;

    /**
     * Invoice number.
     *
     * <p>This field represents the number assigned to the invoice for identification purposes.</p>
     */
    private int invoiceNumber;

    /**
     * Date when the invoice was issued.
     *
     * <p>This field represents the date on which the invoice was issued, formatted as "yyyy-MM-dd".</p>
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate issued;

    /**
     * Due date for the invoice payment.
     *
     * <p>This field represents the date by which the invoice payment is due, formatted as "yyyy-MM-dd".</p>
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    /**
     * Description of the product or service invoiced.
     *
     * <p>This field contains a brief description of the product or service related to the invoice.</p>
     */
    private String product;

    /**
     * Price of the product or service.
     *
     * <p>This field represents the amount charged for the product or service in the invoice.</p>
     */
    private long price;

    /**
     * Value Added Tax (VAT) rate applied to the invoice.
     *
     * <p>This field represents the VAT rate applied to the invoice as a percentage.</p>
     */
    private int vat;

    /**
     * Additional notes or comments related to the invoice.
     *
     * <p>This field contains any additional information or comments related to the invoice.</p>
     */
    private String note;

    /**
     * PersonDTO representing the buyer of the product or service.
     *
     * <p>This field holds the information about the person who is buying the product or service, represented
     * as a {@link PersonDTO} object.</p>
     */
    private PersonDTO buyer;

    /**
     * PersonDTO representing the seller of the product or service.
     *
     * <p>This field holds the information about the person who is selling the product or service, represented
     * as a {@link PersonDTO} object.</p>
     */
    private PersonDTO seller;

}
