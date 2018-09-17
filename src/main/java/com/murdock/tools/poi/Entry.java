package com.murdock.tools.poi;

/**
 * @author weipeng2k 2018年09月17日 上午11:09:47
 */
public class Entry {

    private String url;

    private String reason;

    private String note;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    /**
     * output render url|reason|note
     *
     * @return output content
     */
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("|");
        if (reason != null) {
            sb.append(reason);
        }
        sb.append("|");
        if (note != null) {
            sb.append(note);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Entry{" +
                "url='" + url + '\'' +
                ", reason='" + reason + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
