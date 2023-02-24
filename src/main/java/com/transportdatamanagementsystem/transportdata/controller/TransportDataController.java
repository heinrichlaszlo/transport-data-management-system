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


    @GetMapping("/all/{id}")
    public ResponseEntity<List<TransportData>> FindAllTransportDatas(@PathVariable("id") Long id){
        var transportDatas = transportDataService.findAllTransportDatas(id);
        return new ResponseEntity<>(transportDatas, HttpStatus.OK);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<TransportData> addTransportData(@RequestBody TransportData transportData,@PathVariable("id") Long id){
        var newTransportData = transportDataService.addTransportData(transportData, id);
        return new ResponseEntity<>(newTransportData, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransportData> updateTransportData(@RequestBody TransportData transportData, @PathVariable("id") Long id){
        var updateTransportData = transportDataService.updateTransportData(transportData, id);
        return new ResponseEntity<>(updateTransportData, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}/{transportDataId}")
    public ResponseEntity<?> deleteTransportData( @PathVariable("userId") Long userId,@PathVariable("transportDataId") Long transportDataId){
        transportDataService.deleteTransportData(transportDataId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
