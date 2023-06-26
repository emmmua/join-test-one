package com.yizhi.common.utils;

public class PhoneUtil {
    /**
     * 判断手机号格式是否正确
     *
     * @param phone 手机号
     * @return true：格式正确；false：格式不正确
     */
    public static boolean isMobileExact(String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }

        String regex = "^1(3[0-9]|4[57]|5[0-35-9]|6[56]|7[0135-8]|8[0-9]|9[8-9])\\d{8}$";
        return phone.matches(regex);
    }
}
