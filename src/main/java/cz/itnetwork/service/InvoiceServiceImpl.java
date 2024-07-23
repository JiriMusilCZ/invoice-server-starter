package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        InvoiceEntity invoiceEntity = invoiceMapper.toEntity(invoiceTDO);
        invoiceEntity = invoiceRepository.save(invoiceEntity);
        PersonEntity buyerEntity = personRepository.getReferenceById(invoiceEntity.getBuyer().getId());
        invoiceEntity.setBuyer(buyerEntity);
        PersonEntity sellerEntity = personRepository.getReferenceById(invoiceEntity.getSeller().getId());
        invoiceEntity.setSeller(sellerEntity);
        return invoiceMapper.toDTO(invoiceEntity);
    }

    public List<InvoiceTDO> getInvoiceBuyer(String identificationNumber) {
        List<PersonEntity> persons = personRepository.findByIdentificationNumber(identificationNumber);
// Extract IDs from PersonEntity objects
        List<Long> personIds = persons.stream()
                .map(PersonEntity::getId)
                .collect(Collectors.toList());

        // Find all invoices where the buyer_id matches any of the IDs in personIds
        List<InvoiceEntity> invoices = invoiceRepository.findByBuyerIdIn(personIds);

        // Map the InvoiceEntity objects to InvoiceDTO
        return invoices.stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<InvoiceTDO> getInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceEntity -> invoiceMapper.toDTO(invoiceEntity))
                .collect(Collectors.toList());
    }

}
