package com.satdegerlendir.demo.ticket.dto;

import java.time.LocalDateTime;

public class createTicked {
    Long id;
    String name;
    String description;
    String type;
    double price;
    String Image;
    Long userId;
    LocalDateTime ticketDate;





    public String getImage() {
        return Image;
    }
    public void setImage(String image) {
        Image = image;
    }

    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public LocalDateTime getTicketDate() {
        return ticketDate;
    }
    public void setTicketDate(LocalDateTime ticketDate) {
        this.ticketDate = ticketDate;
    }

}
