package com.example.JaxBPoc.javaToxml;

import   jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="department")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
  @XmlElement
  private    Integer id;
  @XmlElement
  private  String name;

}
