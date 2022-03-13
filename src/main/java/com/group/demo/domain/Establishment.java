package com.group.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Establishment {

    @Generated
    @Id
    private String id;

    private String establishmentId;

    private String name;

    private String city;

    private String ratingValue;
}
