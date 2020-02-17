package com.sprince0031;

import java.io.IOException;
import java.util.Base64;

public class AuthService {

    public boolean authenticate(String authCredentials) {

        if (null == authCredentials) {
            return false;
        }

        final String encodedCreds = authCredentials.replaceFirst("Basic ", "");

        String credentials = null;
        try {
            byte[] decoded = Base64.getDecoder().decode(encodedCreds);
            credentials = new String(decoded, "UTF-8");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        
        final String[] creds = credentials.split(":");

        if ("admin".equals(creds[0]) && "admin".equals(creds[1])) {
            return true;
        } else {
            return false;
        } 
    }
}