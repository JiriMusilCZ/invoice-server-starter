/*  _____ _______         _                      _
 * |_   _|__   __|       | |                    | |
 *   | |    | |_ __   ___| |___      _____  _ __| | __  ___ ____
 *   | |    | | '_ \ / _ \ __\ \ /\ / / _ \| '__| |/ / / __|_  /
 *  _| |_   | | | | |  __/ |_ \ V  V / (_) | |  |   < | (__ / /
 * |_____|  |_|_| |_|\___|\__| \_/\_/ \___/|_|  |_|\_(_)___/___|
 *                                _
 *              ___ ___ ___ _____|_|_ _ _____
 *             | . |  _| -_|     | | | |     |  LICENCE
 *             |  _|_| |___|_|_|_|_|___|_|_|_|
 *             |_|
 *
 *   PROGRAMOVÁNÍ  <>  DESIGN  <>  PRÁCE/PODNIKÁNÍ  <>  HW A SW
 *
 * Tento zdrojový kód je součástí výukových seriálů na
 * IT sociální síti WWW.ITNETWORK.CZ
 *
 * Kód spadá pod licenci prémiového obsahu a vznikl díky podpoře
 * našich členů. Je určen pouze pro osobní užití a nesmí být šířen.
 * Více informací na http://www.itnetwork.cz/licence
 */
package cz.itnetwork.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.itnetwork.constant.Countries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing a person.
 *
 * <p>This class is used to transfer personal information between different layers of the application.
 * It includes details such as identification numbers, contact information, address, and additional notes.</p>
 *
 * <p>The class uses Lombok annotations to automatically generate getters, setters, and constructors.</p>
 *
 * @version 1.0
 * @since 2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    /**
     * Unique identifier for the person.
     *
     * <p>This field is represented as a long integer and is used to uniquely identify the person.</p>
     */
    @JsonProperty("_id")
    private Long id;

    /**
     * Name of the person.
     *
     * <p>This field represents the full name of the person.</p>
     */
    private String name;

    /**
     * Identification number of the person.
     *
     * <p>This field contains the unique identification number assigned to the person.</p>
     */
    private String identificationNumber;

    /**
     * Tax number of the person.
     *
     * <p>This field holds the tax identification number of the person.</p>
     */
    private String taxNumber;

    /**
     * Bank account number of the person.
     *
     * <p>This field represents the person's bank account number.</p>
     */
    private String accountNumber;

    /**
     * Bank code of the person's bank.
     *
     * <p>This field holds the code of the bank where the person's account is held.</p>
     */
    private String bankCode;

    /**
     * International Bank Account Number (IBAN) of the person.
     *
     * <p>This field contains the IBAN used for international bank transactions.</p>
     */
    private String iban;

    /**
     * Telephone number of the person.
     *
     * <p>This field represents the person's contact telephone number.</p>
     */
    private String telephone;

    /**
     * Email address of the person.
     *
     * <p>This field holds the person's email address.</p>
     */
    private String mail;

    /**
     * Street address of the person.
     *
     * <p>This field contains the street part of the person's address.</p>
     */
    private String street;

    /**
     * ZIP code of the person's address.
     *
     * <p>This field represents the postal ZIP code of the person's address.</p>
     */
    private String zip;

    /**
     * City of the person's address.
     *
     * <p>This field contains the city part of the person's address.</p>
     */
    private String city;

    /**
     * Country of the person's address.
     *
     * <p>This field holds the country where the person resides, represented as an enum {@link Countries}.</p>
     */
    private Countries country;

    /**
     * Additional notes about the person.
     *
     * <p>This field contains any extra information or comments related to the person.</p>
     */
    private String note;
}
