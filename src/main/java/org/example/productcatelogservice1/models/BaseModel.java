package org.example.productcatelogservice1.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseModel {
    private long id;
    private Date lastUpdatedAt;
    private Date createdAt;
    private State state;
}