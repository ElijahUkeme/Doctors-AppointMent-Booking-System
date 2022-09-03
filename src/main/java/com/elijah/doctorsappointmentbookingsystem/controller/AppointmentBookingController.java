package com.elijah.doctorsappointmentbookingsystem.controller;


import com.elijah.doctorsappointmentbookingsystem.dto.AppointmentBookingDto;
import com.elijah.doctorsappointmentbookingsystem.exception.DataAlreadyExistException;
import com.elijah.doctorsappointmentbookingsystem.exception.DataNotFoundException;
import com.elijah.doctorsappointmentbookingsystem.model.appointment.AppointmentBooking;
import com.elijah.doctorsappointmentbookingsystem.response.ApiResponse;
import com.elijah.doctorsappointmentbookingsystem.service.AppointmentBookingService;
import com.elijah.doctorsappointmentbookingsystem.service.AppointmentTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/appointment")
public class AppointmentBookingController {

    @Autowired
    private AppointmentBookingService appointmentBookingService;

    @Autowired
    private AppointmentTokenService appointmentTokenService;

    @PostMapping("/book")
    public ResponseEntity<ApiResponse> bookAppointment(@RequestBody AppointmentBookingDto appointmentBookingDto, @RequestParam("token") String token) throws DataNotFoundException, ParseException, DataAlreadyExistException {

        return appointmentBookingService.bookAppointment(appointmentBookingDto,token);
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse> updateAppointment(@RequestBody AppointmentBookingDto appointmentBookingDto,@RequestParam("token")String token) throws DataNotFoundException, ParseException {
        appointmentBookingService.updateAppointment(appointmentBookingDto,token);

        return new ResponseEntity<>(new ApiResponse(true,"Appointment Updated Successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteAppointment(@RequestParam("token") String token) throws DataNotFoundException {
        appointmentBookingService.deleteAppointment(token);
        return new ResponseEntity<>(new ApiResponse(true,"Appointment Deleted Successfully"),HttpStatus.OK);
    }
    @GetMapping("/info")
    public AppointmentBooking getAppointmentInformation(@RequestParam("token") String token) throws DataNotFoundException {

        return appointmentTokenService.getAppointmentInfo(token);
    }

    @GetMapping("/list/all")
    public List<AppointmentBooking> appointmentBookingList(){
        return appointmentBookingService.getAllAppointment();
    }

    @GetMapping("/list/cancel")
    public List<AppointmentBooking> cancelList(){
        return appointmentBookingService.getAllCancelledAppointMen();
    }
    @GetMapping("/list/approved")
    public List<AppointmentBooking> approvedList(){
        return appointmentBookingService.getAllApprovedAppointMen();
    }

    @GetMapping("/list/pending")
    public List<AppointmentBooking> pendingList(){
        return appointmentBookingService.getAllPendingAppointMen();
    }

    @GetMapping("/list/attended")
    public List<AppointmentBooking> attendedList(){
        return appointmentBookingService.getAllAttendedAppointMen();
    }

}
