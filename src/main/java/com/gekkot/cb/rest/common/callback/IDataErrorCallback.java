package com.gekkot.cb.rest.common.callback;

import com.gekkot.cb.rest.common.exception.DataError;

public interface IDataErrorCallback {

    void onGetDataError(DataError dataError);

}
