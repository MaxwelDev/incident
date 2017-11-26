package br.com.incident.domain.orm;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class Responsible implements Serializable {

    @Id
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ApiModelProperty(readOnly = true)
    private String name;

    @ApiModelProperty(readOnly = true)
    private Integer position;

    @ApiModelProperty(readOnly = true)
    private LocalDate date;

    @Transient
    @ApiModelProperty(readOnly = true)
    private String aliasDate;

}