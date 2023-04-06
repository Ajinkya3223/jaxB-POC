package com.example.JaxBPoc.soappro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "SendToWallet")
@XmlAccessorType(XmlAccessType.FIELD)
public class SendToWallet {

    @XmlElement
    private StrReq strReq;
}
