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
import pt.dlt.person.exception.DoctorCreationException;
import pt.dlt.person.model.dto.DoctorRequest;
import pt.dlt.person.model.dto.DoctorResponse;
import pt.dlt.person.model.ref.Speciality;
import pt.dlt.person.exception.NoDoctorFoundException;
import pt.dlt.person.service.DoctorService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/doctors")
@Tag(name = "Doctors", description = "Operations related to doctors")
public class DoctorController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    @Operation(
            summary = "Create doctor",
            description = "Creates a new doctor in the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Doctor created successfully",
                            content = @Content(schema = @Schema(implementation = DoctorResponse.class))),
                    @ApiResponse(responseCode = "409", description = "Doctor creation failed",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public DoctorResponse createDoctor(@RequestBody @Parameter(description = "Doctor data to be created") DoctorRequest doctorRequestDTO) throws DoctorCreationException {
        logger.info("Creating doctor: " + doctorRequestDTO.name());
        return doctorService.createDoctor(doctorRequestDTO);
    }

    @GetMapping
    @Operation(
            summary = "Get all doctors",
            description = "Retrieves a list of all doctors",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of doctors",
                            content = @Content(schema = @Schema(implementation = DoctorResponse.class)))
            }
    )
    public List<DoctorResponse> getListDoctors() {
        logger.info("Fetching all doctors");
        return doctorService.getListDoctors();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get doctor by ID",
            description = "Retrieves details of a doctor by their ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Doctor found",
                            content = @Content(schema = @Schema(implementation = DoctorResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Doctor not found",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public DoctorResponse getDoctor(@Parameter(description = "Doctor ID", example = "1") @PathVariable Long id) throws NoDoctorFoundException {
        logger.info("Fetching doctor with ID: " + id);
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/speciality/{speciality}")
    @Operation(
            summary = "Get doctors by speciality",
            description = "Retrieves all doctors with the given speciality",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Doctors found",
                            content = @Content(schema = @Schema(implementation = DoctorResponse.class)))
            }
    )
    public List<DoctorResponse> getDoctorsBySpecialty(@Parameter(description = "Doctor speciality", example = "DERMATOLOGY") @PathVariable Speciality speciality) {
        logger.info("Fetching doctors with speciality: " + speciality);
        return doctorService.getDoctorsBySpeciality(speciality);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update doctor",
            description = "Updates information of an existing doctor",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Doctor updated successfully",
                            content = @Content(schema = @Schema(implementation = DoctorResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Doctor not found",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public DoctorResponse updateDoctor(@Parameter(description = "Doctor ID to update", example = "1") @PathVariable Long id,
                                       @RequestBody @Parameter(description = "Updated doctor data") DoctorRequest doctorRequestDTO) throws NoDoctorFoundException {
        logger.info("Updating doctor with ID: " + id);
        return doctorService.updateDoctor(id, doctorRequestDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete doctor",
            description = "Deletes a doctor by their ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Doctor deleted successfully",
                            content = @Content(schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "404", description = "Doctor not found",
                            content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public String deleteDoctor(@Parameter(description = "Doctor ID to delete", example = "1") @PathVariable Long id) throws NoDoctorFoundException {
        logger.info("Deleting doctor with ID: " + id);
        doctorService.deleteDoctor(id);
        return "Doctor with id " + id + " deleted successfully.";
    }
}
