package com.velodyne.framework.wi.metadata;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WIMetadata {

	private Map<String, Map<Long, WorkInstruction>> stationWiseWI;
	
	public void addWorkInstruction(WorkInstruction workInstruction, String station) {
		if(null == workInstruction) {
			// throw
		}
		if(null == this.stationWiseWI) {
			this.stationWiseWI = new HashMap<>();
		}
		Map<Long, WorkInstruction> wiMap = this.stationWiseWI.get(station);
		if(null == wiMap) {
			wiMap = new LinkedHashMap<>();
			this.stationWiseWI.put(station, wiMap);
		}
		wiMap.put(workInstruction.getWorkInstructionKey(), workInstruction);
	}
}
