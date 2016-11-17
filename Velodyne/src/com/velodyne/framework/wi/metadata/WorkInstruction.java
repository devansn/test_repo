package com.velodyne.framework.wi.metadata;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WorkInstruction {

	private Long workInstructionKey; // OBJECT_KEY
	private Long wiListKey; // InstructionListKey
	private String station;
	private String route;
	private String taskNumber;
	private String descriptionI18NKey;
	private String category;
	private String wiNumber; // MPI 70-0280
	private String partNumber;
	private boolean reportOut; // Send to ERP
	private long cycleTime; // Progress bar cycle time in seconds
	private UIType uiType; // POPUP, SIMPLE - to show instruction on a popup,
							// for eg.
	private Long wiParent; // To maintain a WI hierarchy
	private List<WIComponent> components;
	private Map<Long, WorkInstruction> childWIMap;

	public Long getWorkInstructionKey() {
		return workInstructionKey;
	}

	public void setWorkInstructionKey(Long workInstructionKey) {
		this.workInstructionKey = workInstructionKey;
	}

	public Long getWiListKey() {
		return wiListKey;
	}

	public void setWiListKey(Long wiListKey) {
		this.wiListKey = wiListKey;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getTaskNumber() {
		return taskNumber;
	}

	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}

	public String getDescriptionI18NKey() {
		return descriptionI18NKey;
	}

	public void setDescriptionI18NKey(String descriptionI18NKey) {
		this.descriptionI18NKey = descriptionI18NKey;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWiNumber() {
		return wiNumber;
	}

	public void setWiNumber(String wiNumber) {
		this.wiNumber = wiNumber;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public boolean isReportOut() {
		return reportOut;
	}

	public void setReportOut(boolean reportOut) {
		this.reportOut = reportOut;
	}

	public long getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(long cycleTime) {
		this.cycleTime = cycleTime;
	}

	public UIType getUiType() {
		return uiType;
	}

	public void setUiType(UIType uiType) {
		this.uiType = uiType;
	}

	public Long getWiParent() {
		return wiParent;
	}

	public void setWiParent(Long wiParent) {
		this.wiParent = wiParent;
	}

	public List<WIComponent> getComponents() {
		return components;
	}

	public void setComponents(List<WIComponent> components) {
		this.components = components;
	}

	public Map<Long, WorkInstruction> getChildWIMap() {
		return childWIMap;
	}

	public void setChildWIMap(Map<Long, WorkInstruction> childWIMap) {
		this.childWIMap = childWIMap;
	}

	public void addChild(WorkInstruction workInstruction) {
		if(null == this.childWIMap) {
			this.childWIMap = new LinkedHashMap<>();
		}
		this.childWIMap.put(workInstruction.getWorkInstructionKey(), workInstruction);
	}
	
	public boolean isLeaf() {
		return (null == this.childWIMap || this.childWIMap.isEmpty());
	}
	
	public Long getLastChildId() {
		if(isLeaf()) {
			return null;
		}
		Set<Long> keySet = this.childWIMap.keySet();
		return (Long) keySet.toArray()[keySet.size() - 1];
	}
}
