package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public InvoiceTDO addInvoice(InvoiceTDO invoiceTDO) {
        InvoiceEntity entity = invoiceMapper.toEntity(invoiceTDO);
        entity = invoiceRepository.save(entity);
        PersonEntity buyerEntity = personRepository.getReferenceById(entity.getBuyer().getId());
        entity.setBuyer(buyerEntity);
        PersonEntity sellerEntity = personRepository.getReferenceById(entity.getSeller().getId());
        entity.setSeller(sellerEntity);
        return invoiceMapper.toDTO(entity);
    }


}
