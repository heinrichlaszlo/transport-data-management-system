package com.transportdatamanagementsystem;

import com.transportdatamanagementsystem.transportdata.model.TransportData;
import com.transportdatamanagementsystem.transportdata.repository.TransportDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		saveDummyTransportData("testFreight1", "testFrom1", "testWhere1");
		saveDummyTransportData("testFreight2", "testFrom2", "testWhere2");
		saveDummyTransportData("testFreight3", "testFrom3", "testWhere3");
	}

	private void saveDummyTransportData(String freight, String from, String where){
		transportDataRepository.save(TransportData.builder().freight(freight).fromWhereDeliveryPlace(from).whereDeliveryPlace(where).build());
	}
}
