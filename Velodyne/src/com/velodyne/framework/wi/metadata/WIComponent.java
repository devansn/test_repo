package com.velodyne.framework.wi.metadata;

import java.util.Map;

public class WIComponent {

	private Long componentKey; // PK
	private int componentSequence;
	private String captionI18Key;
	private ComponentType componentType;
	private ComponentDataType componentDataType;
    // File relative path(IMAGE/PDF), CSV or REST URL(CHECK, RADIO, SELECT, MULTI_SELECT), CUSTOM(Custom compoenent class name, 
    // e.g: com.infinira.mes.common.component.CarrierMarriage extends CustomComponent)
	private String inputValue;
	private int width;
	private int height;
	private Unit unit;
    // TRUE: VALIDATE MIN_VALUE & MAX_VALUE, FALSE: LCL & UCL, if(value > UCL || value < LCL), enforce comment and add it as defect.
	private boolean enforceValidation; 
	private double minValue;
	private double maxValue;
    // Key: Regex; Value: Validation message I18Key
	private Map<String, String> validations;
    // For equipment integration, this Java code, when executed, should provide the runtime value for this component.
	private String equipmentIntegrationScript;

	public Long getComponentKey() {
		return componentKey;
	}

	public void setComponentKey(Long componentKey) {
		this.componentKey = componentKey;
	}

	public int getComponentSequence() {
		return componentSequence;
	}

	public void setComponentSequence(int componentSequence) {
		this.componentSequence = componentSequence;
	}

	public String getCaptionI18Key() {
		return captionI18Key;
	}

	public void setCaptionI18Key(String captionI18Key) {
		this.captionI18Key = captionI18Key;
	}

	public ComponentType getComponentType() {
		return componentType;
	}

	public void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}

	public ComponentDataType getComponentDataType() {
		return componentDataType;
	}

	public void setComponentDataType(ComponentDataType componentDataType) {
		this.componentDataType = componentDataType;
	}

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public boolean isEnforceValidation() {
		return enforceValidation;
	}

	public void setEnforceValidation(boolean enforceValidation) {
		this.enforceValidation = enforceValidation;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public Map<String, String> getValidations() {
		return validations;
	}

	public void setValidations(Map<String, String> validations) {
		this.validations = validations;
	}

	public String getEquipmentIntegrationScript() {
		return equipmentIntegrationScript;
	}

	public void setEquipmentIntegrationScript(String equipmentIntegrationScript) {
		this.equipmentIntegrationScript = equipmentIntegrationScript;
	}
}