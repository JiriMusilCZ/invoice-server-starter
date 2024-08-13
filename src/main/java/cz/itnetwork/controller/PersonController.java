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
package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.dto.PersonStatisticDTO;
import cz.itnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing persons. Provides REST API endpoints for operations related to persons.
 *
 * <p>Provides the following services:</p>
 * <ul>
 *     <li>Adding a new person</li>
 *     <li>Retrieving a list of all persons</li>
 *     <li>Deleting a person by ID</li>
 *     <li>Retrieving a person by ID</li>
 *     <li>Updating a person by ID</li>
 *     <li>Retrieving invoices associated with a person (buyer or seller)</li>
 *     <li>Retrieving statistics about persons</li>
 * </ul>
 *
 * @version 1.0
 * @since 2024
 */
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * Adds a new person.
     *
     * <p>Creates a new person based on the provided data. The input data should be in JSON format corresponding to {@link PersonDTO}.</p>
     *
     * @param personDTO object containing the details of the person to be added
     * @return the added person as {@link PersonDTO}
     */
    @PostMapping("/persons")
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return  personService.addPerson(personDTO);
    }

    /**
     * Retrieves a list of all persons.
     *
     * <p>Returns a list of all persons in the system, represented as a list of {@link PersonDTO} objects.</p>
     *
     * @return a list of all persons as {@link List}<{@link PersonDTO}>
     */
    @GetMapping("/persons")
    public List<PersonDTO> getPersons() {
        return personService.getAll();
    }

    /**
     * Deletes a person by ID.
     *
     * <p>Deletes the person with the specified ID. If the person with this ID does not exist, no action is taken.</p>
     *
     * @param personId ID of the person to be deleted
     */
    @DeleteMapping("/persons/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personService.removePerson(personId);
    }

    /**
     * Retrieves a person by ID.
     *
     * <p>Returns detailed information about the person with the specified ID. If the person with this ID does not exist, an appropriate error response is returned.</p>
     *
     * @param personId ID of the person to be retrieved
     * @return the person as {@link PersonDTO}
     */
    @GetMapping("/persons/{personId}")
    public PersonDTO getPerson(@PathVariable Long personId){
        return personService.getPerson(personId);
    }

    /**
     * Updates a person by ID.
     *
     * <p>Updates the existing person with the specified ID based on the new data provided in {@link PersonDTO}. If the person with this ID does not exist, an appropriate error response is returned.</p>
     *
     * @param personId ID of the person to be updated
     * @param personDTO object containing the updated details of the person
     * @return the updated person as {@link PersonDTO}
     */
    @PutMapping({"/persons/{personId}"})
    public PersonDTO updatePerson(@PathVariable Long personId, @RequestBody PersonDTO personDTO) {
        return personService.updatePerson(personDTO, personId);
    }

    /**
     * Retrieves invoices associated with a person as a buyer based on their identification number.
     *
     * <p>Returns a list of invoices where the person is listed as the buyer. The invoices are represented as a list of {@link InvoiceDTO} objects.</p>
     *
     * @param identificationNumber identification number of the person
     * @return a list of invoices as {@link List}<{@link InvoiceDTO}>
     */
    @GetMapping("/identification/{identificationNumber}/purchases")
    public List<InvoiceDTO> getInvoiceBuyer(@PathVariable String identificationNumber) {
        return personService.getInvoiceBuyer(identificationNumber);
    }

    /**
     * Retrieves invoices associated with a person as a seller based on their identification number.
     *
     * <p>Returns a list of invoices where the person is listed as the seller. The invoices are represented as a list of {@link InvoiceDTO} objects.</p>
     *
     * @param identificationNumber identification number of the person
     * @return a list of invoices as {@link List}<{@link InvoiceDTO}>
     */
    @GetMapping("/identification/{identificationNumber}/sales")
    public List<InvoiceDTO> getInvoiceSeller(@PathVariable String identificationNumber) {
        return personService.getInvoiceSeller(identificationNumber);
    }

    /**
     * Retrieves statistics about persons.
     *
     * <p>Returns statistical data about persons, such as totals or other metrics, represented as a list of {@link PersonStatisticDTO} objects.</p>
     *
     * @return a list of person statistics as {@link List}<{@link PersonStatisticDTO}>
     */
    @GetMapping("/persons/statistics")
    public List<PersonStatisticDTO> getPersonStatistics() {
        return personService.getAllPersonStatistics();
    }
}
