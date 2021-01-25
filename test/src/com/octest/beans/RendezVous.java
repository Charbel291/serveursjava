package com.octest.beans;

import java.time.LocalDate;

public class RendezVous {
	private LocalDate date_rdv;
	private Patient patient;
	private Medecin medecin;
	private CentreMedical centre_medical;
	
	public RendezVous(LocalDate date_rdv, Patient patient) {
		this.date_rdv=date_rdv;
		this.patient=patient;
	}

	public LocalDate getDate_rdv() {
		return date_rdv;
	}

	public void setDate_rdv(LocalDate date_rdv) {
		this.date_rdv = date_rdv;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public CentreMedical getCentre_medical() {
		return centre_medical;
	}

	public void setCentre_medical(CentreMedical centre_medical) {
		this.centre_medical = centre_medical;
	}
	
	
}
