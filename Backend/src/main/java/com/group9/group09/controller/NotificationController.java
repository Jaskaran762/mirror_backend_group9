package com.group9.group09.controller;

import com.group9.group09.DTO.RequestDTO.NotificationRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ErrorResponse;
import com.group9.group09.DTO.ResponseDTO.NotificationResponseDTO;
import com.group9.group09.service.interfaces.NotificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping(path = "fetchNotifications")
    public ResponseEntity<?> fetchAllNotifications(NotificationRequestDTO requestDTO, HttpServletRequest request){
        try{
            requestDTO.setToken(request.getHeader("Authorization"));
            List<NotificationResponseDTO> responseDTO = notificationService.fetchNotificationsForUser(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Errors in fetching notifications");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}
