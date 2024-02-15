package com.tbh.hackathon.hackathonws.chat;

public class HelloMessage {

  private String name;

  private String text;

  private String to;

  public String getText() {
      return text;
  }

  public String getTo() {
      return to;
  }

  public void setTo(String to) {
      this.to = to;
  }
}