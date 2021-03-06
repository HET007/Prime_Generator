package com.primRest.entities;


public class primeData {
	
	private int pMin,pMax,algoId;
	private String name;
	public primeData(int pMin, int pMax, int algoId, String name) {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		this.algoId = algoId;
		this.name = name;
	}
	public int getpMin() {
		return pMin;
	}
	public void setpMin(int pMin) {
		this.pMin = pMin;
	}
	public int getpMax() {
		return pMax;
	}
	public void setpMax(int pMax) {
		this.pMax = pMax;
	}
	public int getAlgoId() {
		return algoId;
	}
	public void setAlgoId(int algoId) {
		this.algoId = algoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public primeData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "primeData [pMin=" + pMin + ", pMax=" + pMax + ", algoId=" + algoId + ", name=" + name + "]";
	}
}
