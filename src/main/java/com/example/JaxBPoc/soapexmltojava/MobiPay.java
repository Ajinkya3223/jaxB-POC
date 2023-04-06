package com.example.JaxBPoc.soapexmltojava;

import javax.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class MobiPay {
    @XmlElement
    private double ver;
    @XmlElement
    private String InstitutionID;
    @XmlElement
    private String  UserName;
    @XmlElement
    private String Password;
    @XmlElement
    private SendToWalletRequest sendtoWalletRequest;
}
