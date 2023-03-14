package com.example.hom_thu_dien_tu.repository;

import com.example.hom_thu_dien_tu.entity.EmailConfig;

public class EmailConfigRepositories {
    private EmailConfig emailConfig = new EmailConfig("Vietnamese",25,true,"thor");

    public EmailConfigRepositories() {
    }

    public EmailConfig getEmailConfig() {
        return emailConfig;
    }

    public void setEmailConfig(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }
}
