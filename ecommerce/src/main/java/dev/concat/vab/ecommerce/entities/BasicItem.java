package dev.concat.vab.ecommerce.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public class BasicItem implements Serializable {
    @Version
    Integer version = 0;
    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt = LocalDateTime.now();
    @CreatedBy
    @Column(name = "created_by")
    String createdBy = null;
    @LastModifiedBy
    @Column(name = "updated_by")
    String updatedBy = null;
}
