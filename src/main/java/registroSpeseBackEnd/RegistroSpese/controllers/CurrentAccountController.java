package registroSpeseBackEnd.RegistroSpese.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registroSpeseBackEnd.RegistroSpese.dtos.CurrentAccountGetDto;
import registroSpeseBackEnd.RegistroSpese.dtos.CurrentAccountCreateDto;
import registroSpeseBackEnd.RegistroSpese.dtos.ErrorResponseDto;
import registroSpeseBackEnd.RegistroSpese.services.CurrentAccountService;

import java.util.List;

@RestController
@RequestMapping("CurrentAccount")
@Tag(name = "Conti Correnti", description = "Endpoint per la gestioni dei Conti Correnti (CC)")
public class CurrentAccountController
{
    private CurrentAccountService caService;

    public CurrentAccountController(CurrentAccountService caService) { this.caService = caService; }

    @GetMapping
    @Operation(summary = "Ottieni lista dei CC", description = "Ritorna tutti i dati dei CC")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "CC trovato/i o inesistente/i",
                    content = @Content(schema = @Schema(implementation = CurrentAccountGetDto.class))
            )
    })
    public ResponseEntity<List<CurrentAccountGetDto>> getCurrentAccounts() { return ResponseEntity.ok(caService.getCurrentAccountServices()); }

    @PostMapping
    @Operation(summary = "Inserisci un nuovo CC", description = "Crea un nuovo ContoCorrente")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "CC creato con successo",
                    content = @Content(schema = @Schema(implementation = CurrentAccountCreateDto.class))
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Un CC con quel nome esiste già",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Errore Interno del Server",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<CurrentAccountGetDto> createCurrentAccount(@RequestBody CurrentAccountCreateDto dto)
    {
        return ResponseEntity.ok(caService.createCurrentAccount(dto));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Aggiorna un CC", description = "Aggiorna un CC attraverso il suo id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "CC aggiornato con successo",
                            content = @Content(schema = @Schema(implementation = CurrentAccountCreateDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Un CC con quel nome esiste già",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))

                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "id CC non trovato",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Errore Interno del Server",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )
                    )
            }
    )
    public ResponseEntity<CurrentAccountGetDto> updateCurrentAccount(@PathVariable long id, @RequestBody CurrentAccountCreateDto dto)
    {
        return ResponseEntity.ok(caService.updateCurrentAccount(id, dto));
    }

    @PatchMapping("/changeActive/{id}")
    @Operation(summary = "Modifica il valore di attivo o disattivo di un CC", description = "Modifica il Active un CC attraverso il suo id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "CC aggiornato con successo",
                            content = @Content(schema = @Schema(implementation = CurrentAccountCreateDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "id CC non trovato",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Errore Interno del Server",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )
                    )
            }
    )
    public ResponseEntity<CurrentAccountGetDto> changeActiveCurrentAccount(@PathVariable long id)
    {
        return ResponseEntity.ok(caService.changeActiveCurrentAccount(id));
    }
}