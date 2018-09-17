package com.murdock.tools.poi;

import java.util.List;

/**
 * @author weipeng2k 2018年09月17日 下午13:52:34
 */
public class SourceEntry {

    private List<String> picUrls;

    private String reason;

    private String note;

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "SourceEntry{" +
                "picUrls=" + picUrls +
                ", reason='" + reason + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
