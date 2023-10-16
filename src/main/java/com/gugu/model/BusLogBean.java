package com.gugu.model;

import lombok.Data;

import java.util.Date;

@Data
public class BusLogBean {
    private String busName;
    private String busDescribe;
    private String operPerson;
    private Date operTime;
    private String paramFile;
}
