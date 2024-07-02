package com.example.cmseventosapi.Model.Requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateEditionReq {
    private int number;
    private int year;
    private Date startDate;
    private Date endDate;
    private Long eventId;
}
