package com.vgtu.evet.controller;

import com.vgtu.evet.cqrs.aggregates.AppointmentAggregate;
import com.vgtu.evet.cqrs.commands.CreateAppointmentCommand;
import com.vgtu.evet.cqrs.commands.UpdateAppointmentCommand;
import com.vgtu.evet.cqrs.queries.AppointmentQuery;
import com.vgtu.evet.entities.appointments.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @Autowired
    private AppointmentAggregate appointmentAggregate;

    @Autowired
    private AppointmentQuery appointmentQuery;

    @ResponseBody
    @PostMapping("/book")
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
    @GetMapping
    public List<Appointment> getAppointments() {
        return appointmentQuery.getAllUserPetsAppointments(SecurityContextHolder.getContext().
                getAuthentication().getName());
    }

}
