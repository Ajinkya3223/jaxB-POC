package com.example.JaxBPoc.soappro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class SendToWalletRequest {
        @XmlElement
        private int TransType;
        @XmlElement
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
        private String DateTime;
}
