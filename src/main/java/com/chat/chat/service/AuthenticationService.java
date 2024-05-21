package com.chat.chat.service;

import com.chat.chat.request.AuthenticationRequest;
import com.chat.chat.request.IntrospactRequest;
import com.chat.chat.response.AuthenticationResponse;
import com.chat.chat.response.IntrospactResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) ;
    IntrospactResponse introspect(IntrospactRequest request) throws JOSEException, ParseException;
}
