package com.example.JaxBPoc.givenjsontomap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int statusCode;
    private String statusDescription;
    private String invoiceNumber;
    private String beepTransactionID;
}
