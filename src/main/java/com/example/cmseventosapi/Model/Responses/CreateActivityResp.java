package com.example.cmseventosapi.Model.Responses;

import com.example.cmseventosapi.Enum.ActivityType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CreateActivityResp {
    private Long id;
    private String name;
    private ActivityType type;
    private String description;
    private Date date;
    private Date startTime;
    private Date endTime;
    private Long spaceId;
    private Long editionId;
}
