package io.github.jhipster.jdl.language;

public class JdlOptionRule {
  private boolean skipClient;
  private boolean skipServer;
  private boolean noFluentMethod;
  private boolean filter;
  private boolean readOnly;

  private String dto = "no";
  private String service = "no";
  private String paginate = "no";
  private String search = "no";

  private String microservice;
  private String angularSuffix;
  private String clientRootFolder;

  public boolean isSkipClient() {
    return skipClient;
  }

  public void setSkipClient(boolean skipClient) {
    this.skipClient = skipClient;
  }

  public boolean isSkipServer() {
    return skipServer;
  }

  public void setSkipServer(boolean skipServer) {
    this.skipServer = skipServer;
  }

  public boolean isNoFluentMethod() {
    return noFluentMethod;
  }

  public void setNoFluentMethod(boolean noFluentMethod) {
    this.noFluentMethod = noFluentMethod;
  }

  public boolean isFilter() {
    return filter;
  }

  public void setFilter(boolean filter) {
    this.filter = filter;
  }

  public boolean isReadOnly() {
    return readOnly;
  }

  public void setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
  }

  public String getDto() {
    return dto;
  }

  public void setDto(String dto) {
    this.dto = dto;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getPaginate() {
    return paginate;
  }

  public void setPaginate(String paginate) {
    this.paginate = paginate;
  }

  public String getSearch() {
    return search;
  }

  public void setSearch(String search) {
    this.search = search;
  }

  public String getMicroservice() {
    return microservice;
  }

  public void setMicroservice(String microservice) {
    this.microservice = microservice;
  }

  public String getAngularSuffix() {
    return angularSuffix;
  }

  public void setAngularSuffix(String angularSuffix) {
    this.angularSuffix = angularSuffix;
  }

  public String getClientRootFolder() {
    return clientRootFolder;
  }

  public void setClientRootFolder(String clientRootFolder) {
    this.clientRootFolder = clientRootFolder;
  }
}
