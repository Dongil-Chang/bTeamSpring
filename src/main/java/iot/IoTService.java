package iot;

import java.util.HashMap;
import java.util.List;

public interface IoTService {

	int IoT_insert_TemHum(HashMap<String, Object> map);	// 온습도 값 저장 (C)
	
	IoTVO IoT_list(String id);	// 온습도 값 조회 (R)
}