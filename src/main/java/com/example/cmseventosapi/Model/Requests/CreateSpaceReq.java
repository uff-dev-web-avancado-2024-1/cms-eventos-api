package com.example.cmseventosapi.Model.Requests;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CreateSpaceReq {
    private String name;
    private int capacity;
    private ArrayList<String> resources;
    private String description;
}
