package com.training.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.training.ifaces.NumberToTextService;


@WebService(endpointInterface = "com.training.ifaces.NumberToTextService")
public class NumberToText implements NumberToTextService {

	@Override
	@WebMethod
	@WebResult(name = "Number To Text")
	public String numberToText(@WebParam(name = "number") int number) {
		// TODO Auto-generated method stub
		String res=null;
		switch (number) {
		case 1: res="one";
				break;
		case 2:res="two";
				break;
		case 3:res="three";
				break;
		case 4:res="four";
				break;
		case 5:res="five";
				break;
		case 6:res="six";
				break;
		case 7:res="seven";
				break;
		case 8:res="eight";
				break;
		case 9:res="nine";
				break;
		default:
			break;
		}
		return res;
	}


}
