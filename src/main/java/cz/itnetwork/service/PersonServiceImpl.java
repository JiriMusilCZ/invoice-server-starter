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
package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.dto.PersonStatisticDTO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.dto.mapper.PersonMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Implementation of the {@link PersonService} interface.
 * Provides operations for managing person records, including creating, updating, removing, and fetching persons,
 * as well as retrieving associated invoices and statistics.
 *
 * <p>This service interacts with the database through the {@link PersonRepository} and {@link InvoiceRepository}
 * and maps entities to DTOs using {@link PersonMapper} and {@link InvoiceMapper}.</p>
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity entity = personMapper.toEntity(personDTO);
        entity = personRepository.save(entity);

        return personMapper.toDTO(entity);
    }

    @Override
    public void removePerson(long personId) {
        try {
            PersonEntity person = fetchPersonById(personId);
            person.setHidden(true);

            personRepository.save(person);
        } catch (NotFoundException ignored) {
            // The contract in the interface states, that no exception is thrown, if the entity is not found.
        }
    }

    @Override
    public PersonDTO updatePerson(PersonDTO updatedPersonDTO, long personId) {

        PersonEntity oldPersonEntity = fetchPersonById(personId);
        oldPersonEntity.setHidden(true);
        personRepository.save(oldPersonEntity);

        return addPerson(updatedPersonDTO);

    }

    @Override
    public List<PersonDTO> getAll() {
        return personRepository.findByHidden(false)
                .stream()
                .map(i -> personMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    // region: Private methods

    /**
     * <p>Attempts to fetch a person.</p>
     * <p>In case a person with the passed [id] doesn't exist a [{@link org.webjars.NotFoundException}] is thrown.</p>
     *
     * @param id Person to fetch
     * @return Fetched entity
     * @throws org.webjars.NotFoundException In case a person with the passed [id] isn't found
     */
    private PersonEntity fetchPersonById(long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person with id " + id + " wasn't found in the database."));
    }
    // endregion


    @Override
    public PersonDTO getPerson(long id) {
        return personMapper.toDTO(fetchPersonById(id));
    }

    @Override
    public List<InvoiceDTO> getInvoiceBuyer(String identificationNumber) {
        return getInvoicesByPersonType(identificationNumber, true);
    }

    @Override
    public List<InvoiceDTO> getInvoiceSeller(String identificationNumber) {
        return getInvoicesByPersonType(identificationNumber, false);
    }

    /**
     * Retrieves a list of invoices based on the person's identification number and the type of association (buyer or seller).
     *
     * <p>This method consolidates the logic for fetching invoices where a person is either a buyer or a seller,
     * depending on the value of the {@code isBuyer} parameter. The method first retrieves all persons matching
     * the given identification number, then extracts their IDs to query the invoice repository.</p>
     *
     * <p>The method returns a list of {@link InvoiceDTO} objects mapped from the corresponding {@link InvoiceEntity}
     * objects fetched from the database.</p>
     *
     * @param identificationNumber The unique identification number associated with the persons to search for.
     * @param isBuyer              A boolean flag that determines whether to fetch invoices where the person is a buyer or a seller.
     *                             If {@code true}, the method retrieves invoices where the person's ID matches the buyer ID.
     *                             If {@code false}, it retrieves invoices where the person's ID matches the seller ID.
     * @return A list of {@link InvoiceDTO} objects representing the invoices associated with the specified person type.
     * @throws NotFoundException If no persons are found with the given identification number.
     */
    private List<InvoiceDTO> getInvoicesByPersonType(String identificationNumber, boolean isBuyer) {
        List<PersonEntity> persons = personRepository.findByIdentificationNumber(identificationNumber);

        List<Long> personIds = persons.stream()
                .map(PersonEntity::getId)
                .collect(Collectors.toList());

        List<InvoiceEntity> invoices = isBuyer ?
                invoiceRepository.findByBuyerIdIn(personIds) :
                invoiceRepository.findBySellerIdIn(personIds);

        return invoices.stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }




    @Override
    public List<PersonStatisticDTO> getAllPersonStatistics() {
        return personRepository.findPersonRevenue();
    }
}
