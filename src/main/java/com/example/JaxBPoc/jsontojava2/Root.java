package com.example.JaxBPoc.jsontojava2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root {
    private int merchantPaymentID;
        private int apiPortNumber;
        private int pollerFrequency;
        private String serviceCode;
        private ExtraData extraData;
        private int merchantPaymentStatus;
        private String serviceUrl;
        private String merchantPaymentCurrencyCode;
        private String wrapperUrl;
        private String wsdlFile;
        private String protocol;
        private int sslEnabled;
        private int numberOfSends;
        private String invoiceNumber;
        private String merchantPaymentDate;
        private String merchantPaymentCustomerName;
        private String apiUserName;
        private String merchantPaymentUUID;
        private String merchantPaymentAccountNumber;
        private ArrayList<String> paymentMode;
        private String merchantPaymentMSISDN;
        private String apiFunctionName;
        private ArrayList<String> payerTransactionID;
        private String apiPassword;
        private String paymentUUID;
        private ArrayList<String> payerClientCode;
        private String sslCertificatePath;
        private int isTokenService;
        private int merchantPaymentAmount;
        private String paymentPusherProcessorClass;
        private ArrayList<String> requestOriginIDs;
        private String firstSend;
        private int maxNumberOfSends;
        private String narration;
        private String hubCreationDate;
        private int allowsPolling;
        private int serviceID;
        private String lastSend;
        private String nextSend;
        private int autoAcknowledgePayment;
}
