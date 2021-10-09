package br.com.diolabs.personapi.enums;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneTypeEnum {

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;

    public static PhoneTypeEnum getPhoneTypeEnum(String description) throws FileNotFoundException {        
        return Stream.of(values()).filter(p->p.getDescription().equals(description)).findFirst().orElseThrow(FileNotFoundException::new);      
    }   
    
}
