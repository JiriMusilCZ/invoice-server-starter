package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.entity.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceTDO toDTO(InvoiceEntity source);

    InvoiceEntity toEntity(InvoiceTDO source);

    @Mapping(target = "buyer", ignore = true)
    @Mapping(target = "seller", ignore = true)
    InvoiceEntity updateInvoiceEntity(InvoiceTDO source, @MappingTarget InvoiceEntity target);
}
