
package com.eagle.commons.web.controller.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.ObjectError;

import java.util.List;

public class PostResponse {
    private boolean hasErrors;
    private String[] errorList;
    private Object result;

    public PostResponse() {
    }

    public PostResponse(List<ObjectError> allErrors) {
        setErrors(allErrors);
    }

    public void setErrors(String[] errors) {
        this.errorList = errors;

        if (errors.length > 0) {
            hasErrors = true;
        }
    }

    public void setErrors(List<ObjectError> allErrors) {
        if (!allErrors.isEmpty()) {

            errorList = new String[allErrors.size()];
            int c = 0;
            for (ObjectError allError : allErrors) {
                errorList[c++] = allError.getDefaultMessage();
            }

            hasErrors = true;
        }
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public String[] getErrorList() {
        return errorList;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        String strResponse = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            strResponse = mapper.writer().writeValueAsString(this);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            strResponse = "Processing error ...";
        }
        return strResponse;
    }
}
