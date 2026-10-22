package registroSpeseBackEnd.RegistroSpese.services;

import org.springframework.stereotype.Service;
import registroSpeseBackEnd.RegistroSpese.converters.CurrentAccountConverters;
import registroSpeseBackEnd.RegistroSpese.dtos.CurrentAccountGetDto;
import registroSpeseBackEnd.RegistroSpese.dtos.CurrentAccountCreateDto;
import registroSpeseBackEnd.RegistroSpese.exceptionHandler.AppExceptions;
import registroSpeseBackEnd.RegistroSpese.models.CurrentAccount;
import registroSpeseBackEnd.RegistroSpese.repositories.CurrentAccountRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CurrentAccountService
{
    private CurrentAccountRepository ca;
    private CurrentAccountConverters cac = new CurrentAccountConverters();

    public CurrentAccountService(CurrentAccountRepository ca) { this.ca = ca; }

    public List<CurrentAccountGetDto> getCurrentAccountServices() { return cac.convertCurrentAccountInDto(ca.findAll()); }

    public CurrentAccountGetDto createCurrentAccount(CurrentAccountCreateDto dto)
    {
        if(ca.existsByName(dto.getName()))
            throw new AppExceptions.DuplicateResourceException("Esiste già un Conto Corrente con quel nome");

        CurrentAccount created = new CurrentAccount();
        created.setName(dto.getName());
        ca.save(created);

        return cac.convertCurrentAccountIntoCreationDto(created);
    }

    public CurrentAccountGetDto updateCurrentAccount(long id, CurrentAccountCreateDto dto)
    {
        if(ca.existsByName(dto.getName()))
            throw new AppExceptions.DuplicateResourceException("Esiste già un Conto Corrente con quel nome");

        Optional<CurrentAccount> currentAccountOpt = ca.findById(id);
        if(currentAccountOpt.isEmpty())
            throw new AppExceptions.ResourceNotFoundException("Non è stato trovato nessun Conto Corrente con quell'id");

        CurrentAccount updated = currentAccountOpt.get();
        updated.setName(dto.getName());
        updated.setUpdateDate(LocalDateTime.now());
        ca.save(updated);

        return cac.convertCurrentAccountIntoCreationDto(updated);
    }

    public CurrentAccountGetDto changeActiveCurrentAccount(long id)
    {
        Optional<CurrentAccount> currentAccountOpt = ca.findById(id);
        if(currentAccountOpt.isEmpty())
            throw new AppExceptions.ResourceNotFoundException("Non è stato trovato nessun Conto Corrente con quell'id");

        CurrentAccount activeChanged = currentAccountOpt.get();
        activeChanged.setActive(!activeChanged.isActive());
        activeChanged.setUpdateDate(LocalDateTime.now());
        ca.save(activeChanged);

        return cac.convertCurrentAccountIntoCreationDto(activeChanged);
    }
}
