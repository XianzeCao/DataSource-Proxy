package com.zaccao.datasourceproxy.proxy.sqlparser;

import java.util.ArrayList;
import java.util.Map;


public interface ParametersHolder {

    Map<Integer, ArrayList<Object>> getParameters();
}
