package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.InvoiceTDO;
import cz.itnetwork.entity.InvoiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceTDO toDTO(InvoiceEntity source);
    InvoiceEntity toEntity(InvoiceTDO source);

}
