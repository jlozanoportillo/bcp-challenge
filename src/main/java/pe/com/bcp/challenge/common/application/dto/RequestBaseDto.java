package pe.com.bcp.challenge.common.application.dto;

public class RequestBaseDto {
  protected RequestBodyType requestBodyType;

  public RequestBodyType getRequestBodyType() {
    return requestBodyType;
  }

  public void setRequestBodyType(RequestBodyType requestBodyType) {
    this.requestBodyType = requestBodyType;
  }
}
