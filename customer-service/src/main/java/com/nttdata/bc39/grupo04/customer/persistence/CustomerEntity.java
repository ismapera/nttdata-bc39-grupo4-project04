package com.nttdata.bc39.grupo04.customer.persistence;

import com.nttdata.bc39.grupo04.api.utils.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends BaseResponse implements Serializable {

    @Id
    private String id;
    @Indexed(unique = true)
    private String code;
    private String name;
    private String type;
    private Date date;
}
