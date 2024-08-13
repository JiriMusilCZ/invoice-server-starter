package cz.itnetwork.entity.repository;

import cz.itnetwork.dto.InvoiceStatisticDTO;
import cz.itnetwork.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for performing CRUD operations and custom queries on {@link InvoiceEntity}.
 *
 * <p>This interface extends {@link JpaRepository} to provide standard CRUD operations and
 * {@link JpaSpecificationExecutor} to support querying using JPA Specifications. It includes additional
 * custom methods for finding invoices based on buyer and seller IDs, as well as for retrieving aggregated
 * invoice statistics.</p>
 *
 * @version 1.0
 * @since 2024
 */
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long>, JpaSpecificationExecutor<InvoiceEntity> {

    /**
     * Finds invoices where the buyer's ID is in the provided list of buyer IDs.
     *
     * @param buyerIds a list of buyer IDs to filter invoices by
     * @return a list of {@link InvoiceEntity} instances that match the provided buyer IDs
     */
    List<InvoiceEntity> findByBuyerIdIn(List<Long> buyerIds);

    /**
     * Finds invoices where the seller's ID is in the provided list of seller IDs.
     *
     * @param sellerIds a list of seller IDs to filter invoices by
     * @return a list of {@link InvoiceEntity} instances that match the provided seller IDs
     */
    List<InvoiceEntity> findBySellerIdIn(List<Long> sellerIds);

    /**
     * Retrieves aggregated statistics for invoices.
     *
     * <p>This query calculates the total sum of invoices for the current year, the total sum of all invoices,
     * and the total count of invoices. The result is returned as an instance of {@link InvoiceStatisticDTO}.</p>
     *
     * @return an {@link InvoiceStatisticDTO} containing the aggregated invoice statistics
     */
    @Query("SELECT new cz.itnetwork.dto.InvoiceStatisticDTO(" +
            "SUM(CASE WHEN YEAR(i.issued) = YEAR(CURRENT_DATE) THEN i.price ELSE 0 END), " +
            "SUM(i.price), " +
            "COUNT(i)) " +
            "FROM invoice i")
    InvoiceStatisticDTO findInvoiceStatistic();
}



