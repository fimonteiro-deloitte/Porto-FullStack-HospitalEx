package pt.dlt.person.routing;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.dlt.person.exception.NoPatientFoundException;
import pt.dlt.person.exception.PatientCreationException;
import pt.dlt.person.model.dto.PatientRequest;
import pt.dlt.person.model.dto.PatientResponse;
import pt.dlt.person.service.PatientService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patients", description = "Operations related to patients")
public class PatientController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @Operation(
            summary = "Create patient",
            description = "Creates a new patient in the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Patient created successfully",
                            content = @Content(schema = @Schema(implementation = PatientResponse.class))),
                    @ApiResponse(responseCode = "409", description = "Patient creation failed",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public PatientResponse createPatient(@RequestBody @Parameter(description = "Patient data to be created") PatientRequest patientRequestDTO) throws PatientCreationException {
        logger.info("Creating patient: " + patientRequestDTO.name());
        return patientService.createPatient(patientRequestDTO);
    }

    @GetMapping
    @Operation(
            summary = "Get all patients",
            description = "Retrieves a list of all registered patients",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of patients",
                            content = @Content(schema = @Schema(implementation = PatientResponse.class)))
            }
    )
    public List<PatientResponse> getListPatient() {
        logger.info("Fetching all patients");
        return patientService.getListPatients();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get patient by ID",
            description = "Retrieves details of a patient by their ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Patient found",
                            content = @Content(schema = @Schema(implementation = PatientResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Patient not found",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )

    public PatientResponse getPatient(@Parameter(description = "Patient ID", example = "1") @PathVariable Long id) throws NoPatientFoundException {
        logger.info("Fetching patient with ID: " + id);
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update patient",
            description = "Updates the information of an existing patient",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Patient updated successfully",
                            content = @Content(schema = @Schema(implementation = PatientResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Patient not found",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public PatientResponse updatePatient(@Parameter(description = "Patient ID to update", example = "1") @PathVariable Long id,
                                         @RequestBody @Parameter(description = "Updated patient data") PatientRequest patientRequestDTO) throws NoPatientFoundException {
        logger.info("Updating doctor with ID: " + id);
        return patientService.updatePatient(id, patientRequestDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete patient",
            description = "Deletes a patient by their ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Patient deleted successfully",
                            content = @Content(schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "404", description = "Patient not found",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public String deletePatient(@Parameter(description = "Patient ID to delete", example = "1") @PathVariable Long id) throws NoPatientFoundException {
        logger.info("Deleting patient with ID: " + id);
        patientService.deletePatient(id);
        return "Patient with id " + id + " deleted successfully.";
    }
}
