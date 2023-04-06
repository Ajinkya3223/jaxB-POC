package com.example.JaxBPoc.soaptojavabasic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "LoginResult", namespace = "http://test.org/ADMail_Service")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResult {
    @XmlElement(name = "ErrorMessage", namespace = "http://test.org/ADMail_Service")
    private String errorMessage;
    @XmlElement(name = "Status", namespace = "http://test.org/ADMail_Service")
    private String status;


}