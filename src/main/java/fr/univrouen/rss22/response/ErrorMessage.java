package fr.univrouen.rss22.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@JacksonXmlRootElement(localName = "Erreur")
public class ErrorMessage {


    @JacksonXmlProperty
    private Date timestamp;

    @JacksonXmlProperty
    private String exception;

    @JacksonXmlProperty
    private String message;

    @JacksonXmlProperty
    private String cause;

}