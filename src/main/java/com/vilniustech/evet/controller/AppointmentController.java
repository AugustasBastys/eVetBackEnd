package com.vilniustech.evet.controller;

import com.vilniustech.evet.cqrs.aggregates.AppointmentAggregate;
import com.vilniustech.evet.cqrs.commands.CreateAppointmentCommand;
import com.vilniustech.evet.cqrs.commands.CancelAppointmentCommand;
import com.vilniustech.evet.cqrs.commands.RescheduleAppointmentCommand;
import com.vilniustech.evet.cqrs.queries.AppointmentQuery;
import com.vilniustech.evet.entities.appointments.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:3000/")
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
    @PutMapping("/cancel")
    public Appointment cancelAppointment(@RequestBody CancelAppointmentCommand appointmentCommand) {
        return appointmentAggregate.handleCancelAppointmentCommand(appointmentCommand);
    }

    @ResponseBody
    @PutMapping("/reschedule")
    public Appointment rescheduleAppointment(@RequestBody RescheduleAppointmentCommand appointmentCommand) {
        return appointmentAggregate.handleRescheduleAppointmentCommand(appointmentCommand);
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
