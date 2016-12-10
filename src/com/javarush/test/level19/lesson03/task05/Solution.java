package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String code = "";
            for (Map.Entry<String, String> map : countries.entrySet()) {
                code = customer.getCountryName().equals(map.getValue()) ? map.getKey() : code;
            }
            return code;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] s = contact.getName().split(",");
            return s[1].trim();
        }

        @Override
        public String getContactLastName() {
            String[] s = contact.getName().split(",");
            return s[0].trim();
        }

        @Override
        public String getDialString() {
            char[] ch = contact.getPhoneNumber().toCharArray();
            StringBuilder sb = new StringBuilder("+");
            for (int i = 1; i < ch.length; i++) {
                if (Character.isDigit(ch[i])) {
                    sb.append(ch[i]);
                }
            }
            return "callto://" + sb;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

}