package com.group9.group09.DTO;

public class ResponseDTO {

    String respCde;
    String respMsg;
    boolean respStatus = false;

    public String getRespCde() {
        return respCde;
    }

    public void setRespCde(String respCde) {
        this.respCde = respCde;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public boolean isRespStatus() {
        return respStatus;
    }

    public void setRespStatus(boolean respStatus) {
        this.respStatus = respStatus;
    }
}
