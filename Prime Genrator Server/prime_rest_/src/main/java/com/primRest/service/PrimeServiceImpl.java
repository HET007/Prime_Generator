package com.primRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primRest.entities.PrimeSet;
import com.primRest.entities.primeData;

@Service
public class PrimeServiceImpl implements PrimeService {
	@Autowired
	private PrimeDao primeDao;
	List<PrimeSet> data = new ArrayList<>();

	@Override
	public PrimeSet addData(primeData pData) {
		PrimeSet pSet = new PrimeSet(pData);
		System.out.println(pSet);
		data.add(pSet);
		primeDao.save(pSet);
		return pSet;
	}

}
