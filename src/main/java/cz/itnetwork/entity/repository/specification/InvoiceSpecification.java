package cz.itnetwork.entity.repository.specification;

import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.InvoiceEntity_;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.PersonEntity_;
import cz.itnetwork.entity.filter.InvoiceFilter;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Specification for querying {@link InvoiceEntity} entities based on various filtering criteria.
 *
 * <p>This class implements the {@link Specification} interface to provide custom query logic for filtering
 * invoices. It translates the filter criteria specified in {@link InvoiceFilter} into JPA Criteria API
 * predicates, which are used to construct a dynamic query for invoice entities.</p>
 *
 * <p>The class is annotated with {@link RequiredArgsConstructor} to automatically generate a constructor
 * that initializes the {@link #filter} field.</p>
 *
 * @version 1.0
 * @since 2024
 */
@RequiredArgsConstructor
public class InvoiceSpecification implements Specification<InvoiceEntity> {

    /**
     * The filter criteria used for querying invoices.
     *
     * <p>This field holds the {@link InvoiceFilter} object containing the criteria to filter invoices.</p>
     */
    private final InvoiceFilter filter;

    /**
     * Creates a {@link Predicate} based on the filter criteria to be used in the query.
     *
     * @param root            the root of the query, representing the {@link InvoiceEntity}
     * @param criteriaQuery   the criteria query
     * @param criteriaBuilder the criteria builder used to construct {@link Predicate}s
     * @return a {@link Predicate} representing the query conditions based on the filter criteria
     */
    @Override
    public Predicate toPredicate(Root<InvoiceEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        // Filter by seller ID if provided
        if (filter.getSellerID() != null) {
            Join<InvoiceEntity, PersonEntity> sellerJoin = root.join(InvoiceEntity_.SELLER);
            predicates.add(criteriaBuilder.equal(sellerJoin.get(PersonEntity_.ID), filter.getSellerID()));
        }

        // Filter by buyer ID if provided
        if (filter.getBuyerID() != null) {
            Join<InvoiceEntity, PersonEntity> buyerJoin = root.join(InvoiceEntity_.BUYER);
            predicates.add(criteriaBuilder.equal(buyerJoin.get(PersonEntity_.ID), filter.getBuyerID()));
        }

        // Filter by maximum price if provided
        if (filter.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(InvoiceEntity_.PRICE), filter.getMaxPrice()));
        }

        // Filter by minimum price if provided
        if (filter.getMinPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(InvoiceEntity_.PRICE), filter.getMinPrice()));
        }

        // Filter by product description if provided
        if (filter.getProduct() != null) {
            predicates.add(criteriaBuilder.like(root.get(InvoiceEntity_.PRODUCT), "%" + filter.getProduct() + "%"));
        }

        // Combine all predicates using AND logical operator
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
