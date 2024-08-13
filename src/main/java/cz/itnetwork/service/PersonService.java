package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.dto.PersonStatisticDTO;

import java.util.List;

/**
 * Provides operations for managing person records and retrieving associated data.
 */
public interface PersonService {

    /**
     * Creates a new person
     *
     * @param personDTO Person to create
     * @return newly created person
     */
    PersonDTO addPerson(PersonDTO personDTO);

    /**
     * <p>Sets hidden flag to true for the person with the matching [id]</p>
     * <p>In case a person with the passed [id] isn't found, the method <b>silently fails</b></p>
     *
     * @param id Person to delete
     */
    void removePerson(long id);

    /**
     * Fetches all non-hidden persons
     *
     * @return List of all non-hidden persons
     */
    List<PersonDTO> getAll();

    /**
     * Fetches a person by their ID.
     *
     * @param id The ID of the person to fetch.
     * @return The fetched person as a {@link PersonDTO}.
     * @throws org.webjars.NotFoundException If a person with the given ID is not found.
     */
    PersonDTO getPerson(long id);

    /**
     * Updates the person record with the given ID.
     * <p>
     * The existing person record is marked as hidden, and a new person record is created
     * with the updated details.
     * </p>
     *
     * @param updatedPersonDTO The updated person details.
     * @param personId The ID of the person to update.
     * @return The updated person as a {@link PersonDTO}.
     */
    PersonDTO updatePerson(PersonDTO updatedPersonDTO, long personId);

    /**
     * Retrieves invoices where the specified identification number corresponds to the buyer.
     *
     * @param identificationNumber The identification number to match with buyers.
     * @return A list of invoices where the person with the specified identification number is the buyer.
     */
    List<InvoiceDTO> getInvoiceBuyer(String identificationNumber);

    /**
     * Retrieves invoices where the specified identification number corresponds to the seller.
     *
     * @param identificationNumber The identification number to match with sellers.
     * @return A list of invoices where the person with the specified identification number is the seller.
     */
    List<InvoiceDTO> getInvoiceSeller(String identificationNumber);

    /**
     * Retrieves all person-related statistics, such as revenue.
     *
     * @return A list of person statistics as {@link PersonStatisticDTO} objects.
     */
    List<PersonStatisticDTO> getAllPersonStatistics();
}
