package io.github.jhipster.jdl.language.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdlValidationMapping {

  private static Map<String, Class<? extends JdlValidation>> mappings = new HashMap<>();

  static {
    mappings.put("maxbytes", JdlMaxBytesValidation.class);
    mappings.put("maxlength", JdlMaxLengthValidation.class);
    mappings.put("max", JdlMaxValidation.class);
    mappings.put("minbytes", JdlMinBytesValidation.class);
    mappings.put("minlength", JdlMinLengthValidation.class);
    mappings.put("min", JdlMinValidation.class);
    mappings.put("pattern", JdlPatternValidation.class);
    mappings.put("required", JdlRequiredValidation.class);
    mappings.put("unique", JdlUniqueValidation.class);
  }

  public static JdlValidation from(String prefix, String value) {
    Class<? extends JdlValidation> vclass = mappings.get(prefix);
    if (vclass != null) {
      try {
        JdlValidation jdlValidation = vclass.getDeclaredConstructor().newInstance();
        jdlValidation.setValue(value);
        return jdlValidation;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public static List<String> getValidationNames(List<Class<? extends JdlValidation>> validations) {
    List<String> names = new ArrayList<>();
    for (Class<? extends JdlValidation> vclass : validations) {
        if (mappings.containsValue(vclass)) {
          try {
            JdlValidation jdlValidation = vclass.getDeclaredConstructor().newInstance();
            names.add(jdlValidation.getName());
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
    }
    return names;
  }

}
