package com.transportdatamanagementsystem.transportdata.controller;

import com.transportdatamanagementsystem.transportdata.model.TransportData;
import com.transportdatamanagementsystem.transportdata.service.TransportDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportData")
public class TransportDataController {

    private final TransportDataService transportDataService;

    public TransportDataController(TransportDataService transportDataService) {
        this.transportDataService = transportDataService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<TransportData>> FindAllTransportDatas(){
           var transportDatas = transportDataService.findAllTransportDatas();
           return new ResponseEntity<>(transportDatas, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TransportData> addTransportData(@RequestBody TransportData transportData){
        var newTransportData = transportDataService.addTransportData(transportData);
        return new ResponseEntity<>(newTransportData, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TransportData> updateTransportData(@RequestBody TransportData transportData){
        var updateTransportData = transportDataService.updateTransportData(transportData);
        return new ResponseEntity<>(updateTransportData, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{transportDataId}")
    public ResponseEntity<?> deleteTransportData(@PathVariable("transportDataId") Long transportDataId){
        transportDataService.deleteTransportData(transportDataId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/login/{name}/{password}")
    public ResponseEntity<?> login(@PathVariable("name") String name,@PathVariable("password") String password){
        var response = transportDataService.login(name,password);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/logout")
    public ResponseEntity<?> logout(){
        transportDataService.logout();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
