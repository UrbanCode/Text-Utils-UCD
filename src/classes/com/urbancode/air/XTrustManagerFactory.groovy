package com.urbancode.air

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactorySpi;

public class XTrustManagerFactory extends TrustManagerFactorySpi {

    //**********************************************************************************************
    // CLASS
    //**********************************************************************************************

    //**********************************************************************************************
    // INSTANCE
    //**********************************************************************************************

    //------------------------------------------------------------------------------------------
    public XTrustManagerFactory() {
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected void engineInit(KeyStore keystore) {
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected void engineInit(ManagerFactoryParameters managerParams)
    throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException(
                "XTrustManagerFactory cannot be initialized using ManagerFactoryParameters");
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected TrustManager[] engineGetTrustManagers() {
        List<TrustManager> managerList = new ArrayList<TrustManager>();
        managerList.add(new OpenX509TrustManager());

        return managerList.toArray(new TrustManager[managerList.size()]);
    }
}