package io.github.jhipster.jdl.language;

import com.intellij.psi.util.PsiTreeUtil;
import io.github.jhipster.jdl.language.validation.JdlValidation;
import io.github.jhipster.jdl.language.validation.JdlValidationMapping;
import io.github.jhipster.jdl.psi.JdlApplicationDefinition;
import io.github.jhipster.jdl.psi.JdlConfigItem;
import io.github.jhipster.jdl.psi.JdlEntityDefinition;
import io.github.jhipster.jdl.psi.JdlEnumConstantDeclaration;
import io.github.jhipster.jdl.psi.JdlEnumDefinition;
import io.github.jhipster.jdl.psi.JdlExcludeEntityNames;
import io.github.jhipster.jdl.psi.JdlFieldMember;
import io.github.jhipster.jdl.psi.JdlFieldValidation;
import io.github.jhipster.jdl.psi.JdlFile;
import io.github.jhipster.jdl.psi.JdlIncludeEntityNames;
import io.github.jhipster.jdl.psi.JdlOptionDefinition;
import io.github.jhipster.jdl.psi.JdlRelationshipBody;
import io.github.jhipster.jdl.psi.JdlRelationshipDefinition;
import io.github.jhipster.jdl.psi.JdlRelationshipItems;
import io.github.jhipster.jdl.psi.JdlRelationshipType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class JdlLanguageParser {

  private final Map<String, JdlEntity> entitiesMap = new HashMap<>();
  private final Map<String, JdlEntity> enumsMap = new HashMap<>();
  private final Map<String, JdlApplication> applicationsMap = new HashMap<>();
  private final List<JdlOption> options = new ArrayList<>();

  public Collection<JdlEntity> getEntities() {
    return entitiesMap.values();
  }

  public Collection<JdlEntity> getEnums() {
    return enumsMap.values();
  }

  public Collection<JdlApplication> getApplications() {
    return applicationsMap.values();
  }

  public List<JdlOption> getOptions() {
    return options;
  }

  private JdlLanguageParser() {
  }

  private void parseEnums(JdlFile jdlFile) {
    List<JdlEnumDefinition> enumDefinitions = jdlFile.getEnumDefinitions();
    for (JdlEnumDefinition enumDefinition : enumDefinitions) {
      String name = enumDefinition.getName();
      JdlEntity entity = new JdlEntity(name, true);
      List<JdlEnumConstantDeclaration> enumConstantDeclarationList = enumDefinition.getEnumConstantDeclarationList();
      for (JdlEnumConstantDeclaration enumConstantDeclaration : enumConstantDeclarationList) {
        entity.getFields().add(new JdlField(enumConstantDeclaration.getText()));
      }
      enumsMap.put(name, entity);
    }
  }

  private void parseEntities(JdlFile jdlFile) {
    List<JdlEntityDefinition> entityDefinitions = jdlFile.getEntityDefinitions();
    for (JdlEntityDefinition entityDefinition : entityDefinitions) {
      String name = entityDefinition.getName();
      JdlEntity entity = new JdlEntity(name);
      if (entityDefinition.getEntityTypeBody() != null) {
        List<JdlFieldMember> memberList = entityDefinition.getEntityTypeBody().getFieldMemberList();
        for (JdlFieldMember member : memberList) {
          JdlField field = new JdlField();
          field.setName(member.getComponentName().getText());
          String fieldTypeText = member.getFieldTypeDefinition().getText();
          if (enumsMap.containsKey(fieldTypeText)) {
            field.setType(JdlFieldType.Enum);
          } else {
            field.setType(JdlFieldType.from(fieldTypeText));
          }
          field.setTypeName(fieldTypeText);
          if (member.getFieldValidations() != null) {
            List<JdlFieldValidation> validationList = member.getFieldValidations().getFieldValidationList();
            for (JdlFieldValidation fieldValidation : validationList) {
              String validation = fieldValidation.getText();
              String prefix = validation;
              if (StringUtils.indexOf(validation, "(") > 0) {
                prefix = StringUtils.substringBefore(validation, "(").trim();
              }
              JdlValidation jdlValidation = JdlValidationMapping.from(prefix, validation);
              field.getValidations().add(jdlValidation);
            }
          }
          entity.getFields().add(field);
        }
      }
      entitiesMap.put(name, entity);
    }
  }

  private void parseOptions(JdlFile jdlFile) {
    List<JdlOptionDefinition> optionDefinitions = jdlFile.getOptionDefinitions();
    for (JdlOptionDefinition jdlOption : optionDefinitions) {
      String optionName = jdlOption.getOptionName().getText();
      String optionTypeValue = jdlOption.getOptionTypeValue().getText();
      JdlOption option = new JdlOption();
      option.setName(optionName);
      option.setValue(optionTypeValue);

      JdlIncludeEntityNames includeEntityNames = jdlOption.getIncludeEntityNames();
      if (includeEntityNames == null) {
        option.getIncludeEntities().addAll(getEntities());
      } else {
        List<String> includeNames = includeEntityNames.getComponentNameList().stream().map(jdlComponentName -> jdlComponentName.getText())
            .collect(Collectors.toList());
        for (String name : includeNames) {
          option.getIncludeEntities().add(entitiesMap.get(name));
        }
      }

      JdlExcludeEntityNames excludeEntityNames = jdlOption.getExcludeEntityNames();
      if (excludeEntityNames == null) {
        option.getExcludeEntities().addAll(getEntities());
      } else {
        List<String> excludeNames = excludeEntityNames.getComponentNameList().stream().map(jdlComponentName -> jdlComponentName.getText())
            .collect(Collectors.toList());
        for (String name : excludeNames) {
          option.getExcludeEntities().add(entitiesMap.get(name));
        }
      }

      options.add(option);
    }
  }


  private void parseRelationships(JdlFile jdlFile) {
    List<JdlRelationshipDefinition> relationshipDefinitions = jdlFile.getRelationshipDefinitions();
    for (JdlRelationshipDefinition relationshipDefinition : relationshipDefinitions) {
      JdlRelationshipType relationshipType = relationshipDefinition.getRelationshipType();
      if (relationshipType!=null) {
        String relationshipTypeName = relationshipType.getText();
        JdlRelationshipBody relationshipBody = relationshipDefinition.getRelationshipBody();
        List<JdlRelationshipItems> relationshipItemsList = relationshipBody.getRelationshipItemsList();
        for (JdlRelationshipItems jdlRelationshipItems : relationshipItemsList) {
           String  sourceEntityName =  jdlRelationshipItems.getRelationshipSourceType().getComponentName().getText();
           String  targetEntityName =  jdlRelationshipItems.getRelationshipTargetType().getComponentName().getText();
           if (StringUtils.isNotEmpty(sourceEntityName) && StringUtils.isNotEmpty(targetEntityName) && entitiesMap.containsKey(sourceEntityName) && entitiesMap.containsKey(targetEntityName)) {

             JdlEntity sourceEntity = entitiesMap.get(sourceEntityName);
             JdlEntity targetEntity = entitiesMap.get(targetEntityName);

             JdlRelationship sourceRelationship = new JdlRelationship();
             JdlRelationship targetRelationship = new JdlRelationship();

             sourceRelationship.setRelationshipType(relationshipTypeName);
             targetRelationship.setRelationshipType(relationshipTypeName);

             sourceEntity.getRelationships().add(sourceRelationship);
             targetEntity.getRelationships().add(targetRelationship);

           }
        }
      }
    }
  }

  private void parseApplications(JdlFile jdlFile) {
    List<JdlApplicationDefinition> applicationDefinitions = jdlFile.getApplicationDefinitions();
    for (JdlApplicationDefinition applicationDefinition : applicationDefinitions) {
      JdlApplication jdlApplication = new JdlApplication();
      Map<String, Object> values = parseApplicationConfig(applicationDefinition);
      setValuesToConfig(values, jdlApplication);

      applicationsMap.put(jdlApplication.getBaseName(), jdlApplication);
    }
  }

  private void setValuesToConfig(Map<String, Object> values, JdlApplication jdlApplication) {
    Set<Entry<String, Object>> entrySet = values.entrySet();
    for (Map.Entry<String, Object> entry : entrySet) {
      try {
        Field field = JdlApplicationConfig.class.getDeclaredField(entry.getKey());
        field.setAccessible(true);
        field.set(jdlApplication, entry.getValue());
      } catch (NoSuchFieldException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }

  private Map<String, Object> parseApplicationConfig(JdlApplicationDefinition applicationDefinition) {
    Map<String, Object> values = new LinkedHashMap<>();
    Collection<JdlConfigItem> configItems = PsiTreeUtil.findChildrenOfAnyType(applicationDefinition, JdlConfigItem.class);
    configItems.stream().forEach(jdlConfigItem -> {
      if (jdlConfigItem.getConfigArrayItem() != null) {
        values.put(jdlConfigItem.getConfigArrayItem().getConfigArrayItemKey().getText(),
            jdlConfigItem.getConfigArrayItem().getConfigArrayItemValueList().stream()
                .map(jdlConfigArrayItemValue -> jdlConfigArrayItemValue.getText()).collect(Collectors.toList()));
      }
      if (jdlConfigItem.getConfigBooleanItem() != null) {
        values.put(jdlConfigItem.getConfigBooleanItem().getConfigBooleanItemKey().getText(),
            Boolean.valueOf(jdlConfigItem.getConfigBooleanItem().getConfigBooleanItemValue().getText()));
      }
      if (jdlConfigItem.getPackageNameConfigItem() != null) {
        values.put("packageName", jdlConfigItem.getPackageNameConfigItem().getPackageNameIdentifier().getText());
      }
      if (jdlConfigItem.getConfigStringItem() != null) {
        values.put(jdlConfigItem.getConfigStringItem().getConfigStringItemKey().getText(),
            jdlConfigItem.getConfigStringItem().getConfigStringItemValue().getText());
      }
      if (jdlConfigItem.getConfigNumberItem() != null) {
        values.put(jdlConfigItem.getConfigNumberItem().getConfigNumberItemKey().getText(),
            NumberUtils.toInt(jdlConfigItem.getConfigNumberItem().getConfigNumberItemValue().getText(), 0));
      }
    });
    return values;
  }

  public void printForTest() {
    Collection<JdlEntity> entities = getEntities();
    Collection<JdlEntity> enums = getEnums();

    for (JdlEntity entity : enums) {
      System.out.println("enum " + entity.getName() + "{");
      List<JdlField> fields = entity.getFields();
      System.out.println("    " + StringUtils.join(fields.stream().map(JdlField::getName).collect(Collectors.toList()), ", "));
      System.out.println("}");
    }

    for (JdlEntity entity : entities) {
      System.out.println("entity " + entity.getName() + "{");
      List<JdlField> fields = entity.getFields();
      for (JdlField field : fields) {
        List<JdlValidation> validations = field.getValidations();
        System.out.println("    " + field.getName() + " " + field.getTypeName() + " " + StringUtils
            .join(validations.stream().map(JdlValidation::getValue).collect(Collectors.toList()), " "));
      }
      System.out.println("}");
    }
  }

  public static JdlLanguageParser from(JdlFile jdlFile) {
    JdlLanguageParser jdlLanguageParser = new JdlLanguageParser();
    jdlLanguageParser.parseEnums(jdlFile);
    jdlLanguageParser.parseEntities(jdlFile);
    jdlLanguageParser.parseOptions(jdlFile);
    jdlLanguageParser.parseRelationships(jdlFile);
    jdlLanguageParser.parseApplications(jdlFile);
    return jdlLanguageParser;
  }

}
