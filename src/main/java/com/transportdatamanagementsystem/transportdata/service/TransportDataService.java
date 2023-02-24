package com.transportdatamanagementsystem.transportdata.service;

import com.transportdatamanagementsystem.apiconnector.ApiConnector;
import com.transportdatamanagementsystem.exception.InvalidUserPermissionException;
import com.transportdatamanagementsystem.permission.UserPermission;
import com.transportdatamanagementsystem.transportdata.model.TransportData;
import com.transportdatamanagementsystem.transportdata.repository.TransportDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TransportDataService {

    private final String userPermissionUrl = "http://localhost:4040/users/getUserPermission/id";

    private final TransportDataRepository transportDataRepository;

    private final ApiConnector apiConnector;


    public TransportDataService(TransportDataRepository transportDataRepository, ApiConnector apiConnector) {
        this.transportDataRepository = transportDataRepository;
        this.apiConnector = apiConnector;
    }

    public List<TransportData> findAllTransportDatas(Long userId) {
        var permission = getPermission(userId);
        if(!permission.contains(UserPermission.READ_ONLY.name())){
            throw new InvalidUserPermissionException("Invalid user permission! The necessary permission is : "+ UserPermission.READ_ONLY.name());
        }
        return transportDataRepository.findAll();
    }

    public TransportData addTransportData(TransportData transportData, Long userId) {
        var permission = getPermission(userId);
        if(!permission.contains(UserPermission.ADD.name())){
            throw new InvalidUserPermissionException("Invalid user permission! The necessary permission is : " +UserPermission.ADD.name());
        }
        return transportDataRepository.save(transportData);
    }

    public TransportData updateTransportData(TransportData transportData, Long userId) {
        var permission = getPermission(userId);
        if(!permission.contains(UserPermission.MODIFY.name())){
            throw new InvalidUserPermissionException("Invalid user permission! The necessary permission is : " + UserPermission.MODIFY.name());
        }
        return transportDataRepository.save(transportData);

    }

    public void deleteTransportData(Long id, Long userId){
        var permission = getPermission(userId);
        if(!permission.contains(UserPermission.DELETE.name())){
            throw new InvalidUserPermissionException("Invalid user permission! The necessary permission is : "+UserPermission.DELETE.name());
        }
        transportDataRepository.deleteTransportDataById(id);
    }

    private String getPermission(Long userId){
        var url = userPermissionUrl.replace("id", String.valueOf(userId));
        return apiConnector.getJSONArray(url);
    }
}
