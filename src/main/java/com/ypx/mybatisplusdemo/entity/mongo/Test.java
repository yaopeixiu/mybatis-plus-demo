package com.ypx.mybatisplusdemo.entity.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("testdb")
public class Test {
    private Integer opretion;

    private Integer count;
}
