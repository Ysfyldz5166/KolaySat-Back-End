package com.satdegerlendir.demo.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satdegerlendir.demo.error.ApiError;
import com.satdegerlendir.demo.shared.GenericMessage;
import com.satdegerlendir.demo.user.dto.UserDto;
import com.satdegerlendir.demo.user.dto.userCreate;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
     MessageSource messageSource;
	private String message;
    @PostMapping
    GenericMessage createUser(@Valid @RequestBody userCreate user) {
        userService.save(user.toUser());
        setMessage(messageSource.getMessage("kolaysat.create.user.succes.message",null,LocaleContextHolder.getLocale()));
        return new GenericMessage("User is created");
    }

    @GetMapping
    public List<user> getAllUsers(){
        return userService.GetAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto getFindByUser(@PathVariable Long userId){
        return new UserDto(userService.GetByIdUsers(userId)); 
    }

    @PutMapping("/{userId}")
    public user updateUser(@PathVariable Long userId, @RequestBody user newUser){
        return userService.updateUser( userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteById(userId); 
    }








    @ExceptionHandler(NotUniqueEmailException.class)
    ResponseEntity<ApiError> handleNotUniqueEmailEx(NotUniqueEmailException exception) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);
        Map<String, String> validationErrors=new HashMap<>();
        validationErrors.put("email", "Aynı E-Mail Kullanılamaz");
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }

    
    @ExceptionHandler(NullPointerException.class)
    ResponseEntity<ApiError> handleNotFoundEntityException(NullPointerException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setPath(request.getRequestURI());
        apiError.setMessage("Not Found");
        apiError.setStatus(404);
        return ResponseEntity.status(404).body(apiError);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
