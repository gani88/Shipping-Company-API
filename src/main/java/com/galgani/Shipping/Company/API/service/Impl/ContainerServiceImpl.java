package com.galgani.Shipping.Company.API.service.Impl;

import com.galgani.Shipping.Company.API.dto.request.NewContainerRequest;
import com.galgani.Shipping.Company.API.dto.request.SearchContainerRequest;
import com.galgani.Shipping.Company.API.dto.request.UpdateContainerRequest;
import com.galgani.Shipping.Company.API.dto.response.ContainerResponse;
import com.galgani.Shipping.Company.API.entity.Container;
import com.galgani.Shipping.Company.API.entity.Customer;
import com.galgani.Shipping.Company.API.repository.ContainerRepository;
import com.galgani.Shipping.Company.API.service.ContainerService;
import com.galgani.Shipping.Company.API.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContainerServiceImpl implements ContainerService {
    private final ContainerRepository containerRepository;
    private final ValidationUtils validationUtils;

    @Override
    public Container create(NewContainerRequest newContainerRequest) {
        validationUtils.validate(newContainerRequest);

        Container newContainer = Container.builder()
                .containerType(newContainerRequest.getContainerType())
                .location(newContainerRequest.getLocation())
                .build();

        return containerRepository.saveAndFlush(newContainer);
    }

    public Container findIdException(String id) {
        return containerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Container Not Found"));
    }

    @Override
    public Container getById(String id) {
        return findIdException(id);
    }

    @Override
    public List<Container> searchContainer(SearchContainerRequest searchContainerRequest) {
        return containerRepository.searchContainer(
                searchContainerRequest.getContainerType(),
                searchContainerRequest.getLocation()
        );
    }

    @Override
    public ContainerResponse update(UpdateContainerRequest updateContainerRequest) {
        Container containerById = getById(updateContainerRequest.getId());

        containerById.setContainerType(updateContainerRequest.getContainerType());
        containerById.setLocation(updateContainerRequest.getLocation());

        containerRepository.saveAndFlush(containerById);

        return ContainerResponse.builder()
                .id(updateContainerRequest.getId())
                .containerType(updateContainerRequest.getContainerType())
                .location(updateContainerRequest.getLocation())
                .build();
    }

    @Override
    public void deleteById(String id) {
        Container isActive = getById(id);

        containerRepository.delete(isActive);
    }
}
