package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Databean;

public class DataProcessing {

	
		
	public static Databean compute(String data){
		
		List<String> e = Arrays.asList(data.trim().split("\\s*,\\s*"));
		List<Double> d = new ArrayList<Double>();
		
		for (int i = 0; i < e.size(); i++) {		 
			d.add(Double.parseDouble(e.get(i)));
		}
		
		double mean = 0.00;
		for (int i = 0; i < d.size(); i++) {
		mean += d.get(i);
		}
		
		mean = (float) mean / d.size();
		double variance = 0.00;
		double temp = 0.00;
		for (int i = 0; i < d.size(); i++) {
		temp += (mean - d.get(i)) * (mean - d.get(i));
		}
		variance = (float) temp / d.size();
		double stdv = Math.sqrt(variance);
		Databean DB = new Databean(mean, stdv);
		return DB;
		
		
	}

}
