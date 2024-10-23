package com.example.basic.image.entity;

import com.example.basic.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image extends BaseTimeEntity {
    @Id
    @Column(name = "IMAGE_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String imageUrl;
    private String originImageName;
    private String imageName;
    private String representImageYn;
}
