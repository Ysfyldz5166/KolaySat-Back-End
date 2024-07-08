package com.satdegerlendir.demo.ticket.dto;

import java.time.LocalDateTime;


public class updateTicketDto {
    String name;
    String description;
    String type;
    double price;
    String Image;
    LocalDateTime ticketDate;
    String adress;


    public LocalDateTime getTicketDate() {
        return ticketDate;
    }
    public void setTicketDate(LocalDateTime ticketDate) {
        this.ticketDate = ticketDate;
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImage() {
        return Image;
    }
    public void setImage(String image) {
        Image = image;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
}
