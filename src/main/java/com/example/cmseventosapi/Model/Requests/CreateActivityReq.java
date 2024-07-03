package com.example.cmseventosapi.Model.Requests;

import com.example.cmseventosapi.Enum.ActivityType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateActivityReq {
    private String name;
    private ActivityType type;
    private String description;
    private Date date;
    private Date startTime;
    private Date endTime;
    private Long spaceId;
    private Long editionId;
}
