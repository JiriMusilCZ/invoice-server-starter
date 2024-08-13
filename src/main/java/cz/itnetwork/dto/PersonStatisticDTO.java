package cz.itnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing statistics related to a person.
 *
 * <p>This class is used to transfer statistical data specific to a person, including the person's ID, name,
 * and revenue generated. It is typically used for aggregating and presenting information about individual
 * persons in various reports or analyses.</p>
 *
 * <p>The class uses Lombok annotations to automatically generate getters, setters, and constructors.</p>
 *
 * @version 1.0
 * @since 2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonStatisticDTO {

    /**
     * Unique identifier for the person.
     *
     * <p>This field represents the unique ID assigned to the person. It is used to identify the person in
     * statistical reports and analyses.</p>
     */
    private Long personId;

    /**
     * Name of the person.
     *
     * <p>This field holds the full name of the person associated with the statistics.</p>
     */
    private String personName;

    /**
     * Revenue generated by the person.
     *
     * <p>This field represents the total revenue generated by the person. It is used to provide insights
     * into the person's financial contributions or performance.</p>
     */
    private Long revenue;

}
