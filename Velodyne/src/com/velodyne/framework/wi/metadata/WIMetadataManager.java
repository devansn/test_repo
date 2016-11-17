package com.velodyne.framework.wi.metadata;

import java.util.List;

public class WIMetadataManager {

	private static volatile WIMetadataManager self = null;
	private BOMMetadata metadata;
	
	private WIMetadataManager() {
		init();
	}

	private void init() {
		// Read DB and populate the values to cache
	}
	
	public static final WIMetadataManager self() {
		if(null == self) {
			synchronized (WIMetadataManager.class) {
				if(null == self) {
					self = new WIMetadataManager();
				}
			}
		}
		return self;
	}

	public BOMMetadata getMetadata() {
		return metadata;
	}
	
	public List<WorkInstruction> getWorkInstructions(String bomName, String station) {
		StationMetadata stationMetadata = metadata.getStationMetadata(bomName);
		return stationMetadata.getWorkInstructions(station);
	}
}
