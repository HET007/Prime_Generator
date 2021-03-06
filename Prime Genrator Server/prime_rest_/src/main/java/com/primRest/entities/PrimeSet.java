package com.primRest.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrimeSet {
	@Id
	private String name;
	private int algo;
	@Column(columnDefinition = "LONGTEXT")
	private String result;
	private long tElapse; // time of execution
	private String tStamp; // time stamp
	private int pCount; // number of prime generated

	public PrimeSet(primeData pData) {
		long start = System.nanoTime();
		prime(pData);
		long stop = System.nanoTime();
		settElapse(stop - start);
		LocalDateTime a = LocalDateTime.now();// TODAY TIME
		settStamp(a.toString());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlgo() {
		return algo;
	}

	public void setAlgo(int algo) {
		this.algo = algo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long gettElapse() {
		return tElapse;
	}

	public void settElapse(long tElapse) {
		this.tElapse = tElapse;
	}

	public String gettStamp() {
		return tStamp;
	}

	public void settStamp(String tStamp) {
		this.tStamp = tStamp;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

	public PrimeSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PrimeSet [algo=" + algo + ", name=" + name + ", result=" + result + "]";
	}

	public void prime(primeData pData) {
		int pMin, pMax, algoId;
		String name, result = "";
		pMin = pData.getpMin();
		pMax = pData.getpMax();
		algoId = pData.getAlgoId();
		name = pData.getName();
		int count = 0;
		if (pMin <= 1) // if entered number starts from 1 it'll count as 2 because of rules of prime
			pMin = 2;
		switch (algoId) {
		case 1:
			for (int i = pMin; i < pMax; i++) {
				int temp = 0;
				for (int j = 2; j <= pMax; j++) {
					if (i % j == 0)
						temp = temp + 1;
				}
				if (temp == 1) {
					result = result + " " + Integer.toString(i); // if the value divide by themselves and not any other
					count++;
				}
			}
			break;

		case 2:
			for (int i = pMin; i < pMax; i++) {
				int temp = 0;
				int cont = (int) Math.floor(Math.sqrt(i));// finding approximate value of square root of number
				for (int j = 2; j <= 1 + cont; j++) {
					if (i % j == 0) {
						temp = i == 2 ? 1 : 0;
						break;
					}
					temp = 1;
				}
				if (temp == 1) {
					result = result + " " + Integer.toString(i);// if the value not divide by 2 till there square root
					count++;
				}
			}
			break;
		}
		setName(name);
		setResult(result);
		setAlgo(algoId);
		setpCount(count);
	}
}
