package cz.itnetwork.entity.repository;

import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {




}
