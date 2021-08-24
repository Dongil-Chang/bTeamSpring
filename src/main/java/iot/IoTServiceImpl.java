package iot;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IoTServiceImpl implements IoTService {
	
	@Autowired private IoTDAO dao;
	
	@Override
	public int IoT_insert_TemHum(HashMap<String, Object> map) {
		return dao.IoT_insert_TemHum(map);
	}

	@Override
	public IoTVO IoT_list(String id) {
		return dao.IoT_list(id);
	}
	

	



	
}