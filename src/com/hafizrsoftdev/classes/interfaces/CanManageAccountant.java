package com.hafizrsoftdev.classes.interfaces;

import com.hafizrsoftdev.classes.Accountant;
import com.hafizrsoftdev.classes.TechnicalLead;

public interface CanManageAccountant {

	boolean addReport(Accountant e, TechnicalLead supportTeam);

}