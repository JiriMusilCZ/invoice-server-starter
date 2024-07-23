package cz.itnetwork.entity.repository;

import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    List<InvoiceEntity> findByBuyer (Long buyerId);
    List<InvoiceEntity> findByBuyerIdIn(List<Long> buyerIds);


}
