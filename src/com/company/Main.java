package com.company;

public class Main {

  private static final String REGEX1 = "[!.,:;\\-?\" )]";
  private static final String REGEX2 = "\\d+";

  public static void main(String[] args) {
    String s1 = "Тестовая, строка, с 12несколькими,, запятыми! "
        + "Тест- строка: знаки? препинания. Многоточие... \"Каввычки\"  (Скобки)";
    String s2 = "Черный, в защитной пленке. Найден сегодня на скамейке возле Сильвер Тауэр. "
        + "Тестовый текст. Тест: text. Test: text.";
    String s3 = "Тестовая, строка, с 12несколькими,, запятыми!";
    String s4 = "Текст окно знак";

    countingPunctuationMarks(s1);
    wordNumber(s1);
    countingPunctuationMarks(s2);
    wordNumber(s2);
    lastCharWord(s3);
    lastCharWord(s4);

    StringBuilder sb = new StringBuilder(s1);
    double startTime = System.currentTimeMillis();
    for (int i = 0; i < 2000; i++) {
      sb.append(s2);
    }
    double finish = System.currentTimeMillis();
    System.out
        .println("Сложение строк со StringBuilder: " + (finish - startTime) + " миллисекунд.");

    double startTime2 = System.currentTimeMillis();
    for (int i = 0; i < 2000; i++) {
      s1 = s1 + s2;
    }
    double finish2 = System.currentTimeMillis();
    System.out
        .println("Сложение строк без StringBuilder: " + (finish2 - startTime2) + " миллисекунд.");


  }

  static void countingPunctuationMarks(String s) {
    int charNumber = 0;
    char c;

    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (c == ',' || c == '.' || c == '!' || c == '?' || c == ':' ||
          c == '-' || c == ';') {
        ++charNumber;
      }
      if (c == '(' || c == ')' || c == '"') {
        ++charNumber;
      }

    }
    System.out.println("Количество знаков препинания: " + charNumber);
  }

  static void wordNumber(String s) {
    int wordCount = 0;

    if (s.charAt(0) != ' ') {
      wordCount++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ' && i + 1 < s.length() && s.charAt(i + 1) != ' ') {
        wordCount++;
      }
    }
    System.out.println("Количество слов в тексте: " + wordCount);
  }

  static void lastCharWord(String s) {
    s = s.replaceAll(REGEX1, " ");
    s = s.replaceAll(REGEX2, " ");
    char c;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (c != ' ' && i + 1 < s.length()) {
        if (s.charAt(i + 1) == ' ') {
          System.out.print(c + " ");
        }
      }
    }
    if (s.charAt(s.length() - 1) != ' ') {
      System.out.print(s.charAt(s.length() - 1));
    }
    System.out.println();
  }
}
