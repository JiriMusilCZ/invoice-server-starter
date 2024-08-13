package cz.itnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing invoice statistics.
 *
 * <p>This class is used to transfer aggregated statistical data related to invoices, including the total
 * sum of invoices for the current year, the all-time total sum of invoices, and the total count of invoices.</p>
 *
 * <p>The class uses Lombok annotations to automatically generate getters, setters, and constructors.</p>
 *
 * @version 1.0
 * @since 2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceStatisticDTO {

    /**
     * Total sum of invoices for the current year.
     *
     * <p>This field represents the aggregated total amount of invoices issued in the current year.</p>
     */
    private Long currentYearSum;

    /**
     * Total sum of all-time invoices.
     *
     * <p>This field represents the aggregated total amount of all invoices issued across all time periods.</p>
     */
    private Long allTimeSum;

    /**
     * Total count of invoices.
     *
     * <p>This field represents the total number of invoices issued across all time periods.</p>
     */
    private Long invoicesCount;

}


