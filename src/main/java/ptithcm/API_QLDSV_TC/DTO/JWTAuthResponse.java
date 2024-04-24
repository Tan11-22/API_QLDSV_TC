package ptithcm.API_QLDSV_TC.DTO;



public class JWTAuthResponse {
    private String accessToken;
    private String tokenType;

    public JWTAuthResponse() {
        this.tokenType = "Bearer";
    }
    public JWTAuthResponse(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
    public String getAccessToken() {
        return accessToken;
    }



    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "JWTAuthResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                '}';
    }
}
