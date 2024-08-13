package cz.itnetwork.entity.filter;

import lombok.Data;

/**
 * Filter criteria for querying invoices.
 *
 * <p>This class is used to encapsulate the filtering criteria for retrieving invoices based on various
 * attributes. It allows for filtering invoices by buyer ID, seller ID, price range, product description,
 * and pagination limits.</p>
 *
 * <p>The class uses Lombok annotations to automatically generate getters, setters, and other common methods.</p>
 *
 * @version 1.0
 * @since 2024
 */
@Data
public class InvoiceFilter {

    /**
     * ID of the buyer associated with the invoices.
     *
     * <p>This field is used to filter invoices based on the ID of the buyer. It is optional and can be null
     * if not used for filtering.</p>
     */
    private Long buyerID;

    /**
     * ID of the seller associated with the invoices.
     *
     * <p>This field is used to filter invoices based on the ID of the seller. It is optional and can be null
     * if not used for filtering.</p>
     */
    private Long sellerID;

    /**
     * Minimum price of the invoices to be retrieved.
     *
     * <p>This field is used to specify the minimum price for filtering invoices. Invoices with a price lower
     * than this value will be excluded. It is optional and can be null if not used for filtering.</p>
     */
    private Integer minPrice;

    /**
     * Maximum price of the invoices to be retrieved.
     *
     * <p>This field is used to specify the maximum price for filtering invoices. Invoices with a price higher
     * than this value will be excluded. It is optional and can be null if not used for filtering.</p>
     */
    private Integer maxPrice;

    /**
     * Product description associated with the invoices.
     *
     * <p>This field is used to filter invoices based on the product description. It can be used to search
     * for invoices related to a specific product. It is optional and can be null if not used for filtering.</p>
     */
    private String product;

    /**
     * Limit for the number of invoices to be retrieved.
     *
     * <p>This field specifies the maximum number of invoices to be returned by the query. It is used for
     * pagination purposes. The default value is 50, but it can be adjusted as needed.</p>
     */
    private Integer limit = 50;
}
