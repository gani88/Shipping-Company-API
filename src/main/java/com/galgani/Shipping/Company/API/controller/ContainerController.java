package com.galgani.Shipping.Company.API.controller;

import com.galgani.Shipping.Company.API.constant.APIUrl;
import com.galgani.Shipping.Company.API.dto.request.*;
import com.galgani.Shipping.Company.API.dto.response.CommonResponse;
import com.galgani.Shipping.Company.API.dto.response.ContainerResponse;
import com.galgani.Shipping.Company.API.dto.response.CustomerResponse;
import com.galgani.Shipping.Company.API.entity.Container;
import com.galgani.Shipping.Company.API.entity.Customer;
import com.galgani.Shipping.Company.API.service.ContainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.CONTAINER_API)
public class ContainerController {
    private final ContainerService containerService;

    @PostMapping
    public ResponseEntity<CommonResponse<Container>> registerContainer(@RequestBody NewContainerRequest newContainerRequest) {
        Container registerContainer = containerService.create(newContainerRequest);

        CommonResponse<Container> response = CommonResponse.<Container>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Success Create Customer")
                .data(registerContainer)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<Container>>> findContainer(
            @RequestParam(name = "containerType", required = false) String containerType,
            @RequestParam(name = "location", required = false) String location) {

        SearchContainerRequest searchContainerRequest = SearchContainerRequest.builder()
                .containerType(containerType)
                .location(location)
                .build();

        List<Container> allContainer = containerService.searchContainer(searchContainerRequest);

        CommonResponse<List<Container>> response = CommonResponse.<List<Container>>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully Fetch Data")
                .data(allContainer)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping(path = APIUrl.PATH_VAR_ID)
    public ResponseEntity<CommonResponse<Container>> findContainerById(@PathVariable String id) {
        Container containerById = containerService.getById(id);

        CommonResponse<Container> response = CommonResponse.<Container>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully Fetch Data")
                .data(containerById)
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<CommonResponse<ContainerResponse>> updateContainer(@RequestBody UpdateContainerRequest updateContainerRequest) {
        ContainerResponse updateContainer = containerService.update(updateContainerRequest);

        CommonResponse<ContainerResponse> response = CommonResponse.<ContainerResponse>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully Update Container")
                .data(updateContainer)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CommonResponse<String>> deleteContainer(@PathVariable String id) {
        containerService.deleteById(id);

        CommonResponse<String> response = CommonResponse.<String>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Container is Already Delivered")
                .build();

        return ResponseEntity.ok(response);
    }

}
