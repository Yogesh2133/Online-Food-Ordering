package com.yogesh.dto;

import com.yogesh.model.Restaurant;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Embeddable
@Data
public class RestaurantDto {
    private String title;
    @Column(length = 1000)
    private List<String> images;
    private String description;
    private Long id;

}
