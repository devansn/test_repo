package com.velodyne.framework.wi.metadata;

import java.util.HashMap;
import java.util.Map;

public class BOMMetadata {

	private Map<String, StationMetadata> bomStationWIMap;

	public Map<String, StationMetadata> getBomStationWIMap() {
		return bomStationWIMap;
	}
	
	public void addStationMetadata(StationMetadata stationMetadata, String bomName) {
		if(null == bomStationWIMap) {
			bomStationWIMap = new HashMap<>();
		}
		bomStationWIMap.put(bomName, stationMetadata);
	}
	
	public StationMetadata getStationMetadata(String bomName) {
		if(null != bomStationWIMap) {
			return bomStationWIMap.get(bomName);
		}
		return null;
	}
}
