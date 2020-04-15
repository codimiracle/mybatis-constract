package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.mybatis.contract.annotation.LogicDelete;
import com.codimiracle.web.mybatis.contract.annotation.LogicDeletedDate;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "dummy")
public class Dummy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value")
    private String value;

    @LogicDelete
    @Column(name = "deleted")
    private Boolean deleted;

    @LogicDeletedDate
    @Column(name = "deleted_at")
    private Date deletedAt;
}
