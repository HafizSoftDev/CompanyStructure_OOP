package com.hafizrsoftdev.classes.interfaces;

import com.hafizrsoftdev.classes.SoftwareEngineer;

public interface CanManageEngineer {

	boolean addReport(SoftwareEngineer e);
	
	boolean approveCheckIn(SoftwareEngineer e);
}
