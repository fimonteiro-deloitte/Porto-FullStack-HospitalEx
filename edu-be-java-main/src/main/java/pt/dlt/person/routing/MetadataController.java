package pt.dlt.person.routing;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.dlt.person.model.dto.MetadataResponse;
import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;
import pt.dlt.person.model.ref.Speciality;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/metadata")
@Tag(name = "Metadata", description = "Provides system metadata such as specialities, genders and document types")
public class MetadataController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping
    @Operation(
            summary = "Get metadata",
            description = "Retrieves available metadata values such as doctor specialities, genders, and document types",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Metadata retrieved successfully",
                            content = @Content(schema = @Schema(implementation = MetadataResponse.class)))
            }
    )
    public MetadataResponse getMetadata() {
        logger.info("Fetching metadata: specialities, genders, document types");
        List<Speciality> specialities = Arrays.stream(Speciality.values()).toList();
        List<Gender> genders = Arrays.stream(Gender.values()).toList();
        List<DocumentType> documentTypes = Arrays.stream(DocumentType.values()).toList();

        return new MetadataResponse(specialities, genders, documentTypes);
    }
}
