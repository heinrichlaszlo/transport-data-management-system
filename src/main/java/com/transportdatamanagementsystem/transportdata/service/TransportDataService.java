package com.transportdatamanagementsystem.transportdata.service;

import com.transportdatamanagementsystem.apiconnector.ApiConnector;
import com.transportdatamanagementsystem.exception.InvalidUserPermissionException;
import com.transportdatamanagementsystem.exception.NoneUserPermissionException;
import com.transportdatamanagementsystem.permission.UserPermission;
import com.transportdatamanagementsystem.transportdata.model.TransportData;
import com.transportdatamanagementsystem.transportdata.repository.TransportDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@Slf4j
public class TransportDataService {

    private final String userPermissionUrl = "http://localhost:4040/users/login/{name}/{password}";

    private List<String> permissions = new ArrayList<>();

    private final TransportDataRepository transportDataRepository;

    private final ApiConnector apiConnector;


    public TransportDataService(TransportDataRepository transportDataRepository, ApiConnector apiConnector) {
        this.transportDataRepository = transportDataRepository;
        this.apiConnector = apiConnector;
    }

    public List<TransportData> findAllTransportDatas() {
        guardNonePermission(permissions);
        if(permissions.contains(UserPermission.NONE.name())){
            throw new InvalidUserPermissionException("Invalid user permission! The necessary permission is : "+ UserPermission.READ_ONLY.name());
        }
        return transportDataRepository.findAll();
    }

    public TransportData addTransportData(TransportData transportData) {
        guardNonePermission(permissions);
        if(!permissions.contains(UserPermission.ADD.name())){
            throw new InvalidUserPermissionException("Invalid user permission! The necessary permission is : " +UserPermission.ADD.name());
        }
        return transportDataRepository.save(transportData);
    }

    public TransportData updateTransportData(TransportData transportData) {
        guardNonePermission(permissions);
        if(!permissions.contains(UserPermission.MODIFY.name())){
            throw new InvalidUserPermissionException("Invalid user permission! The necessary permission is : " + UserPermission.MODIFY.name());
        }
        return transportDataRepository.save(transportData);

    }

    public void deleteTransportData(Long id){
        guardNonePermission(permissions);
        if(!permissions.contains(UserPermission.DELETE.name())){
            throw new InvalidUserPermissionException("Invalid user permission! The necessary permission is : "+UserPermission.DELETE.name());
        }
        transportDataRepository.deleteTransportDataById(id);
    }

    public JSONObject login(String name, String password){
       var urlWithName =  userPermissionUrl.replace("{name}", String.valueOf(name));
        var url = urlWithName.replace("{password}", String.valueOf(password));
        var response = apiConnector.getPermissions(url);
        getPermissions(response);
        return response;
    }

    public void logout(){
        permissions.clear();
        log.info("successful logout");
    }

    private void getPermissions(JSONObject response){
        var permissionArray = (JSONArray) response.get("permissions");
        log.info(permissionArray.toString());
        for (Object permission : permissionArray) {
            permissions.add(permission.toString());
        }
    }

    private void guardNonePermission(List<String> permissions){
        if(permissions.contains(UserPermission.NONE.name())){
          throw new NoneUserPermissionException("You have NONE permission.");
        }
    }
}
