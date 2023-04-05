package com.example.JaxBPoc.givenjsontomap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthStatus {
    private int authStatusCode;
    private String authStatusDescription;
}
