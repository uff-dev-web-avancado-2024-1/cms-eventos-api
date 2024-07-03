package com.example.cmseventosapi.Model.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEventReq {
    private String name;
    private String description;
    private String acronym;
    private String path;
}
