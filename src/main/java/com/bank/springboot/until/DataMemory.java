package com.bank.springboot.until;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class DataMemory {
    /**
     * memory data capacity
     */
    public static final ConcurrentHashMap<String, String> DATA_MAP = new ConcurrentHashMap<String, String>();

    /**
     * key customer_info_customerId
     */
    public static final String PRE_CUSTOMER_INFO_KEY = "customer_info_";
    /**
     * total bank_balance key
     */
    public static final String BANK_BALANCE = "bank_balance";

    public static BigDecimal getBalance(String key) {
        String balance = DATA_MAP.get(key);
        if (StringUtils.isBlank(balance)) {
            balance = "0";
        }
        return new BigDecimal(balance);
    }

    /**
     * init method，load data from db or config file
     */
/**    private void initDataMap() {
        //TODO
        String bankBalance = DATA_MAP.get(BANK_BALANCE);
        if (StringUtils.isBlank(bankBalance)) {
            DATA_MAP.put(DataMemory.BANK_BALANCE, "0");
        }
    }*/

    /**
     * init data and refresh data
     */
    class Task implements Runnable {
        @Override
        public void run() {
            //TODO
        }
    }
}
