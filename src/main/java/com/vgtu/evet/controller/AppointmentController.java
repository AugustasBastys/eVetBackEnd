package com.vgtu.evet.controller;

import com.vgtu.evet.cqrs.aggregates.AppointmentAggregate;
import com.vgtu.evet.cqrs.commands.CreateAppointmentCommand;
import com.vgtu.evet.cqrs.commands.UpdateAppointmentCommand;
import com.vgtu.evet.cqrs.queries.AppointmentQuery;
import com.vgtu.evet.entities.appointments.Appointment;
import com.vgtu.evet.entities.pets.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentAggregate appointmentAggregate;

    @Autowired
    private AppointmentQuery appointmentQuery;

    @ResponseBody
    @PostMapping("/create")
    public Appointment createAppointment(@RequestBody CreateAppointmentCommand appointmentCommand) {
        return appointmentAggregate.handleCreateAppointmentCommand(appointmentCommand);
    }

    @ResponseBody
    @PutMapping("/update")
    public Appointment updateAppointment(@RequestBody UpdateAppointmentCommand appointmentCommand) {
        return appointmentAggregate.handleUpdateAppointmentCommand(appointmentCommand);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable int id) {
        return appointmentQuery.getById(id);
    }

    @ResponseBody
    @GetMapping("/pet/{id}")
    public List<Appointment> getAppointments(@PathVariable int id) {
        return appointmentQuery.getByPetId(id);
    }

}
