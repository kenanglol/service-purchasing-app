package com.micro.ege.advert.advertservice.api;

import com.micro.ege.advert.advertservice.api.model.*;
import com.micro.ege.advert.advertservice.service.AdvertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Tag(name = "Service Advert Microservice")
@RequestMapping("/api/advert")
public class AdvertController {
    private final AdvertService advertService;
    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @Operation(summary = "Create Advert",description = "Create Advert")
    @ApiResponse(responseCode = "201", description = "Create Advert Response")
    @PostMapping(path = "/create")
    public ResponseEntity<ManipulationResponse> createAdvert(
            @Valid
            @Parameter(description = "Request object for create",required = true)
            @RequestBody CreateAdvertRequest createAdvertRequest) {
        return new ResponseEntity<>(advertService.createAdvert(createAdvertRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Advert",description = "Update Advert")
    @ApiResponse(responseCode = "200", description = "Update Advert Response")
    @PutMapping(path = "/update")
    public ResponseEntity<ManipulationResponse> updateAdvert(
            @Parameter(description = "Request object for update",required = true)
            @RequestBody UpdateAdvertRequest updateAdvertRequest) {
        return new ResponseEntity<>(advertService.updateAdvert(updateAdvertRequest), HttpStatus.OK);
    }

    @Operation(summary = "Delete Advert",description = "Delete Advert")
    @ApiResponse(responseCode = "200", description = "Delete Advert Response")
    @DeleteMapping(path = "/delete")
    public ResponseEntity<ManipulationResponse> deleteAdvert(
            @Parameter(description = "Request object for delete",required = true)
            @RequestBody DeleteAdvertRequest deleteAdvertRequest) {
        return new ResponseEntity<>(advertService.deleteAdvert(deleteAdvertRequest), HttpStatus.OK);
    }

    @Operation(summary = "List Advert",description = "List Advert")
    @ApiResponse(responseCode = "200", description = "List Advert Response")
    @GetMapping(path = "/{advertId}")
    public ResponseEntity<ListAdvertResponse> listAdvert(
            @Parameter(description = "Request object for list",required = true)
            @PathVariable Long advertId) {
        return new ResponseEntity<>(advertService.getAdvert(advertId), HttpStatus.OK);
    }

    @Operation(summary = "List Advert",description = "List Advert")
    @ApiResponse(responseCode = "200", description = "List Advert Response")
    @GetMapping(path = "/list")
    public ResponseEntity<ListAdvertResponse> listAdvert(
            @Parameter(description = "Request object for list",required = true)
            @RequestBody ListAdvertRequest listAdvertRequest) {
        return new ResponseEntity<>(advertService.listAdvert(listAdvertRequest), HttpStatus.OK);
    }
}
