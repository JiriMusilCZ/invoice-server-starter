package cz.itnetwork.entity.repository;

import cz.itnetwork.dto.InvoiceStatisticTDO;
import cz.itnetwork.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {


    List<InvoiceEntity> findByBuyerIdIn(List<Long> buyerIds);
    List<InvoiceEntity> findBySellerIdIn(List<Long> sellerIds);

    @Query("SELECT new cz.itnetwork.dto.InvoiceStatisticTDO(" +
            "SUM(CASE WHEN YEAR(i.issued) = YEAR(CURRENT_DATE) THEN i.price ELSE 0 END), " +
            "SUM(i.price), " +
            "COUNT(i)) " +
            "FROM invoice i")
    InvoiceStatisticTDO findInvoiceStatistic();
}



