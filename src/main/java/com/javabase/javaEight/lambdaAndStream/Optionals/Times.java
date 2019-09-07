package com.javabase.javaEight.lambdaAndStream.Optionals;

import java.util.Optional;

public class Times {
	public  static String getInsuranceName(Employee employee) {
		if (employee != null) {
			Car car = employee.getCar();
			if (car != null) {
				Insurance insurance = car.getInsurance();
				if (insurance != null) {
					return insurance.getName();
				}
			}
		}
		return "UNKNOWN";
	}

	public  static String getInsuranceNam2(Employee employee) {
		return employee.getCar().getInsurance().getName();
	}

	public  static  String getInsuranceName24(Optional<OEmployee> employee) {
		return employee.flatMap(OEmployee::getCar).flatMap(OCar::getInsurance).map(OInsurance::getName)
				.orElse("UNKNOWN");
	}
	public static void main(String[] args) {
		Employee e=new Employee();
		Insurance i=new Insurance();
		Car c=new Car();
		c.setInsurance(i);
		i.setName("test1");
		e.setCar(c);
		System.out.println(getInsuranceNam2(e));
//		
//		OEmployee e1=new OEmployee();
//		OInsurance i2=new OInsurance();
//		Optional<OCar> c3=new OCar();
//		c3.setInsurance(i2);
//		i2.setName("test2");
//		e1.1setCar(c3);
	}
}
