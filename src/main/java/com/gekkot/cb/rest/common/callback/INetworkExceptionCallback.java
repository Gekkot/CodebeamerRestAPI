package com.gekkot.cb.rest.common.callback;

import java.io.IOException;

public interface INetworkExceptionCallback {
    void onGetNetworkException(IOException exception);
}
