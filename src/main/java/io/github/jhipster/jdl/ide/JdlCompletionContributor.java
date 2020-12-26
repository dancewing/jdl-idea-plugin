package io.github.jhipster.jdl.ide;

import static com.intellij.patterns.PlatformPatterns.psiElement;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Iconable;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import io.github.jhipster.jdl.JdlConstant;
import io.github.jhipster.jdl.JdlIcons;
import io.github.jhipster.jdl.language.JdlFieldType;
import io.github.jhipster.jdl.language.validation.JdlValidation;
import io.github.jhipster.jdl.language.validation.JdlValidationMapping;
import io.github.jhipster.jdl.psi.JdlApplicationConfigBody;
import io.github.jhipster.jdl.psi.JdlApplicationDefinition;
import io.github.jhipster.jdl.psi.JdlComponent;
import io.github.jhipster.jdl.psi.JdlConfigArrayItem;
import io.github.jhipster.jdl.psi.JdlConfigBooleanItem;
import io.github.jhipster.jdl.psi.JdlConfigItem;
import io.github.jhipster.jdl.psi.JdlConfigNumberItem;
import io.github.jhipster.jdl.psi.JdlConfigStringItem;
import io.github.jhipster.jdl.psi.JdlEntityDefinition;
import io.github.jhipster.jdl.psi.JdlEntityTypeBody;
import io.github.jhipster.jdl.psi.JdlEnumDefinition;
import io.github.jhipster.jdl.psi.JdlFieldMember;
import io.github.jhipster.jdl.psi.JdlFieldTypeDefinition;
import io.github.jhipster.jdl.psi.JdlFieldValidation;
import io.github.jhipster.jdl.psi.JdlFile;
import io.github.jhipster.jdl.psi.JdlOptionDefinition;
import io.github.jhipster.jdl.psi.JdlPackageNameConfigItem;
import io.github.jhipster.jdl.psi.JdlRelationshipDefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

public class JdlCompletionContributor extends CompletionContributor {

  public JdlCompletionContributor() {
    PsiElementPattern.Capture<PsiElement> placePattern =
        psiElement().inFile(PlatformPatterns.instanceOf(JdlFile.class)).andNot(psiElement().inside(PsiComment.class));

    extend(CompletionType.BASIC, placePattern, new CompletionProvider<CompletionParameters>() {
      @Override
      protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext processingContext,
          @NotNull CompletionResultSet result) {
        PsiElement position = parameters.getPosition();

        GeneratedParserUtilBase.DummyBlock block = PsiTreeUtil.getParentOfType(position, GeneratedParserUtilBase.DummyBlock.class);

        if (block!=null) {
            
        }

        JdlComponent parent = PsiTreeUtil.getParentOfType(position, JdlComponent.class, false, JdlApplicationDefinition.class, JdlEnumDefinition.class, JdlEntityDefinition.class,
            JdlRelationshipDefinition.class, JdlOptionDefinition.class);
        if (parent == null) {
          result.addElement(LookupElementBuilder.create("application"));
          result.addElement(LookupElementBuilder.create("entity"));
          result.addElement(LookupElementBuilder.create("enum"));
          result.addElement(LookupElementBuilder.create("service"));
          result.addElement(LookupElementBuilder.create("paginate"));
          result.addElement(LookupElementBuilder.create("microservice"));
          result.addElement(LookupElementBuilder.create("relationship"));
        }

        JdlConfigItem jdlConfigItem = PsiTreeUtil.getParentOfType(position, JdlConfigItem.class);
        if (jdlConfigItem != null) {
          System.out.println("in config item block");
        }
        JdlFieldMember fieldMember = PsiTreeUtil.getParentOfType(position, JdlFieldMember.class);
        if (fieldMember != null) {
          System.out.println("in field member block");
          JdlFieldMember prevSiblingOfType = PsiTreeUtil.getPrevSiblingOfType(fieldMember, JdlFieldMember.class);
          if (prevSiblingOfType!=null) {
            autoCompletion(parameters, prevSiblingOfType, result);
          }
        } else {
          JdlEntityTypeBody entityTypeBody = PsiTreeUtil.getParentOfType(position, JdlEntityTypeBody.class, false);
          if (entityTypeBody != null) {
            System.out.println("in entity body end");
            JdlFieldMember prevSiblingFieldMember = PsiTreeUtil.getPrevSiblingOfType(position, JdlFieldMember.class);
            if (prevSiblingFieldMember!=null) {
              autoCompletion(parameters, prevSiblingFieldMember, result);
            }
          }
        }
        if (position instanceof LeafPsiElement) {
          //| 'application' | 'entity' |  'enum' | 'service' | 'paginate' | 'microservice' | 'relationship'

        }

      }
    });
    extend(CompletionType.BASIC, placePattern.withParent(psiElement(JdlApplicationConfigBody.class)), new CompletionProvider<CompletionParameters>() {
      @Override
      protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context,
          @NotNull CompletionResultSet result) {
        PsiElement position = parameters.getPosition();
        JdlConfigItem jdlConfigItem = PsiTreeUtil.getParentOfType(position, JdlConfigItem.class);
        if (jdlConfigItem != null) {

          JdlConfigArrayItem configArrayItem = PsiTreeUtil.getChildOfAnyType(position, JdlConfigArrayItem.class);
          JdlConfigBooleanItem configBooleanItem = PsiTreeUtil.getChildOfAnyType(position, JdlConfigBooleanItem.class);
          JdlConfigNumberItem configNumberItem = PsiTreeUtil.getChildOfAnyType(position, JdlConfigNumberItem.class);
          JdlConfigStringItem configStringItem = PsiTreeUtil.getChildOfAnyType(position, JdlConfigStringItem.class);
          JdlPackageNameConfigItem packageNameConfigItem = PsiTreeUtil.getChildOfAnyType(position, JdlPackageNameConfigItem.class);

          //result.addElement(LookupElementBuilder.create("Hello1"));
        } else {
          result.addElement(LookupElementBuilder.create("Hello2"));
        }
      }
    });

    extend(CompletionType.BASIC, placePattern.inside(psiElement(JdlConfigItem.class)),
        new CompletionProvider<CompletionParameters>() {
          public void addCompletions(@NotNull CompletionParameters parameters,
              @NotNull ProcessingContext context,
              @NotNull CompletionResultSet result) {
            PsiElement position = parameters.getPosition();
            JdlConfigItem jdlConfigItem = PsiTreeUtil.getParentOfType(position, JdlConfigItem.class);
            if (jdlConfigItem != null) {

              JdlConfigArrayItem configArrayItem = PsiTreeUtil.getChildOfAnyType(position, JdlConfigArrayItem.class);
              JdlConfigBooleanItem configBooleanItem = PsiTreeUtil.getChildOfAnyType(position, JdlConfigBooleanItem.class);
              JdlConfigNumberItem configNumberItem = PsiTreeUtil.getChildOfAnyType(position, JdlConfigNumberItem.class);
              JdlConfigStringItem configStringItem = PsiTreeUtil.getChildOfAnyType(position, JdlConfigStringItem.class);
              JdlPackageNameConfigItem packageNameConfigItem = PsiTreeUtil.getChildOfAnyType(position, JdlPackageNameConfigItem.class);

              result.addElement(LookupElementBuilder.create("Hello1"));
            } else {
              result.addElement(LookupElementBuilder.create("Hello2"));
            }
          }
        });

    extend(CompletionType.BASIC, placePattern.withParent(psiElement(JdlFieldMember.class)),
        new CompletionProvider<CompletionParameters>() {
          public void addCompletions(@NotNull CompletionParameters parameters,
              @NotNull ProcessingContext context,
              @NotNull CompletionResultSet resultSet) {
            PsiElement position = parameters.getPosition();
            JdlFieldMember fieldMember = PsiTreeUtil.getParentOfType(position, JdlFieldMember.class);
            if (fieldMember != null) {
              System.out.println(fieldMember.getComponentName().getText());
            }
            resultSet.addElement(LookupElementBuilder.create("Double"));
          }
        });

    extend(CompletionType.BASIC, placePattern.withParent(psiElement(JdlFieldTypeDefinition.class)),
        new CompletionProvider<CompletionParameters>() {
          public void addCompletions(@NotNull CompletionParameters parameters,
              @NotNull ProcessingContext context,
              @NotNull CompletionResultSet resultSet) {

            PsiElement position = parameters.getPosition();
            JdlFieldMember fieldMember = PsiTreeUtil.getParentOfType(position, JdlFieldMember.class);

            if (fieldMember!=null) {
               autoCompletion(parameters, fieldMember, resultSet);
            }
          }
        });
  }

  private void autoCompletion(CompletionParameters parameters, JdlFieldMember fieldMember, CompletionResultSet result) {
    String fieldTypeText = fieldMember.getFieldTypeDefinition().getText();
    boolean hasFieldName = StringUtils.isNotEmpty(fieldMember.getComponentName().getText());
    boolean hasFieldType = StringUtils.isNotEmpty(fieldTypeText) && !org.apache.commons.lang3.StringUtils.equals(fieldTypeText, JdlConstant.NO_RULE_APPLY);
    boolean hasValidation = fieldMember.getFieldValidations() != null && fieldMember.getFieldValidations().getFieldValidationList().size() > 0;
    if (hasFieldName) {
      if (hasFieldType) {
        JdlFieldType jdlFieldType = JdlFieldType.from(fieldTypeText);
        if (jdlFieldType == null) {
          jdlFieldType = JdlFieldType.Enum;
        }
        List<String> validationNames = JdlValidationMapping.getValidationNames(jdlFieldType.getValidations());
        if (hasValidation) {
          List<JdlFieldValidation> validationList = fieldMember.getFieldValidations().getFieldValidationList();
          List<String> existingValidations = new ArrayList<>();
          for (JdlFieldValidation fieldValidation : validationList) {
            String validation = fieldValidation.getText();
            String prefix = validation;
            if (org.apache.commons.lang3.StringUtils.indexOf(validation, "(") > 0) {
              prefix = org.apache.commons.lang3.StringUtils.substringBefore(validation, "(").trim();
            }
            JdlValidation jdlValidation = JdlValidationMapping.from(prefix, validation);
            existingValidations.add(jdlValidation.getName());
          }
          validationNames = validationNames.stream().filter(type -> !existingValidations.contains(type)).collect(Collectors.toList());

        }
        for (String validation : validationNames) {
          result.addElement(LookupElementBuilder.create(validation));
        }

      } else {

        List<JdlFieldType> fieldTypes = JdlFieldType.ALL_WITHOUT_ENUM;
        for (JdlFieldType jdlFieldType : fieldTypes) {
          result.addElement(LookupElementBuilder.create(jdlFieldType.getType()).withIcon(JdlIcons.TYPE));
        }
        //Add enum to auto completion
        JdlFile jdlFile = (JdlFile) parameters.getOriginalFile();
        List<JdlEnumDefinition> enumDefinitions = jdlFile.getEnumDefinitions();
        if (enumDefinitions != null) {
          for (JdlEnumDefinition enumDefinition : enumDefinitions) {
            String enumName = enumDefinition.getComponentName().getText();
            result.addElement(LookupElementBuilder.create(enumName).withIcon(JdlIcons.ENUM));
          }
        }
        //TODO Sort the items
      }
    }

  }
}
