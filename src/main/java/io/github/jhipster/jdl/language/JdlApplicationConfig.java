package io.github.jhipster.jdl.language;

import java.util.ArrayList;
import java.util.List;

public class JdlApplicationConfig {

  private String applicationType;
  private String authenticationType;
  private String baseName;
  private String buildTool;
  private String cacheProvider;
  private String clientFramework;
  private String clientPackageManager;
  private String clientTheme;
  private String clientThemeVariant;
  private String databaseType;
  private String devDatabaseType;
  private String dtoSuffix;

  private boolean enableHibernateCache;
  private boolean enableSwaggerCodegen;
  private boolean enableTranslation;

  private String entitySuffix;
  private String jhiPrefix;

  private List<String> languages;
  private String messageBroker;
  private String nativeLanguage;

  private String packageName;
  private String prodDatabaseType;
  private boolean reactive;
  private String searchEngine;
  private int serverPort;
  private String serviceDiscoveryType;

  private boolean skipClient;
  private boolean skipServer;
  private boolean skipUserManagement;
  private List<String> testFrameworks = new ArrayList<>();
  private boolean useSass;

  public String getApplicationType() {
    return applicationType;
  }

  public void setApplicationType(String applicationType) {
    this.applicationType = applicationType;
  }

  public String getAuthenticationType() {
    return authenticationType;
  }

  public void setAuthenticationType(String authenticationType) {
    this.authenticationType = authenticationType;
  }

  public String getBaseName() {
    return baseName;
  }

  public void setBaseName(String baseName) {
    this.baseName = baseName;
  }

  public String getBuildTool() {
    return buildTool;
  }

  public void setBuildTool(String buildTool) {
    this.buildTool = buildTool;
  }

  public String getCacheProvider() {
    return cacheProvider;
  }

  public void setCacheProvider(String cacheProvider) {
    this.cacheProvider = cacheProvider;
  }

  public String getClientFramework() {
    return clientFramework;
  }

  public void setClientFramework(String clientFramework) {
    this.clientFramework = clientFramework;
  }

  public String getClientPackageManager() {
    return clientPackageManager;
  }

  public void setClientPackageManager(String clientPackageManager) {
    this.clientPackageManager = clientPackageManager;
  }

  public String getClientTheme() {
    return clientTheme;
  }

  public void setClientTheme(String clientTheme) {
    this.clientTheme = clientTheme;
  }

  public String getClientThemeVariant() {
    return clientThemeVariant;
  }

  public void setClientThemeVariant(String clientThemeVariant) {
    this.clientThemeVariant = clientThemeVariant;
  }

  public String getDatabaseType() {
    return databaseType;
  }

  public void setDatabaseType(String databaseType) {
    this.databaseType = databaseType;
  }

  public String getDevDatabaseType() {
    return devDatabaseType;
  }

  public void setDevDatabaseType(String devDatabaseType) {
    this.devDatabaseType = devDatabaseType;
  }

  public String getDtoSuffix() {
    return dtoSuffix;
  }

  public void setDtoSuffix(String dtoSuffix) {
    this.dtoSuffix = dtoSuffix;
  }

  public boolean isEnableHibernateCache() {
    return enableHibernateCache;
  }

  public void setEnableHibernateCache(boolean enableHibernateCache) {
    this.enableHibernateCache = enableHibernateCache;
  }

  public boolean isEnableSwaggerCodegen() {
    return enableSwaggerCodegen;
  }

  public void setEnableSwaggerCodegen(boolean enableSwaggerCodegen) {
    this.enableSwaggerCodegen = enableSwaggerCodegen;
  }

  public boolean isEnableTranslation() {
    return enableTranslation;
  }

  public void setEnableTranslation(boolean enableTranslation) {
    this.enableTranslation = enableTranslation;
  }

  public String getEntitySuffix() {
    return entitySuffix;
  }

  public void setEntitySuffix(String entitySuffix) {
    this.entitySuffix = entitySuffix;
  }

  public String getJhiPrefix() {
    return jhiPrefix;
  }

  public void setJhiPrefix(String jhiPrefix) {
    this.jhiPrefix = jhiPrefix;
  }

  public List<String> getLanguages() {
    return languages;
  }

  public void setLanguages(List<String> languages) {
    this.languages = languages;
  }

  public String getMessageBroker() {
    return messageBroker;
  }

  public void setMessageBroker(String messageBroker) {
    this.messageBroker = messageBroker;
  }

  public String getNativeLanguage() {
    return nativeLanguage;
  }

  public void setNativeLanguage(String nativeLanguage) {
    this.nativeLanguage = nativeLanguage;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getProdDatabaseType() {
    return prodDatabaseType;
  }

  public void setProdDatabaseType(String prodDatabaseType) {
    this.prodDatabaseType = prodDatabaseType;
  }

  public boolean isReactive() {
    return reactive;
  }

  public void setReactive(boolean reactive) {
    this.reactive = reactive;
  }

  public String getSearchEngine() {
    return searchEngine;
  }

  public void setSearchEngine(String searchEngine) {
    this.searchEngine = searchEngine;
  }

  public int getServerPort() {
    return serverPort;
  }

  public void setServerPort(int serverPort) {
    this.serverPort = serverPort;
  }

  public String getServiceDiscoveryType() {
    return serviceDiscoveryType;
  }

  public void setServiceDiscoveryType(String serviceDiscoveryType) {
    this.serviceDiscoveryType = serviceDiscoveryType;
  }

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

  public boolean isSkipUserManagement() {
    return skipUserManagement;
  }

  public void setSkipUserManagement(boolean skipUserManagement) {
    this.skipUserManagement = skipUserManagement;
  }

  public List<String> getTestFrameworks() {
    return testFrameworks;
  }

  public void setTestFrameworks(List<String> testFrameworks) {
    this.testFrameworks = testFrameworks;
  }

  public boolean isUseSass() {
    return useSass;
  }

  public void setUseSass(boolean useSass) {
    this.useSass = useSass;
  }
}
