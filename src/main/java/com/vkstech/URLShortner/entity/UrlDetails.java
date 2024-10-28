package com.vkstech.URLShortner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UrlDetails {

    @Id
    private String id;

    private String url;

    @Column(unique = true)
    private String shortUrlKey;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private Date modifiedDate;

    public UrlDetails() {
        this.id = UUID.randomUUID().toString();
    }
}
