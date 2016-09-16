import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-word", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word-name");
      Word newWord = new Word(word);
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int wordId = Integer.parseInt(request.params(":id"));
      Word word = Word.find(wordId);
      model.put("word", word);
      model.put("template", "templates/word-display.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-definition", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int wordId = Integer.parseInt(request.queryParams("wordId"));
      Word word = Word.find(wordId);
      String definitionName = request.queryParams("definition-name");
      Definition newDefinition = new Definition(definitionName);
      word.addDefinition(newDefinition);
      model.put("word", word);
      model.put("template", "templates/word-display.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/definition/:wordId/:definitionId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int definitionId = Integer.parseInt(request.params(":definitionId"));
      int wordId = Integer.parseInt(request.params(":wordId"));
      Definition definition = Definition.find(definitionId);
      model.put("wordId", wordId);
      model.put("definition", definition);
      model.put("template", "templates/definition-display.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
