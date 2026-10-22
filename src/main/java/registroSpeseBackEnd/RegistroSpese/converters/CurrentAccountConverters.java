package registroSpeseBackEnd.RegistroSpese.converters;

import registroSpeseBackEnd.RegistroSpese.dtos.CurrentAccountCreateDto;
import registroSpeseBackEnd.RegistroSpese.dtos.CurrentAccountGetDto;
import registroSpeseBackEnd.RegistroSpese.models.CurrentAccount;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccountConverters
{
    public List<CurrentAccountGetDto> convertCurrentAccountInDto(List<CurrentAccount> ca)
    {
        List<CurrentAccountGetDto> convertedCa = new ArrayList<>();

        // Uso un foreach
        for(CurrentAccount caCopy: ca)
        {
            CurrentAccountGetDto dto = new CurrentAccountGetDto();
            dto.setName(caCopy.getName());
            dto.setActive(caCopy.isActive());

            convertedCa.add(dto);
        }

        return convertedCa;
    }

    public CurrentAccountGetDto convertCurrentAccountIntoCreationDto(CurrentAccount ca)
    {
        CurrentAccountGetDto convertedCa = new CurrentAccountGetDto();

        convertedCa.setName(ca.getName());
        convertedCa.setActive(ca.isActive());

        return convertedCa;
    }
}
