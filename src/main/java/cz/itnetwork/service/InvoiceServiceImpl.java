package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.InvoiceStatisticDTO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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
    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        InvoiceEntity invoiceEntity = invoiceMapper.toEntity(invoiceDTO);
        invoiceEntity = invoiceRepository.save(invoiceEntity);
        PersonEntity buyerEntity = personRepository.getReferenceById(invoiceEntity.getBuyer().getId());
        invoiceEntity.setBuyer(buyerEntity);
        PersonEntity sellerEntity = personRepository.getReferenceById(invoiceEntity.getSeller().getId());
        invoiceEntity.setSeller(sellerEntity);
        return invoiceMapper.toDTO(invoiceEntity);
    }

    public List<InvoiceDTO> getInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceEntity -> invoiceMapper.toDTO(invoiceEntity))
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDTO getInvoiceById(long id) {
        InvoiceEntity invoiceEntity = fetchInvoiceById(id); // Používáme fetchInvoiceById
        return invoiceMapper.toDTO(invoiceEntity);
    }

    @Override
    public ResponseEntity<Void> removeInvoiceById(long id) {
            InvoiceEntity fetchedInvoice = fetchInvoiceById(id);
            invoiceRepository.delete(fetchedInvoice);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Stav 204

    }


    private InvoiceEntity fetchInvoiceById(long id){
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invoice with id" + id + "wasn't found in the database."));
    }

    @Override
    public InvoiceDTO updateInvoice(long id, InvoiceDTO sourceInvoiceDTO) {

        InvoiceEntity targetInvoiceEntity = fetchInvoiceById(id);

        sourceInvoiceDTO.setId(id);

        invoiceMapper.updateInvoiceEntity(sourceInvoiceDTO, targetInvoiceEntity);

        targetInvoiceEntity.setBuyer(personRepository.getReferenceById(sourceInvoiceDTO.getBuyer().getId()));
        targetInvoiceEntity.setSeller(personRepository.getReferenceById(sourceInvoiceDTO.getSeller().getId()));
        InvoiceEntity savedInvoiceEntity = invoiceRepository.save(targetInvoiceEntity);
        return invoiceMapper.toDTO(savedInvoiceEntity);

    }

    @Override
    public InvoiceStatisticDTO getInvoiceStatistics() {
        return invoiceRepository.findInvoiceStatistic();
    }

}
