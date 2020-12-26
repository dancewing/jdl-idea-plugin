import io.github.jhipster.jdl.language.JdlApplicationConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class ApplicationConfigTest {

  @Test
  public void testListOptions() {
    Field[] fields = JdlApplicationConfig.class.getDeclaredFields();
    List<String> strFields = new ArrayList<>();
    List<String> booleanFields = new ArrayList<>();
    List<String> intFields = new ArrayList<>();
    List<String> arrayFields = new ArrayList<>();

    List<String> allFields = new ArrayList<>();

    for (Field field : fields) {
      String type = field.getType().getSimpleName();
      String name = field.getName();
      allFields.add(name);

      name = "'" + name + "'";
      if (StringUtils.equals("String", type)) {
        strFields.add(name);
      } else if (StringUtils.equals("boolean", type)) {
        booleanFields.add(name);
      } else if (StringUtils.equals("int", type)) {
        intFields.add(name);
      } else if (StringUtils.equals("List", type)) {
        arrayFields.add(name);
      }
    }
    System.out.println(StringUtils.join(strFields, "|"));
    System.out.println(StringUtils.join(booleanFields, "|"));
    System.out.println(StringUtils.join(intFields, "|"));
    System.out.println(StringUtils.join(arrayFields, "|"));

    for (String name : allFields) {
      System.out.println(StringUtils.upperCase(name) + " = '" + name + "'");
    }

    for (String name : allFields) {
      System.out.println("<YYINITIAL, LONG_TEMPLATE_ENTRY> \""+ name +"\"               { return "+ StringUtils.upperCase(name) +"; }");
    }

    System.out.println(StringUtils.join(allFields.stream().map(StringUtils::upperCase).collect(Collectors.toList()), ","));

  }

}
