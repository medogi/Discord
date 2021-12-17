package com.war.war.appadmin;

import lombok.AllArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@AllArgsConstructor
public class AppAdminDTO {
    private String name;

    private Date date;
    private int size;
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
