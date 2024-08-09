package cz.itnetwork.entity.filter;

import lombok.Data;

@Data
public class InvoiceFilter {

    private Integer buyerID;
    private Integer sellerID;
    private Integer minPrice;
    private Integer maxPrice;
    private String product;
    private Integer limit = 10;
}
