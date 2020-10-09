package com.desenv2.emailpi.model;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Email {
    private String sender;

    private String recipient;

    private String subject;

    private String content;

    public Email() {
    }

    public Email(String to, String subject, String content) {
        this.recipient = to;
        this.subject = subject;
        this.content = content;
    }

    public Email(String from, String to, String subject, String content) {
        this.sender = from;
        this.recipient = to;
        this.subject = subject;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getHtmlContent() throws Exception {
        InputStream in = getClass().getResourceAsStream("/templates/layoutEmail.html");
        String html = IOUtils.toString(in, StandardCharsets.UTF_8.name());
        return html.replace("<email-content />",this.content);
    }
}
