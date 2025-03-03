package com.example.jpalecture.domain.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at", columnDefinition = "TiMESTAMP")
    private LocalDateTime createdAt;
}
