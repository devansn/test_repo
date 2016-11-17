package com.velodyne.framework.wi.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StationMetadata {

	private Map<String, Map<Long, WorkInstruction>> stationWiseWI;
	
	public StationMetadata(Map<String, List<WorkInstruction>> stationWIListMap) {
		if(null == stationWIListMap || stationWIListMap.isEmpty()) {
			// TODO: throw
		}
		
		for(Entry<String, List<WorkInstruction>> entry : stationWIListMap.entrySet()) {
			String station = entry.getKey();
			List<WorkInstruction> wiList = entry.getValue();
			if(null == wiList || wiList.isEmpty()) {
				continue;
			}
			for (WorkInstruction workInstruction : wiList) {
				addWorkInstruction(station, workInstruction);
			}
		}
	}

	public void addWorkInstruction(String station, WorkInstruction workInstruction) {
		if(null == workInstruction.getWiParent()) {
			addRootWorkInstruction(workInstruction, station);
		} else {
			WorkInstruction parentWI = getWorkInstruction(workInstruction.getWiParent(), station);
			parentWI.addChild(workInstruction);
		}
	}
	
	public List<WorkInstruction> getWorkInstructions(String station) {
		if(null != this.stationWiseWI && null != this.stationWiseWI.get(station) && !this.stationWiseWI.get(station).isEmpty()) {
			Map<Long, WorkInstruction> wiMap = this.stationWiseWI.get(station);
			return new ArrayList<>(wiMap.values());
		}
		return null;
	}
	
	private WorkInstruction getWorkInstruction(Long wiKey, String station) {
		Map<Long, WorkInstruction> wiMap = this.stationWiseWI.get(station);
		return getWorkInstruction(wiKey, wiMap);
	}

	private WorkInstruction getWorkInstruction(Long wiKey, Map<Long, WorkInstruction> wiMap) {
		for(Entry<Long, WorkInstruction> entry : wiMap.entrySet()) {
			WorkInstruction workInstruction = entry.getValue();
			if(entry.getKey() == wiKey) {
				return workInstruction;
			} else if(null != workInstruction.getChildWIMap() && !workInstruction.getChildWIMap().isEmpty()) {
				return getWorkInstruction(wiKey, workInstruction.getChildWIMap());
			}
		}
		return null;
	}

	private void addRootWorkInstruction(WorkInstruction workInstruction, String station) {
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
