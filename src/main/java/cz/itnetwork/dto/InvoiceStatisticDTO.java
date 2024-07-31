package cz.itnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceStatisticDTO {

    private Long currentYearSum;
    private Long allTimeSum;
    private Long invoicesCount;



}


