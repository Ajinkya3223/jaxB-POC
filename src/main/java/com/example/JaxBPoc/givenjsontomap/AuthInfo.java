package com.example.JaxBPoc.givenjsontomap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfo {
    private AuthStatus authStatus;
    private ArrayList<Result> results;
}
