package com.yizhi.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdCardUtil {
    /**
     * 校验身份证号码是否合法
     *
     * @param idCard 身份证号码
     * @return true：合法；false：不合法
     */
    public static boolean validateCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return false;
        }

        String regex = "^\\d{15}|\\d{18}$";
        if (!idCard.matches(regex)) {
            return false;
        }

        int length = idCard.length();
        if (length == 15) {
            return validate15Card(idCard);
        } else if (length == 18) {
            return validate18Card(idCard);
        } else {
            return false;
        }
    }

    /**
     * 校验身份证号码（15位）是否合法
     *
     * @param idCard 身份证号码（15位）
     * @return true：合法；false：不合法
     */
    private static boolean validate15Card(String idCard) {
        String regex = "^[1-9]\\d{5}\\d{6}\\d{2}[0-9X]$";
        if (!idCard.matches(regex)) {
            return false;
        }

        try {
            Date birthDate = new SimpleDateFormat("yyMMdd").parse(idCard.substring(6, 12));
            return new Date().after(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 校验身份证号码（18位）是否合法
     *
     * @param idCard 身份证号码（18位）
     * @return true：合法；false：不合法
     */
    private static boolean validate18Card(String idCard) {
        String regex = "^[1-9]\\d{5}(18|19|20)\\d{2}" +
                "(0[1-9]|1[0-2])" +
                "([0-2][1-9]|[1-3]0|31)" +
                "\\d{3}[0-9X]$";
        if (!idCard.matches(regex)) {
            return false;
        }

        int[] weights = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            int num = Integer.parseInt(idCard.substring(i, i + 1));
            sum += num * weights[i];
        }
        int remainder = sum % 11;
        String[] codes = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        String checkCode = codes[remainder];
        return checkCode.equals(idCard.substring(17));
    }
}
