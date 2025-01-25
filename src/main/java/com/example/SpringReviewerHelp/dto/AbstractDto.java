package com.example.SpringReviewerHelp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractDto {
    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;

    @Column(name = "updated_date")
    @CreationTimestamp
    private Timestamp updatedBy;

    @Column(name =  "createdBy", nullable = true)
    private String createdBy;

    @PrePersist
    private void prePersist(){
        this.createdBy = "Kenley";
    }
}
