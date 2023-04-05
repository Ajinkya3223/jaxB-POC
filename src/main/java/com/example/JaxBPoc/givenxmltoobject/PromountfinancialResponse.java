package com.example.JaxBPoc.givenxmltoobject;

import jakarta.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="promountfinancialresponse")
@XmlAccessorType(XmlAccessType.PROPERTY)


    public class PromountfinancialResponse {
    @XmlElement
    private String function;

    @XmlElement
        private String receiptDate;


    @XmlElement
    private int cashierNo;


    @XmlElement
    private String date;

    @XmlElement
    private String mcno;

    @XmlElement
    private String operator;
    @XmlElement
    private long reference;
    @XmlElement(name="recno",namespace="")
    private long recno;
    @XmlElement(name="paytype",namespace="")
    private String paytype;
    @XmlElement(name="icode",namespace="")
    private String icode;
    @XmlElement(name="account",namespace="")
    private long account;
    @XmlElement(name="ref",namespace="")
    private long ref;
    @XmlElement(name="amount",namespace="")
    private long amount;





}

