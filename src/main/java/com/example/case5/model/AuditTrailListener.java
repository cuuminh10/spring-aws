package com.example.case5.model;

import jakarta.persistence.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class AuditTrailListener {
    private static Log log = LogFactory.getLog(AuditTrailListener.class);
    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Object user) {
        log.info("[USER AUDIT] About to add a user");
    }
    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Object user) {
        log.info("[USER AUDIT] add/update/delete complete for user: ");
    }
    @PostLoad
    private void afterLoad(Object user) {
        log.info("[USER AUDIT] user loaded from database: ");
    }
}