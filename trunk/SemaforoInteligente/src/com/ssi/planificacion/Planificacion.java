package com.ssi.planificacion;

import java.util.ArrayList;
import java.util.List;


public class Planificacion {

	List<Integer> plan = new ArrayList<Integer>();

	public List<Integer> getPlan() {
		return plan;
	}

	
	public void setPlan(int A ){
		plan.add(A);
		
		
	}
}
