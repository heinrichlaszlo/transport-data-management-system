package com.transportdatamanagementsystem;

import com.transportdatamanagementsystem.transportdata.model.TransportData;
import com.transportdatamanagementsystem.transportdata.repository.TransportDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TransportDataManagementSystemApplication implements CommandLineRunner {

	private final TransportDataRepository transportDataRepository;

	public TransportDataManagementSystemApplication(TransportDataRepository transportDataRepository) {
		this.transportDataRepository = transportDataRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(TransportDataManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveDummyTransportData("testFreight1","25", "testFrom1", "testWhere1", LocalDate.of(2022,11,11));
		saveDummyTransportData("testFreight2","30", "testFrom2", "testWhere2", LocalDate.of(2021,11,10));
		saveDummyTransportData("testFreight3","24", "testFrom3", "testWhere3",LocalDate.of(2012,07,11));
	}

	private void saveDummyTransportData(String freight, String weight , String from, String where, LocalDate date){
		transportDataRepository.save(TransportData.builder().freight(freight).fromWhereDeliveryPlace(from).whereDeliveryPlace(where).weight(weight).date(date).build());
	}
}
