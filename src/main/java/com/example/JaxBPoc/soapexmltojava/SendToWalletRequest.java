package com.example.JaxBPoc.soapexmltojava;

import javax.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class SendToWalletRequest {
        @javax.xml.bind.annotation.XmlElement
        private int TransType;
        @javax.xml.bind.annotation.XmlElement
        private int Amount;
        @XmlElement
        private String Description;
        @XmlElement
        private double Recipient;
        @XmlElement
        private String SMSText;
        @XmlElement
        private int ReqTraceID;
        @XmlElement
        private Date DateTime;
}
