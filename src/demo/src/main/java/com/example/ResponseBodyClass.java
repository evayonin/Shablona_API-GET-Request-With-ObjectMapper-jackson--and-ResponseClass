package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // התעלמות מפרמטרים שאנחנו לא צריכים/לא רוצים שיהיו בשדות
public class ResponseBodyClass {
  // הרלוונטים:
  private String param1;
  private String param2;
  private String param3;
  // כולם מחרוזות לפי הפרמטרים במבנה גייסון!

  public String getParam1() {
    return param1;
  }

  public String getParam2() {
    return param2;
  }

  public String getParam3() {
    return param3;
  }

  public String toString() {
    return "ResponseBodyClass{" +
        "param1='" + param1 + '\'' + "\n" +
        ", param2='" + param2 + '\'' + "\n" +
        ", param3='" + param3 + '\'' + "\n" +
        '}';
  }

}
