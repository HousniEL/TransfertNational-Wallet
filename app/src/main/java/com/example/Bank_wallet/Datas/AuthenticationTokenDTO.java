package com.example.Bank_wallet.Datas;

public class AuthenticationTokenDTO {
    private String token;

    private Integer id;

    public AuthenticationTokenDTO(String token, Integer id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public Integer getId() {
        return id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
