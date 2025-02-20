package com.Hospital.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.Management.entity.Appointment;
import com.Hospital.Management.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentById(Long id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id).orElseThrow(() ->
			new RuntimeException("Appointments not found with id:" +id));	
	}

	@Override
	public Appointment scheduleAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateAppointmentById(Long id, Appointment appointment) {
		// TODO Auto-generated method stub
		
		Appointment existingAppointment = appointmentRepository.findById(id).orElseThrow(()->
				new RuntimeException("Appointment not found with Id" +id));
		appointment.setId(id);
		return appointmentRepository.save(appointment);
	}

	@Override
	public void cancelAppointmentById(Long id) {
		// TODO Auto-generated method stub
		appointmentRepository.deleteById(id);
		
	}
	
	

}
