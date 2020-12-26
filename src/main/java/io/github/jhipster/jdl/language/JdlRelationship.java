package io.github.jhipster.jdl.language;

public class JdlRelationship {

  private String relationshipType;
  private String relationshipName;
  private String otherEntityName;
  private String otherEntityRelationshipName;
  private String otherEntityField;

  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public String getRelationshipName() {
    return relationshipName;
  }

  public void setRelationshipName(String relationshipName) {
    this.relationshipName = relationshipName;
  }

  public String getOtherEntityName() {
    return otherEntityName;
  }

  public void setOtherEntityName(String otherEntityName) {
    this.otherEntityName = otherEntityName;
  }

  public String getOtherEntityRelationshipName() {
    return otherEntityRelationshipName;
  }

  public void setOtherEntityRelationshipName(String otherEntityRelationshipName) {
    this.otherEntityRelationshipName = otherEntityRelationshipName;
  }

  public String getOtherEntityField() {
    return otherEntityField;
  }

  public void setOtherEntityField(String otherEntityField) {
    this.otherEntityField = otherEntityField;
  }
}
