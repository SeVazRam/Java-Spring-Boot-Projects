package com.example.demo.model.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AccountUpdate {

	@NotBlank(message = "customerId es obligatorio")
    @Pattern(regexp = "^[0-9]{1,12}$", message = "customerId debe contener de 1 a 12 dígitos")
    private String customerId;

    @NotBlank(message = "productCode es obligatorio")
    @Pattern(regexp = "^[0-9]{1,4}$", message = "productCode debe contener de 1 a 4 dígitos")
    private String productCode;

    @NotBlank(message = "productInstrument es obligatorio")
    @Pattern(regexp = "^[0-9]{1,4}$", message = "productInstrument debe contener de 1 a 4 dígitos")
    private String productInstrument;

    @NotBlank(message = "accountNumber es obligatorio")
    @Pattern(regexp = "^[0-9]{1,16}$", message = "accountNumber debe contener de 1 a 16 dígitos")
    private String accountNumber;
    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductInstrument() {
        return productInstrument;
    }

    public void setProductInstrument(String productInstrument) {
        this.productInstrument = productInstrument;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}





