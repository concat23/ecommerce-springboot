package dev.concat.vab.ecommerce.entities;

import java.time.LocalDateTime;

import dev.concat.vab.ecommerce.utilities.IDGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter @Setter
public class BasicEntity extends BasicItem{

    private String id;

    public BasicEntity(){
        id = IDGenerator.generateRandomID();
    }
    
}
